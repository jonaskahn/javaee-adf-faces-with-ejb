package com.tuyendev.setting;

import com.fasterxml.jackson.core.type.TypeReference;

import com.google.common.collect.*;

import com.tuyendev.common.Constant;

import com.tuyendev.fw.DataUtil;

import com.tuyendev.mapper.JsonMapper;

import com.tuyendev.model.Menu;
import com.tuyendev.model.SubMenu;

import java.io.Serializable;

import java.net.URL;

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
    private Map<String, SubMenu> mapSubMenus = Maps.newHashMap();


    @PostConstruct
    public void initMenu() {
        try {
            activeMenu = new SubMenu();
            doCreateMenu();
        } catch (Exception e) {
            logger.severe(e.getMessage(), e);
        }
    }

    private void doCreateMenu() throws Exception {
        lstMenu = JsonMapper.jsonToList(new TypeReference<List<Menu>>() {
        }, new URL(Constant.MENU.MENU_LINK));
        List<SubMenu> lsSubMenu = JsonMapper.jsonToList(new TypeReference<List<SubMenu>>() {
        }, new URL(Constant.MENU.SUB_MENU_LINK));
        mapSubMenus = StreamEx.of(lsSubMenu).toMap(SubMenu::getLink, Function.identity());
        
        //Fill up data
        Map<Long,Menu> mapMenus = StreamEx.of(lstMenu).toMap(Menu::getMenuId, Function.identity());
        Map<Long,List<SubMenu>> mapListSubMenus = StreamEx.of(lsSubMenu).groupingBy(SubMenu::getMenuId);
        
        mapMenus.forEach((menuId,menuDTO) ->{
            List<SubMenu> temps = mapListSubMenus.get(menuId);
            temps.forEach(x->x.setMenuDTO(menuDTO));
            menuDTO.setSubMenuList(temps);
        });
        
        
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
        SubMenu sub = !DataUtil.isNullObject(currentMenu) ? mapSubMenus.get(currentMenu) : null;

        if (!DataUtil.isNullObject(activeMenu) && !DataUtil.isNullObject(activeMenu.getMenuId())) {
            activeMenu.getMenuDTO().setStyleClass("");
            activeMenu.setStyleClass("");
        }
        if (!DataUtil.isNullObject(sub)) {
            sub.getMenuDTO().setStyleClass("active");
            sub.setStyleClass("active-sub-menu");
            activeMenu = sub;
        }
        return activeMenu;
    }


}
