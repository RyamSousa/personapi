package one.digitalinnovation.userapi.service;

import one.digitalinnovation.userapi.dto.MessageResponseDTO;
import one.digitalinnovation.userapi.entity.Person;
import one.digitalinnovation.userapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( Person person){
        Person savedPerson = personRepository.save(person);
        System.out.println(savedPerson.getCpf());

        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }
}
