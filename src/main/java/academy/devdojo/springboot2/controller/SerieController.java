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

import academy.devdojo.springboot2.domain.Serie;
import academy.devdojo.springboot2.requests.serie.SeriePostRequestBody;
import academy.devdojo.springboot2.requests.serie.SeriePutRequestBody;
import academy.devdojo.springboot2.service.SerieService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("series")
@Log4j2
@RequiredArgsConstructor
public class SerieController {
	private final DateUtil dateUtil;
	private final SerieService serieService;

	@GetMapping
	public ResponseEntity<List<Serie>> list() {
		//Classe Controladora que faz as operações RestFull
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(serieService.listAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Serie> findById(@PathVariable long id) {
		return new ResponseEntity<>(serieService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Serie>> findByTitulo(@RequestParam(required = false) String titulo) {
		return ResponseEntity.ok(serieService.findByTitulo(titulo));
	}
	
	@GetMapping(path = "/user")
	public ResponseEntity<List<Serie>> findByUser(@RequestParam(required = false) String user) {
		return ResponseEntity.ok(serieService.findByUser(user));
	}
	
	@GetMapping(path = "/genero")
	public ResponseEntity<List<Serie>> findByGenero(@RequestParam(required = false) String genero) {
		return ResponseEntity.ok(serieService.findByGenero(genero));
	}

	@PostMapping
	public ResponseEntity<Serie> save(@RequestBody @Valid SeriePostRequestBody serie) {
		return new ResponseEntity<>(serieService.save(serie), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		serieService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody SeriePutRequestBody serie) {
		serieService.replace(serie);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
