package com.starkindustries.springapp.domain3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

@Entity
@Table(name="TT_GUIA_CANALES_LEGACY")

public class TtcGuiaCanalesLegacy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.AUTO) <== En Oracle no existe el auto generate para PK
	private Integer id;
	
	@Column(name = "MSO_EMPRESA")
	private String msoEmpresa;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "NUM_CANAL")
	private String numCanal;
	
	@Column(name = "DESCRIPCION_CANAL")
	private String descCanal;
	
	@Column(name = "FLAG_MINI_BASICO")
	private String flagMiniBasico;
	
	@Column(name = "FLAG_BASICO")
	private String flagBasico;
	
	@Column(name = "STATUS")
	private String status;
	
	public TtcGuiaCanalesLegacy(){		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsoEmpresa() {
		return msoEmpresa;
	}

	public void setMsoEmpresa(String msoEmpresa) {
		this.msoEmpresa = msoEmpresa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNumCanal() {
		return numCanal;
	}

	public void setNumCanal(String numCanal) {
		this.numCanal = numCanal;
	}

	public String getDescCanal() {
		return descCanal;
	}

	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}

	public String getFlagMiniBasico() {
		return flagMiniBasico;
	}

	public void setFlagMiniBasico(String flagMiniBasico) {
		this.flagMiniBasico = flagMiniBasico;
	}

	public String getFlagBasico() {
		return flagBasico;
	}

	public void setFlagBasico(String flagBasico) {
		this.flagBasico = flagBasico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
