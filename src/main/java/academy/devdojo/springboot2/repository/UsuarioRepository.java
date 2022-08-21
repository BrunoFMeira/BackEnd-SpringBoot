package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import academy.devdojo.springboot2.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//Repositorio de operações JPA usada nos Usuarios
	List<Usuario> findByNome(String nome);

}
