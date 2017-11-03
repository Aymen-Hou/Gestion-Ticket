package org.sid.eboutique.entities;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="localite")
public class Localite {

	public Localite(String nameLocalite, Collection<Categorie> categories) {
		super();
		this.nameLocalite = nameLocalite;
		this.categories = categories;
	}
	public Localite() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="localite_id")
	private Long idLocalite;
	private String nameLocalite;
	@OneToMany(mappedBy="localite")
	private Collection<Categorie> categories=new ArrayList<Categorie>();
	public Long getIdLocalite() {
		return idLocalite;
	}
	public void setIdLocalite(Long idLocalite) {
		this.idLocalite = idLocalite;
	}
	public String getNameLocalite() {
		return nameLocalite;
	}
	public void setNameLocalite(String nameLocalite) {
		this.nameLocalite = nameLocalite;
	}
}
