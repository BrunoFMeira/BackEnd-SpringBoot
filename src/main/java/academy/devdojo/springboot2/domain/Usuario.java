package academy.devdojo.springboot2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Usuario {
	//Modelo para o banco de dados criar espelhado
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment" , strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	private String nome;
	private String senha;

}
