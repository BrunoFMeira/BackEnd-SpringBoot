package academy.devdojo.springboot2.requests.filme;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class FilmePostRequestBody {
	//Corpo de requisição post
	@NotEmpty
	private String titulo;
	private float duracao;
	private String user;
	private String diretor;
	private String atores;
	private String genero;
	private String sinopse;
	private String descricao;
	private float avaliacao;
	private String status;
}
