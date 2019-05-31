package br.com.microservices.h2service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
	
	public Cliente() {}
	
	public Cliente(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private int idade;
	private String telefone;

}