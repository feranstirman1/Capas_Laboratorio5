package com.uca.capas.tareaLabo5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {

	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cUsuario;
	
	@Column(name="nombre")
	@Size(message="El nombre de puede contener mas de 50 caracteres",max=50)
	@NotEmpty(message="Este campo no puede quedar vacio")
	private String nombre;
	
	@Column(name="apellido")
	@Size(message="El apellido de puede contener mas de 50 caracteres",max=50)
	@NotEmpty(message="Este campo no puede quedar vacio")
	private String apellido;
	
	@Column(name="carne")
	@Size(message="El carnet de puede contener mas de 10 caracteres",max=10)
	@NotEmpty(message="Este campo no puede quedar vacio")
	private String carnet;
	
	@Column(name="carrera")
	@Size(message="La carrera de puede contener mas de 100 caracteres",max=100)
	@NotEmpty(message="Este campo no puede quedar vacio")
	private String carrera;
	
	public Integer getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}
