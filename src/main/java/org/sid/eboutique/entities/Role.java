package org.sid.eboutique.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idRole;
private String roleName;
public Long getIdRole() {
	return idRole;
}
public void setIdRole(Long idRole) {
	this.idRole = idRole;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public Role(String roleName) {
	super();
	this.roleName = roleName;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}

}
