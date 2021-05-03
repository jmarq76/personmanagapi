package onde.digitalinnovation.personmanagapi.service;

import onde.digitalinnovation.personmanagapi.dto.MessageResponseDTO;
import onde.digitalinnovation.personmanagapi.entity.Person;
import onde.digitalinnovation.personmanagapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
