package org.sid.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Commentaire implements Serializable {
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdCom() {
		return idCom;
	}
	public void setIdCom(Long idCom) {
		this.idCom = idCom;
	}

	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCom;
	private String commentaire;
	private Long id_Tick;
	public Commentaire(Long idCom, String commentaire, Long id_Tick) {
		super();
		this.idCom = idCom;
		this.commentaire = commentaire;
		this.id_Tick = id_Tick;
	}
	public Long getId_Tick() {
		return id_Tick;
	}
	public void setId_Tick(Long id_Tick) {
		this.id_Tick = id_Tick;
	}


}
