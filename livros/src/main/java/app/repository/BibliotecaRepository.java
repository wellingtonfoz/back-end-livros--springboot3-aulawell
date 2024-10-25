package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

	public List<Biblioteca> findByNomeStartsWith(String nome);

}
