package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import academy.devdojo.springboot2.domain.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	//Repositorio de operações JPA usada nas Series
	List<Serie> findByTitulo(String titulo);

	List<Serie> findByUser(String user);

	List<Serie> findByGenero(String genero);
}
