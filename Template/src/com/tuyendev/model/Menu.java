package com.tuyendev.model;

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Tuyen Nguyen
 */
public class Menu implements Serializable {

    private Long menuId;

    private String name;

    private String desc;

    private String link;

    private String styleClass;
    
    private boolean activeMenu;

    private List<SubMenu> subMenuList;

    public Menu() {
    }

    public Menu(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setSubMenuList(List<SubMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public List<SubMenu> getSubMenuList() {
        return subMenuList;
    }


    public void setActiveMenu(boolean activeMenu) {
        this.activeMenu = activeMenu;
    }

    public boolean isActiveMenu() {
        return activeMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) ||
            (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuyendev.model.Menu[ menuId=" + menuId + " ]";
    }

}
