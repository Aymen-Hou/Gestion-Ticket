package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="statut")
public class Statut implements Serializable{
	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Statut(String nameStatut) {
		super();
		this.nameStatut = nameStatut;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="statut_id")
	private Long idStatut;
	private String nameStatut;
	@OneToMany(mappedBy="statut")
	private Collection<Ticket> tickets=new ArrayList<Ticket>();
	public Long getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(Long idStatut) {
		this.idStatut = idStatut;
	}
	public String getNameStatut() {
		return nameStatut;
	}
	public void setNameStatut(String nameStatut) {
		this.nameStatut = nameStatut;
	}
	public Collection<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}
}
