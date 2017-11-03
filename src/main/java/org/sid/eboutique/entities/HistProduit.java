package org.sid.eboutique.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class HistProduit implements Serializable {


	public HistProduit(Date dateHProd, boolean actif, String operationProd,
			String nameProd, int type, Long idSite) {
		super();
		this.dateHProd = dateHProd;
		this.actif = actif;
		this.operationProd = operationProd;
		this.nameProd = nameProd;
		this.type = type;
		this.idSite = idSite;
		
	}
	@Id
	@GeneratedValue
	private Long idHProd;
	public HistProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Date dateHProd;
	private boolean actif;
	private String operationProd;
	private String nameProd;
	private int type;
	private Long idSite;



	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public Long getIdSite() {
		return idSite;
	}
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	public Long getIdHProd() {
		return idHProd;
	}
	public void setIdHProd(Long idHProd) {
		this.idHProd = idHProd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getDateHProd() {
		return dateHProd;
	}
	public void setDateHProd(Date dateHProd) {
		this.dateHProd = dateHProd;
	}
	public String getOperationProd() {
		return operationProd;
	}
	public void setOperationProd(String operationProd) {
		this.operationProd = operationProd;
	}
	public String getNameProd() {
		return nameProd;
	}
	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}
}
