package academy.devdojo.springboot2.requests.serie;

import lombok.Data;

@Data
public class SeriePutRequestBody {
	//Corpo de requisição put
	private Long id;
	private String titulo;
	private String genero;
	private String user;
	private String sinopse;
	private String descricao;
	private float avaliacao;
	private String status;
	private int epsodios;
	private String diretor;
	private String atores;
	private int temporadas;

}
