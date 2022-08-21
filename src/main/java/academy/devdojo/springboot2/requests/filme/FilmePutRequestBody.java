package academy.devdojo.springboot2.requests.filme;

import lombok.Data;

@Data
public class FilmePutRequestBody {
	//Corpo de requisição put
	private Long id;
	private String titulo;
	private String user;
	private float duracao;
	private String diretor;
	private String atores;
	private String genero;
	private String tipo;
	private String sinopse;
	private String descricao;
	private float avaliacao;
	private String status;

}
