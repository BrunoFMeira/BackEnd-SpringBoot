package academy.devdojo.springboot2.requests.usuario;

import javax.validation.constraints.NotEmpty;

import academy.devdojo.springboot2.requests.usuario.UsuarioPostRequestBody;
import lombok.Data;

@Data
public class UsuarioPostRequestBody {
	//Corpo de requisição post
	@NotEmpty
	private String nome;
	private String senha;
	

}
