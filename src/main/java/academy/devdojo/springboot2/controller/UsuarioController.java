package academy.devdojo.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springboot2.domain.Usuario;
import academy.devdojo.springboot2.requests.usuario.UsuarioPostRequestBody;
import academy.devdojo.springboot2.requests.usuario.UsuarioPutRequestBody;
import academy.devdojo.springboot2.service.UsuarioService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("usuarios")
@Log4j2
@RequiredArgsConstructor
public class UsuarioController {
	private final DateUtil dateUtil;
	private final UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> list() {
		//Classe Controladora que faz as operações RestFull
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(usuarioService.listAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {
		return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Usuario>> findByNome(@RequestParam(required = false) String nome) {
		return ResponseEntity.ok(usuarioService.findByNome(nome));
	}

	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioPostRequestBody usuario) {
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		usuarioService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody UsuarioPutRequestBody usuario) {
		usuarioService.replace(usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
