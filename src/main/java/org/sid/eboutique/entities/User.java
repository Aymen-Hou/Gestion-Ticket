package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
@Entity
@Table(name="users")
public class User implements Serializable {
	
	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long idUser;
	private String userName;
	private String password;
	private boolean actived;
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Role> roles;
	@ManyToOne
	@JoinColumn(name="ID_Site")
	private Site site;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

}
