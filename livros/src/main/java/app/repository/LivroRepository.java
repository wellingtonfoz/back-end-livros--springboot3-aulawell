package app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	public Page<Livro> findByTituloStartsWith(String nome, PageRequest paginador);

}
