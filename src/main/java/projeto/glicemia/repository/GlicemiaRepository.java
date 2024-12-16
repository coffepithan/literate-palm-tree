package projeto.glicemia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.glicemia.model.Glicemia;

@Repository
public interface GlicemiaRepository extends CrudRepository<Glicemia, Long>{

	
	
}
