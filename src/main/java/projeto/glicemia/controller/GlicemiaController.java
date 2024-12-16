package projeto.glicemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.glicemia.model.Glicemia;
import projeto.glicemia.repository.GlicemiaRepository;

@RestController
@RequestMapping("glicemia")
public class GlicemiaController {

	@Autowired
	private GlicemiaRepository glicemiaRepo;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Glicemia>  getById(@PathVariable(name="id") Long id) {
		
		Glicemia nGlicemias = glicemiaRepo.findById(id).get();
		
		return new ResponseEntity<Glicemia>(nGlicemias, HttpStatus.OK) ;
	}
	
	@GetMapping("/")
	public List<Glicemia> getAll() {
		
		List<Glicemia> glicemias = (List<Glicemia>) glicemiaRepo.findAll();
		
		return glicemias;
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Glicemia> save(@RequestBody Glicemia glicemia){
		
		Glicemia nGlicemia = glicemiaRepo.save(glicemia);
		
		return new ResponseEntity<Glicemia>(nGlicemia, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Glicemia> update(@RequestBody Glicemia glicemia){
		
		Glicemia nGlicemia = glicemiaRepo.save(glicemia);
		
		return new ResponseEntity<Glicemia>(nGlicemia, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		glicemiaRepo.deleteById(id);
		
		return new ResponseEntity<String>("DELETADO!", HttpStatus.OK);
		
	}
}
