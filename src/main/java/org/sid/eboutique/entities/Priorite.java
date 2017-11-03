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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="priorite")
public class Priorite implements Serializable {
	public Priorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Priorite(String namePrio) {
		super();
		this.namePrio = namePrio;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prio_id")
	private Long idPrio;
	private String namePrio;
	@OneToMany(mappedBy="priorite")
	private Collection<Ticket> tickets=new ArrayList<Ticket>();
	public Long getIdPrio() {
		return idPrio;
	}
	public void setIdPrio(Long idPrio) {
		this.idPrio = idPrio;
	}
	public Collection<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}
	public String getNamePrio() {
		return namePrio;
	}
	public void setNamePrio(String namePrio) {
		this.namePrio = namePrio;
	}
	
	
}
