package academy.devdojo.springboot2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Serie;
import academy.devdojo.springboot2.repository.SerieRepository;
import academy.devdojo.springboot2.requests.serie.SeriePostRequestBody;
import academy.devdojo.springboot2.requests.serie.SeriePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerieService {

	private final SerieRepository serieRepository;

	public List<Serie> listAll() {
		return serieRepository.findAll();
	}

	public List<Serie> findByTitulo(String titulo) {
		return serieRepository.findByTitulo(titulo);
	}

	public List<Serie> findByUser(String user) {
		return serieRepository.findByUser(user);
	}

	public List<Serie> findByGenero(String genero) {
		return serieRepository.findByGenero(genero);
	}

	public Serie findById(Long id) {
		return serieRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Midia not found"));
	}

	@Transactional
	public Serie save(SeriePostRequestBody seriePostRequestBody) {
		return serieRepository.save(Serie.builder().titulo(seriePostRequestBody.getTitulo())
				.genero(seriePostRequestBody.getGenero()).user(seriePostRequestBody.getUser())
				.epsodios(seriePostRequestBody.getEpsodios()).diretor(seriePostRequestBody.getDiretor())
				.atores(seriePostRequestBody.getAtores()).genero(seriePostRequestBody.getGenero())
				.temporadas(seriePostRequestBody.getTemporadas()).sinopse(seriePostRequestBody.getSinopse())
				.descricao(seriePostRequestBody.getDescricao()).avaliacao(seriePostRequestBody.getAvaliacao())
				.status(seriePostRequestBody.getStatus()).build());
	}

	@Transactional
	public void delete(long id) {
		serieRepository.delete(findById(id));

	}

	@Transactional
	public void replace(SeriePutRequestBody seriePutRequestBody) {
		Serie savedSerie = findById(seriePutRequestBody.getId());
		Serie serie = Serie.builder().id(savedSerie.getId()).titulo(savedSerie.getTitulo())
				.genero(seriePutRequestBody.getGenero()).user(seriePutRequestBody.getUser())
				.epsodios(seriePutRequestBody.getEpsodios()).diretor(seriePutRequestBody.getDiretor())
				.atores(seriePutRequestBody.getAtores()).genero(seriePutRequestBody.getGenero())
				.temporadas(seriePutRequestBody.getTemporadas()).sinopse(seriePutRequestBody.getSinopse())
				.descricao(seriePutRequestBody.getDescricao()).avaliacao(seriePutRequestBody.getAvaliacao())
				.status(seriePutRequestBody.getStatus()).build();

		serieRepository.save(serie);
	}
}
