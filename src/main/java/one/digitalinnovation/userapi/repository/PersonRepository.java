package one.digitalinnovation.userapi.repository;

import one.digitalinnovation.userapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
