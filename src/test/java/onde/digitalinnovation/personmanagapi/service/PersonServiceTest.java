package onde.digitalinnovation.personmanagapi.service;

import onde.digitalinnovation.personmanagapi.dto.request.PersonDTO;
import onde.digitalinnovation.personmanagapi.dto.response.MessageResponseDTO;
import onde.digitalinnovation.personmanagapi.entity.Person;
import onde.digitalinnovation.personmanagapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static onde.digitalinnovation.personmanagapi.utils.PersonUtils.createFakeDTO;
import static onde.digitalinnovation.personmanagapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;
    
    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSucessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage, sucessMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
