package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	public List<Autor> findByNomeStartsWith(String nome);

}
