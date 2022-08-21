package academy.devdojo.springboot2.domain;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Midia {
	//Modelo para o banco de dados criar espelhado
	private String titulo;
	private String genero;
	private String user;
	private String sinopse;
	private String descricao;
	private float avaliacao;
	private String status;

}
