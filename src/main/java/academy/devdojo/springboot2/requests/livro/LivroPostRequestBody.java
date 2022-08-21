package academy.devdojo.springboot2.requests.livro;

import javax.validation.constraints.NotEmpty;

import academy.devdojo.springboot2.requests.livro.LivroPostRequestBody;
import lombok.Data;

@Data
public class LivroPostRequestBody {
	//Corpo de requisição post
	@NotEmpty
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
