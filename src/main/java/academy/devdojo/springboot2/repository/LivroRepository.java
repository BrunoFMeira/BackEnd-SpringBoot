package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import academy.devdojo.springboot2.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	//Repositorio de operações JPA usada nos Livros
	List<Livro> findByTitulo(String titulo);

	List<Livro> findByUser(String user);

	List<Livro> findByGenero(String genero);
}
