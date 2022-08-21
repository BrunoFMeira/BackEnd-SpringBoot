package academy.devdojo.springboot2.requests.serie;

import javax.validation.constraints.NotEmpty;

import academy.devdojo.springboot2.requests.serie.SeriePostRequestBody;
import lombok.Data;

@Data
public class SeriePostRequestBody {
	//Corpo de requisição post
	@NotEmpty
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
