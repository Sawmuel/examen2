package com.bezkoder.springgraphql.mysql.model;

import javax.persistence.*;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "pais")
	private String pais;

	public Author() {
	}

	public Author(Long id) {
		this.id = id;
	}

	public Author(String nombres, String apellidos, String pais) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", pais=" + pais + "]";
	}
	

}
