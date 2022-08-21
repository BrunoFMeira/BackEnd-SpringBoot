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

import academy.devdojo.springboot2.domain.Filme;
import academy.devdojo.springboot2.requests.filme.FilmePostRequestBody;
import academy.devdojo.springboot2.requests.filme.FilmePutRequestBody;
import academy.devdojo.springboot2.service.FilmeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("filmes")
@Log4j2
@RequiredArgsConstructor
public class FilmeController {
	//Classe Controladora que faz as operações RestFull
	private final DateUtil dateUtil;
	private final FilmeService filmeService;

	@GetMapping
	public ResponseEntity<List<Filme>> list() {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(filmeService.listAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Filme> findById(@PathVariable long id) {
		return new ResponseEntity<>(filmeService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Filme>> findByTitulo(@RequestParam(required = false) String titulo) {
		return ResponseEntity.ok(filmeService.findByTitulo(titulo));
	}
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<Filme>> findByUser(@RequestParam(required = false) String user) {
		return ResponseEntity.ok(filmeService.findByUser(user));
	}
	
	@GetMapping(path = "/genero")
	public ResponseEntity<List<Filme>> findByGenero(@RequestParam(required = false) String genero) {
		return ResponseEntity.ok(filmeService.findByGenero(genero));
	}

	@PostMapping
	public ResponseEntity<Filme> save(@RequestBody @Valid FilmePostRequestBody filme) {
		return new ResponseEntity<>(filmeService.save(filme), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		filmeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody FilmePutRequestBody filme) {
		filmeService.replace(filme);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
