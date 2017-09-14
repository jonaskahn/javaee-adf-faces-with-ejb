package com.tuyendev.dto;

import java.io.Serializable;

public class SubMenuDTO implements Serializable {

	//VARIABLES
	private Long subMenuId;
	private String name;
	private String link;
	private String description;
	private MenuDTO menuId;
	private String styleClass;

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

	public MenuDTO getMenuId() {
		return this.menuId;
	}

	public void setMenuId(MenuDTO menuId) {
		this.menuId = menuId;
	}

	public String getStyleClass() {
		return this.styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

}
