package onde.digitalinnovation.personmanagapi.repository;

import onde.digitalinnovation.personmanagapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
