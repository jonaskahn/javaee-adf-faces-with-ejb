package com.tuyendev.dto;

import java.io.Serializable;
import java.util.*;

public class MenuDTO implements Serializable {

	//VARIABLES
	private List<SubMenuDTO> subMenuList;
	private String name;
	private String link;
	private Long menuId;
	private String description;
	private String styleClass;

	//GETTER-SETTER
	public List<SubMenuDTO> getSubMenuList() {
		return this.subMenuList;
	}

	public void setSubMenuList(List<SubMenuDTO> subMenuList) {
		this.subMenuList = subMenuList;
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

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStyleClass() {
		return this.styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

}
