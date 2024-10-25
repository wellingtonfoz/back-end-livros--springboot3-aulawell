package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	

	public String save (Autor autor) {
		this.autorRepository.save(autor);
		return "Autor cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Autor autor, long id) {
		autor.setId(id);
		this.autorRepository.save(autor);
		return "Atualizado com sucesso";
	}
	
	public Autor findById (long id) {
		
		Optional<Autor> optional = this.autorRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Autor> findAll () {
		
		return this.autorRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.autorRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Autor> findByNome(String nome){
		return this.autorRepository.findByNomeStartsWith(nome);
	}
	
	
}
