package com.example.relationshipjpa.service.ServiceImp;

import com.example.relationshipjpa.model.dto.request.PersonRequest;
import com.example.relationshipjpa.model.entity.Passport;
import com.example.relationshipjpa.model.entity.Person;
import com.example.relationshipjpa.repository.UserRepository;
import com.example.relationshipjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Person getPersonById(Long id){
        Optional<Person> person = userRepository.findById(id);
        return person.orElse(null);
    }

    @Override
    public Person deleteUser(Long id) {
        Optional<Person> person = userRepository.findById(id); // find and store for show
        userRepository.deleteById(id); // delete
        return person.orElse(null); // show
    }

    @Override
    public Person updateUser(Long id, PersonRequest updateInfo) {
        Optional<Person> person = userRepository.findById(id);
        if(person.isPresent()){
            Person updatePerson = person.get();
            updatePerson.setFirstName(updateInfo.getFirstName());
            updatePerson.setLastName(updateInfo.getLastName());
            updatePerson.setEmail(updateInfo.getEmail());
            if(updateInfo.getPassportRequest() != null){
                updatePerson.getPassport().setName(updateInfo.getPassportRequest().getName());
                updatePerson.getPassport().setNationality(updateInfo.getPassportRequest().getNationality());
                updatePerson.getPassport().setCountry(updateInfo.getPassportRequest().getCountry());
                updatePerson.getPassport().setExpirationDate(updateInfo.getPassportRequest().getExpirationDate());
                updatePerson.getPassport().setGender(updateInfo.getPassportRequest().getGender());
            }
            return userRepository.save(updatePerson);
        }
        return   null;
    }
}
