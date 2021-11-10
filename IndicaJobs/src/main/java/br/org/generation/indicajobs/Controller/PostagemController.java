package br.org.generation.indicajobs.Controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.indicajobs.Repository.PostagemRepository;
import br.org.generation.indicajobs.model.Postagem;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/idPost")
	public ResponseEntity<Postagem> getById (@PathVariable long idPost){
		return repository.findById(idPost)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tituloPost/{tituloPost}")
	public ResponseEntity<List<Postagem>> getByTituloPost (@PathVariable String tituloPost){
		return ResponseEntity.ok(repository.findAllByTituloPostContainingIgnoreCase(tituloPost));
	}
	
	/*@GetMapping("/data/{data}")
	public ResponseEntity<List<Postagem>> getByDate (@PathVariable Date data){
		return ResponseEntity.ok(repository.findAllByDataContainingIgnoreCase(data));
	}*/
	
	@PostMapping
	public ResponseEntity<Postagem> postPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> putPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/idPost")
	public void deletePostagem (@PathVariable long idPost) {
		repository.deleteById(idPost);
	}

}
