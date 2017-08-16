package contactlist.mahder.demo.repository;

import contactlist.mahder.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{
}
