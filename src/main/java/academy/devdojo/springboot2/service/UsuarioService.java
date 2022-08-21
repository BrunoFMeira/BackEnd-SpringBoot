package academy.devdojo.springboot2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Usuario;
import academy.devdojo.springboot2.repository.UsuarioRepository;
import academy.devdojo.springboot2.requests.usuario.UsuarioPostRequestBody;
import academy.devdojo.springboot2.requests.usuario.UsuarioPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public List<Usuario> listAll() {
		return usuarioRepository.findAll();
	}

	public List<Usuario> findByNome(String nome) {
		return usuarioRepository.findByNome(nome);
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Midia not found"));
	}

	@Transactional
	public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody) {
		return usuarioRepository.save(Usuario.builder().nome(usuarioPostRequestBody.getNome())
				.senha(usuarioPostRequestBody.getSenha()).build());
	}

	@Transactional
	public void delete(long id) {
		usuarioRepository.delete(findById(id));

	}

	@Transactional
	public void replace(UsuarioPutRequestBody usuarioPutRequestBody) {
		Usuario savedUsuario = findById(usuarioPutRequestBody.getId());
		Usuario usuario = Usuario.builder().id(savedUsuario.getId()).nome(savedUsuario.getNome())
				.senha(usuarioPutRequestBody.getSenha()).build();

		usuarioRepository.save(usuario);
	}
}
