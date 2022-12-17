package com.edujguerra.spring.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")	
	private Long id;		
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private String dtaInicio;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private String dtaFinal;
	
	private String desTipoMov;	
	private Long idConteiner;
	
	@Transient
	private Conteiner container;
	
	@Transient
	private String dataInicio,dataFinal;
	
	@Transient
	private String data;	
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getDesTipoMov() {
		return desTipoMov;
	}
	public void setDesTipoMov(String desTipoMov) {
		this.desTipoMov = desTipoMov;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Conteiner getContainer() {
		return container;
	}
	public void setContainer(Conteiner container) {
		this.container = container;
	}
	public Long getIdConteiner() {
		return idConteiner;
	}
	public void setIdConteiner(Long idConteiner) {
		this.idConteiner = idConteiner;
	}
	
	public String getDtaInicio() {
		return dtaInicio;
	}
	public void setDtaInicio(String dtaInicio) {
		this.dtaInicio = dtaInicio;
	}
	public String getDtaFinal() {
		return dtaFinal;
	}
	public void setDtaFinal(String dtaFinal) {
		this.dtaFinal = dtaFinal;
	}
	
	
	public String getDescricaoTipoMov() {
		if (this.desTipoMov.equals("0")) {
			return "Embarque";
		} else if (this.desTipoMov.equals("1")) {
			return "Descarga";
		} else if (this.desTipoMov.equals("2")) {
			return "Gatein";
		} else if (this.desTipoMov.equals("3")) {
			return "Gateout";
		} else if (this.desTipoMov.equals("4")) {
			return "Reposicionamento";
		} else if (this.desTipoMov.equals("5")) {
			return "Pesagem";
		} else if (this.desTipoMov.equals("6")) {
			return "Scanner";
		}						
		return "";			
	}
	
	public String getDataInicio() {
		return formataData(dtaInicio.toString());
	}
	public String getDataFinal() {
		return formataData(dtaFinal.toString());
	}

	public String formataData(String dta) {
		String ano = dta.substring(0,4);
		String mes = dta.substring(5,7);
		String dia = dta.substring(8,10);
		
		String hora = dta.substring(11,13);
		String min = dta.substring(14,16);
		
		return dia + "/" + mes + "/" + ano + " " + hora + ":" + min;
	}
	
}
