package com.tuyendev.setting;

import com.google.common.collect.*;

import com.tuyendev.common.Constant;
import com.tuyendev.common.ContextUtil;
import com.tuyendev.common.ServiceName;
import com.tuyendev.entities.Menu;
import com.tuyendev.entities.SubMenu;
import com.tuyendev.fw.DataUtil;
import com.tuyendev.inf.MenuFacadeRemote;

import java.io.Serializable;

import java.util.*;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import one.util.streamex.StreamEx;

import oracle.adf.share.ADFContext;
import oracle.adf.share.logging.ADFLogger;

public class AppSetting implements Serializable {

    public final static ADFLogger logger = ADFLogger.createADFLogger(AppSetting.class);

    private List<Menu> lstMenu = Lists.newArrayList();
    private SubMenu activeMenu;
    private Map<String, SubMenu> mapMenu = Maps.newHashMap();

    private MenuFacadeRemote menuService;

    @PostConstruct
    public void initMenu() {
        try {
            menuService =
                (MenuFacadeRemote) ContextUtil.getRemoteContext()
                .lookup(ServiceName.EJB_MAPPED_NAME.MENU_FACADE + "#" + MenuFacadeRemote.class.getTypeName());
            activeMenu = new SubMenu();
            lstMenu = menuService.findAll();
            if (!DataUtil.isNullOrEmpty(lstMenu)) {
                List<SubMenu> lsSubMenu = Lists.newArrayList();
                lstMenu.forEach(o -> { lsSubMenu.addAll(o.getSubMenuList()); });
                mapMenu = StreamEx.of(lsSubMenu).toMap(SubMenu::getLink, Function.identity());
            }
        } catch (Exception e) {
            logger.severe(e.getMessage(), e);
        }
    }


    public void setLstMenu(List<Menu> lstMenu) {
        this.lstMenu = lstMenu;
    }

    public List<Menu> getLstMenu() {
        return lstMenu;
    }

    public void setActiveMenu(SubMenu activeMenu) {
        this.activeMenu = activeMenu;
    }

    public SubMenu getActiveMenu() {
        String currentMenu = (String) ADFContext.getCurrent()
                                                .getSessionScope()
                                                .get(Constant.SUB_MENU_ID);
        SubMenu sub = !DataUtil.isNullObject(currentMenu) ? mapMenu.get(currentMenu) : null;

        if (!DataUtil.isNullObject(activeMenu) && !DataUtil.isNullObject(activeMenu.getMenuId())) {
            activeMenu.getMenuId().setStyleClass("");
            activeMenu.setStyleClass("");
        }
        if (!DataUtil.isNullObject(sub)) {
            sub.getMenuId().setStyleClass("active");
            sub.setStyleClass("active-sub-menu");
            activeMenu = sub;
        }
        return activeMenu;
    }


}
