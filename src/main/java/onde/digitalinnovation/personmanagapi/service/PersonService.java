package onde.digitalinnovation.personmanagapi.service;

import onde.digitalinnovation.personmanagapi.dto.request.PersonDTO;
import onde.digitalinnovation.personmanagapi.dto.response.MessageResponseDTO;
import onde.digitalinnovation.personmanagapi.entity.Person;
import onde.digitalinnovation.personmanagapi.mapper.PersonMapper;
import onde.digitalinnovation.personmanagapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
