package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import academy.devdojo.springboot2.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	//Repositorio de operações JPA usada nos Filmes
	List<Filme> findByTitulo(String titulo);

	List<Filme> findByUser(String user);

	List<Filme> findByGenero(String genero);
}
