package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


@Entity
@Table(name="site")
public class Site implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSite")
	private Long idSite;
	private String nameSite;
	private String villeSite;
	@OneToMany(mappedBy="site")
	private Collection<User> users=new ArrayList<User>();
@OneToMany(mappedBy="site")
private Collection<Categorie> categories = new ArrayList<Categorie>();
@OneToMany(mappedBy="site")
private Collection<Produit> produits = new ArrayList<Produit>();
@OneToMany(mappedBy="site")
private Collection<Ticket> tickets = new ArrayList<Ticket>();
	public String getNameSite() {
		return nameSite;
	}
	public void setNameSite(String nameSite) {
		this.nameSite = nameSite;
	}
	public String getVilleSite() {
		return villeSite;
	}
	public void setVilleSite(String villeSite) {
		this.villeSite = villeSite;
	}
	public Collection<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}
	public Site(String nameSite, String villeSite) {
		super();
		this.nameSite = nameSite;
		this.villeSite = villeSite;
	}
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSite() {
		return idSite;
	}
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	

}
