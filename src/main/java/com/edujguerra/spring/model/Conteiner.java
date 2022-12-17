package com.edujguerra.spring.model;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Conteiner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")	
	private Long id;
	private String desCliente;
	private String desNumero;
	private String desStatus;
	private String desTipo;
	private String desCategoria;
	
	@Transient
	private String statusCategoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesCliente() {
		return desCliente;
	}
	public void setDesCliente(String desCliente) {
		this.desCliente = desCliente;
	}
	public String getDesNumero() {
		return desNumero;
	}
	public void setDesNumero(String desNumero) {
		this.desNumero = desNumero;
	}
	public String getDesTipo() {
		return desTipo;
	}
	public void setDesTipo(String desTipo) {
		this.desTipo = desTipo;
	}
	public String getDesCategoria() {
		return desCategoria;
	}
	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}
	public String getDesStatus() {
		return desStatus;
	}
	public void setDesStatus(String desStatus) {
		this.desStatus = desStatus;
	}
	
	public String getStatusCategoria() {
		if (this.desCategoria.equals("0")) {
			return "Importação";
		} else if (this.desCategoria.equals("1")) {
			return "Exportação";
		} 					
		return "";		
	}
	
}
