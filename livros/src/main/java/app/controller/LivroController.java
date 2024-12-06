package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/livro")
@CrossOrigin("*")
public class LivroController {
	
	
	@Autowired
	private LivroService livroService;
	

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Livro livro){
		try {
			String mensagem = this.livroService.save(livro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("dsklfjsdl");
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @RequestBody Livro livro, @PathVariable long id){
		try {
			String mensagem = this.livroService.update(livro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> findById(@PathVariable long id){
		try {
			Livro livro = this.livroService.findById(id);
			return new ResponseEntity<>(livro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@GetMapping("/findAll/{pagina}")
	public ResponseEntity<Page<Livro>> findAll(@PathVariable int pagina){
		try {
			Page<Livro> lista = this.livroService.findAll(pagina);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.livroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@GetMapping("/findByTitulo/{pagina}")
	public ResponseEntity<Page<Livro>> findByTitulo(@RequestParam String nome, @PathVariable int pagina){
		try {
			Page<Livro> lista = this.livroService.findByTitulo(nome,pagina);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	
}
