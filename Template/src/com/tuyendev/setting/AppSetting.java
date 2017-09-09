package com.tuyendev.setting;

import com.google.common.collect.*;

import com.tuyendev.common.Constant;
import com.tuyendev.common.CookieUtil;
import com.tuyendev.fw.DataUtil;
import com.tuyendev.model.*;

import java.io.Serializable;

import java.util.*;

import java.util.function.Function;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.Cookie;

import one.util.streamex.StreamEx;

import oracle.adf.share.logging.ADFLogger;

public class AppSetting implements Serializable {

    public final static ADFLogger logger = ADFLogger.createADFLogger(AppSetting.class);

    private List<Menu> lstMenu = Lists.newArrayList();
    private SubMenu activeMenu;
    private Map<String, SubMenu> mapMenu = Maps.newHashMap();

    @PostConstruct
    public void initMenu() {
        try {
            SubMenu sub01 = new SubMenu();
            sub01.setSubMenuId(1L);
            sub01.setName("Quan Ly");
            sub01.setDescription("TEST_LINK_01");
            sub01.setLink("test_01");
            sub01.setStyleClass("");

            SubMenu sub02 = new SubMenu();
            sub02.setSubMenuId(2L);
            sub02.setName("TESTED_02");
            sub02.setDescription("TEST_LINK_02");
            sub02.setLink("test_02");
            sub02.setStyleClass("");

            Menu menu = new Menu();
            menu.setLink("");
            menu.setDesc("TEST_01");
            menu.setMenuId(1L);
            menu.setName("TEST_MENU_01");

            menu.setSubMenuList(Lists.newArrayList(sub01, sub02));
            sub01.setMenuId(menu);
            sub02.setMenuId(menu);
            lstMenu.add(menu);

            SubMenu sub03 = new SubMenu();
            sub03.setSubMenuId(3L);
            sub03.setName("TESTED_03");
            sub03.setDescription("TEST_LINK_03");
            sub03.setLink("test_03");
            sub03.setStyleClass("");

            SubMenu sub04 = new SubMenu();
            sub04.setSubMenuId(4L);
            sub04.setName("TESTED_04");
            sub04.setDescription("TEST_LINK_04");
            sub04.setLink("test_04");
            sub04.setStyleClass("");

            Menu menu02 = new Menu();
            menu02.setLink("");
            menu02.setDesc("TEST_02");
            menu02.setMenuId(2L);
            menu02.setName("TEST_MENU_02");

            menu02.setSubMenuList(Lists.newArrayList(sub03, sub04));
            sub03.setMenuId(menu02);
            sub04.setMenuId(menu02);
            lstMenu.add(menu02);

            // set default active menu

            sub02.getMenuId().setStyleClass("active");
            sub02.setStyleClass("active-sub-menu");
            activeMenu = sub02;

            List<SubMenu> lsSubMenu = Lists.newArrayList();
            lstMenu.forEach(o -> { lsSubMenu.addAll(o.getSubMenuList()); });
            mapMenu = StreamEx.of(lsSubMenu).toMap(SubMenu::getLink, Function.identity());
            logger.info("DONE_INIT_MENU");
        } catch (Exception e) {
            logger.finest(e.getMessage(), e);
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
        Cookie cookie = CookieUtil.getCookie(FacesContext.getCurrentInstance(), Constant.SUB_MENU_ID);
        if (!DataUtil.isNullObject(cookie)) {
            String currentMenu = cookie.getValue();
            SubMenu sub = mapMenu.get(currentMenu);
            if (!DataUtil.isNullObject(sub) && !Objects.equals(activeMenu, sub)) {
                activeMenu.getMenuId().setStyleClass("");
                activeMenu.setStyleClass("");

                sub.getMenuId().setStyleClass("active");
                sub.setStyleClass("active-sub-menu");
                activeMenu = sub;
            }
        }
        return activeMenu;
    }
}
