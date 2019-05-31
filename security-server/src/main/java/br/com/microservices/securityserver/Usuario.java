package br.com.microservices.securityserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	public Usuario() {}
	
	public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

	@Id
	@GeneratedValue
	private int id;
	private String usuario;
	private String senha;

}