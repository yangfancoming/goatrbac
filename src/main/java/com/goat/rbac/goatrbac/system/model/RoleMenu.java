package com.goat.rbac.goatrbac.system.model;


import java.io.Serializable;

public class RoleMenu implements Serializable {
	
	private static final long serialVersionUID = -7573904024872252113L;

    private Long roleId;

    private Long menuId;

    public RoleMenu(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}