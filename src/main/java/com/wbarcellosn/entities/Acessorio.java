package com.wbarcellosn.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ACESSORIO")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acessorio")
	@SequenceGenerator(name = "seq_acessorio", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "NOME", length = 40, nullable = false)
	private String nome;

	 @ManyToMany(mappedBy = "acessorios")
	 private Set<Carro> carros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}
	
}
