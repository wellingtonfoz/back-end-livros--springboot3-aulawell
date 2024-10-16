package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	public List<Livro> findByTituloStartsWith(String nome);

}
