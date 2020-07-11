package com.newer.tang.data.entity;

public class Role {
	private int roleId;//½ÇÉ«±àºÅ
	private String roleName;//½ÇÉ«Ãû³Æ
	private String roleDesc;//½ÇÉ«ÃèÊö
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDesc=" + roleDesc + "]";
	}
	
}
