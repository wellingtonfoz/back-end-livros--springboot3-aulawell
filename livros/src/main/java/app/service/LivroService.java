package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	

	public String save (Livro livro) {
		this.livroRepository.save(livro);
		return "Livro cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Livro livro, long id) {
		livro.setId(id);
		this.livroRepository.save(livro);
		return "Atualizado com sucesso";
	}
	
	public Livro findById (long id) {
		
		Optional<Livro> optional = this.livroRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public Page<Livro> findAll (int pagina) {
		
		PageRequest paginador = PageRequest.of(pagina-1, 5);
		return this.livroRepository.findAll(paginador);
		
	}
	
	public String delete (long id) {
		this.livroRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public Page<Livro> findByTitulo(String nome, int pagina){
		
		PageRequest paginador = PageRequest.of(pagina-1, 5);
		return this.livroRepository.findByTituloStartsWith(nome, paginador);
	}
	
	
}
