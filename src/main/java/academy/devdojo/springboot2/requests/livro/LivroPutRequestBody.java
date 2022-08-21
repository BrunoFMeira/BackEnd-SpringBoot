package academy.devdojo.springboot2.requests.livro;

import lombok.Data;

@Data
public class LivroPutRequestBody {
	//Corpo de requisição put
	private Long id;
	private String titulo;
	private String genero;
	private String user;
	private String sinopse;
	private String descricao;
	private float avaliacao;
	private String status;
	private int paginas;
	private String autor;
	private String editora;

}
