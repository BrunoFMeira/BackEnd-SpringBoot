package academy.devdojo.springboot2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Filme;
import academy.devdojo.springboot2.repository.FilmeRepository;
import academy.devdojo.springboot2.requests.filme.FilmePostRequestBody;
import academy.devdojo.springboot2.requests.filme.FilmePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final FilmeRepository filmeRepository;

	public List<Filme> listAll() {
		return filmeRepository.findAll();
	}

	public List<Filme> findByTitulo(String titulo) {
		return filmeRepository.findByTitulo(titulo);
	}

	public List<Filme> findByUser(String user) {
		return filmeRepository.findByUser(user);
	}

	public List<Filme> findByGenero(String genero) {
		return filmeRepository.findByGenero(genero);
	}

	public Filme findById(Long id) {
		return filmeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Midia not found"));
	}

	@Transactional
	public Filme save(FilmePostRequestBody filmePostRequestBody) {
		return filmeRepository.save(Filme.builder().titulo(filmePostRequestBody.getTitulo())
				.genero(filmePostRequestBody.getGenero()).user(filmePostRequestBody.getUser())
				.duracao(filmePostRequestBody.getDuracao()).atores(filmePostRequestBody.getAtores())
				.diretor(filmePostRequestBody.getDiretor()).genero(filmePostRequestBody.getGenero())
				.sinopse(filmePostRequestBody.getSinopse()).descricao(filmePostRequestBody.getDescricao())
				.avaliacao(filmePostRequestBody.getAvaliacao()).status(filmePostRequestBody.getStatus()).build());
	}

	@Transactional
	public void delete(long id) {
		filmeRepository.delete(findById(id));

	}

	@Transactional
	public void replace(FilmePutRequestBody filmePutRequestBody) {
		Filme savedFilme = findById(filmePutRequestBody.getId());
		Filme filme = Filme.builder().id(savedFilme.getId()).titulo(savedFilme.getTitulo())
				.genero(filmePutRequestBody.getGenero()).user(filmePutRequestBody.getUser())
				.duracao(filmePutRequestBody.getDuracao()).atores(filmePutRequestBody.getAtores())
				.diretor(filmePutRequestBody.getDiretor()).genero(filmePutRequestBody.getGenero())
				.sinopse(filmePutRequestBody.getSinopse()).descricao(filmePutRequestBody.getDescricao())
				.avaliacao(filmePutRequestBody.getAvaliacao()).status(filmePutRequestBody.getStatus()).build();

		filmeRepository.save(filme);
	}
}
