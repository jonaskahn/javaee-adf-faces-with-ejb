/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuyendev.entities;

import com.tuyendev.dto.MenuDTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tuyen Nguyen
 */
@Entity
@Table(name = "SUB_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubMenu.findAll", query = "SELECT s FROM SubMenu s")})
public class SubMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUB_MENU_ID")
    @GeneratedValue(generator = "SUB_MENU_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SUB_MENU_SEQ_GEN", sequenceName = "SUB_MENU_SEQ",allocationSize=1)
    private Long subMenuId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LINK")
    private String link;
    @Column(name = "STYLE_CLASS")
    private String styleClass;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
    @ManyToOne
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

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
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
        if ((this.subMenuId == null && other.subMenuId != null) || (this.subMenuId != null && !this.subMenuId.equals(other.subMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuyendev.entities.SubMenu[ subMenuId=" + subMenuId + " ]";
    }
}
