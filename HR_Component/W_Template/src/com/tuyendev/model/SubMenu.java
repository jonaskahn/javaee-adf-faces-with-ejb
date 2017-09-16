package com.tuyendev.model;

import java.io.Serializable;

public class SubMenu implements Serializable {

    //VARIABLES
    private Long subMenuId;
    private String name;
    private String link;
    private String description;
    private Long menuId;
    private String styleClass;
    private Menu menuDTO = new Menu();

    //GETTER-SETTER
    public Long getSubMenuId() {
        return this.subMenuId;
    }

    public void setSubMenuId(Long subMenuId) {
        this.subMenuId = subMenuId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuDTO(Menu menuDTO) {
        this.menuDTO = menuDTO;
    }

    public Menu getMenuDTO() {
        return menuDTO;
    }

    public String getStyleClass() {
        return this.styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

}
