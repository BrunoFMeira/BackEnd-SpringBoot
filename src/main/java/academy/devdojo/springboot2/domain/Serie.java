package academy.devdojo.springboot2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Serie extends Midia {
	//Modelo para o banco de dados criar espelhado
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment" , strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	private int epsodios;
	private String diretor;
	private int temporadas;
	private String atores;
}