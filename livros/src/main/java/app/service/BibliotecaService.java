package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;

@Service
public class BibliotecaService {
	
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	

	public String save (Biblioteca biblioteca) {
		this.bibliotecaRepository.save(biblioteca);
		return "Biblioteca cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Biblioteca biblioteca, long id) {
		biblioteca.setId(id);
		this.bibliotecaRepository.save(biblioteca);
		return "Atualizado com sucesso";
	}
	
	public Biblioteca findById (long id) {
		
		Optional<Biblioteca> optional = this.bibliotecaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Biblioteca> findAll () {
		
		return this.bibliotecaRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.bibliotecaRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Biblioteca> findByNome(String nome){
		return this.bibliotecaRepository.findByNomeStartsWith(nome);
	}
	
	
}
