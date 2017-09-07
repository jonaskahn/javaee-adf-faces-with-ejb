package com.tuyendev.model;

import java.io.Serializable;


/**
 *
 * @author Tuyen Nguyen
 */

public class SubMenu implements Serializable {


    private Long subMenuId;
    private String name;
    private String link;
    private String description;
    private String styleClass;
    private boolean activeSubMenu;
    private Menu menuId;

    public SubMenu() {
    }

    public SubMenu(Long subMenuId) {
        this.subMenuId = subMenuId;
    }

    public Long getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(Long subMenuId) {
        this.subMenuId = subMenuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }


    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getStyleClass() {
        return styleClass;
    }


    public void setActiveSubMenu(boolean activeSubMenu) {
        this.activeSubMenu = activeSubMenu;
    }

    public boolean isActiveSubMenu() {
        return activeSubMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subMenuId != null ? subMenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubMenu)) {
            return false;
        }
        SubMenu other = (SubMenu) object;
        if ((this.subMenuId == null && other.subMenuId != null) ||
            (this.subMenuId != null && !this.subMenuId.equals(other.subMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuyendev.model.SubMenu[ subMenuId=" + name + " ]" +"[ menuId = "+ menuId.getName()+" ]";
    }

}
