package com.wbarcellosn.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRO")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro")
	@SequenceGenerator(name = "seq_carro", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "MODELO", length = 40, nullable = false)
	private String modelo;
	
	@Column(name = "ANO", length = 4, nullable = false)
	private Integer ano;
	
	@ManyToOne
    @JoinColumn(name = "MARCA_ID", nullable = false)
	private Marca marca;
	
	@ManyToMany
    @JoinTable(
        name = "TB_CARRO_ACESSORIO",
        joinColumns = @JoinColumn(name = "CARRO_ID_FK"),
        inverseJoinColumns = @JoinColumn(name = "ACESSORIO_ID_FK")
    )
    private Set<Acessorio> acessorios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	
	

}
