package academy.devdojo.springboot2.requests.usuario;

import lombok.Data;

@Data
public class UsuarioPutRequestBody {
	//Corpo de requisição put
	private long id;
	private String nome;
	private String senha;
	
}
