package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    // BEGIN
    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return this.personRepository.save(person);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable long id) {
        this.personRepository.deleteById(id);
    }

    @PatchMapping(path = "{id}")
    public Person patchPerson(@RequestBody Person person, @PathVariable long id) {
        person.setId(id);
        return this.personRepository.save(person);
    }
    // END
}
