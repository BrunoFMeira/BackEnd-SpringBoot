package academy.devdojo.springboot2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Livro;
import academy.devdojo.springboot2.repository.LivroRepository;
import academy.devdojo.springboot2.requests.livro.LivroPostRequestBody;
import academy.devdojo.springboot2.requests.livro.LivroPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

	private final LivroRepository livroRepository;

	public List<Livro> listAll() {
		return livroRepository.findAll();
	}

	public List<Livro> findByTitulo(String titulo) {
		return livroRepository.findByTitulo(titulo);
	}

	public List<Livro> findByUser(String user) {
		return livroRepository.findByUser(user);
	}

	public List<Livro> findByGenero(String genero) {
		return livroRepository.findByGenero(genero);
	}

	public Livro findById(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Midia not found"));
	}

	@Transactional
	public Livro save(LivroPostRequestBody livroPostRequestBody) {
		return livroRepository.save(Livro.builder().titulo(livroPostRequestBody.getTitulo())
				.genero(livroPostRequestBody.getGenero()).user(livroPostRequestBody.getUser())
				.paginas(livroPostRequestBody.getPaginas()).autor(livroPostRequestBody.getAutor())
				.editora(livroPostRequestBody.getEditora()).genero(livroPostRequestBody.getGenero())
				.sinopse(livroPostRequestBody.getSinopse()).descricao(livroPostRequestBody.getDescricao())
				.avaliacao(livroPostRequestBody.getAvaliacao()).status(livroPostRequestBody.getStatus()).build());
	}

	@Transactional
	public void delete(long id) {
		livroRepository.delete(findById(id));

	}

	@Transactional
	public void replace(LivroPutRequestBody livroPutRequestBody) {
		Livro savedLivro = findById(livroPutRequestBody.getId());
		Livro livro = Livro.builder().id(savedLivro.getId()).titulo(savedLivro.getTitulo())
				.genero(livroPutRequestBody.getGenero()).user(livroPutRequestBody.getUser())
				.paginas(livroPutRequestBody.getPaginas()).autor(livroPutRequestBody.getAutor())
				.editora(livroPutRequestBody.getEditora()).genero(livroPutRequestBody.getGenero())
				.sinopse(livroPutRequestBody.getSinopse()).descricao(livroPutRequestBody.getDescricao())
				.avaliacao(livroPutRequestBody.getAvaliacao()).status(livroPutRequestBody.getStatus()).build();

		livroRepository.save(livro);
	}
}
