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

import academy.devdojo.springboot2.domain.Livro;
import academy.devdojo.springboot2.requests.livro.LivroPostRequestBody;
import academy.devdojo.springboot2.requests.livro.LivroPutRequestBody;
import academy.devdojo.springboot2.service.LivroService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("livros")
@Log4j2
@RequiredArgsConstructor
public class LivroController {
	//Classe Controladora que faz as operações RestFull
	private final DateUtil dateUtil;
	private final LivroService livroService;

	@GetMapping
	public ResponseEntity<List<Livro>> list() {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(livroService.listAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable long id) {
		return new ResponseEntity<>(livroService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Livro>> findByTitulo(@RequestParam(required = false) String titulo) {
		return ResponseEntity.ok(livroService.findByTitulo(titulo));
	}
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<Livro>> findByUser(@RequestParam(required = false) String user) {
		return ResponseEntity.ok(livroService.findByUser(user));
	}
	
	@GetMapping(path = "/genero")
	public ResponseEntity<List<Livro>> findByGenero(@RequestParam(required = false) String genero) {
		return ResponseEntity.ok(livroService.findByGenero(genero));
	}

	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody @Valid LivroPostRequestBody livro) {
		return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		livroService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody LivroPutRequestBody livro) {
		livroService.replace(livro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
