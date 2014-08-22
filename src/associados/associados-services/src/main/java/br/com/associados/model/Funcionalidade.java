package br.com.associados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Funcionalidades")
public class Funcionalidade {
	@Id
	private Long id;

	@Column
	private String nome;
}
