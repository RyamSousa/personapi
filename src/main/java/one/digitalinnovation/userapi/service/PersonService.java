package one.digitalinnovation.userapi.service;

import one.digitalinnovation.userapi.dto.request.PersonDTO;
import one.digitalinnovation.userapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.userapi.entity.Person;
import one.digitalinnovation.userapi.exception.PersonNotFoundException;
import one.digitalinnovation.userapi.mapper.PersonMapper;
import one.digitalinnovation.userapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}
