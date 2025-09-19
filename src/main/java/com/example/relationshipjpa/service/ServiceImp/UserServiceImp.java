package com.example.relationshipjpa.service.ServiceImp;

import com.example.relationshipjpa.model.dto.request.PersonRequest;
import com.example.relationshipjpa.model.entity.Passport;
import com.example.relationshipjpa.model.entity.Person;
import com.example.relationshipjpa.repository.UserRepository;
import com.example.relationshipjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Person> getAllPerson() {
        return userRepository.findAll();
    }

    @Override
    public Person insertNewUser(PersonRequest personRequest) {
        Person newPerson = new Person();
        newPerson.setFirstName(personRequest.getFirstName());
        newPerson.setLastName(personRequest.getLastName());
        newPerson.setEmail(personRequest.getEmail());

        if(personRequest.getPassportRequest() != null){
            Passport newPassport = new Passport();
            newPassport.setName(personRequest.getPassportRequest().getName());
            newPassport.setNationality(personRequest.getPassportRequest().getNationality());
            newPassport.setCountry(personRequest.getPassportRequest().getCountry());
            newPassport.setExpirationDate(personRequest.getPassportRequest().getExpirationDate());
            newPassport.setGender(personRequest.getPassportRequest().getGender());

            // set relationship
            newPerson.setPassport(newPassport);
            newPassport.setPerson(newPerson);
        }

        return userRepository.save(newPerson);
    }
}
