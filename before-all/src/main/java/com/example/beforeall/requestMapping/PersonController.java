package com.example.beforeall.requestMapping;

import com.example.beforeall.beanlifecycle.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-12-02
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("10001", "test1", 1));
        personList.add(new Person("10002", "test2", 2));
        personList.add(new Person("10003", "test3", 3));
        personList.add(new Person("10004", "test4", 4));
        personList.add(new Person("10005", "test5", 5));
    }

    @GetMapping("/")
    public List<Person> list() {
        return personList;
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Integer id) {
        Person defaultPerson = new Person("88888", "default", 1);
        return personList.stream().filter(person -> Objects.equals(person.getPhone(), id)).findFirst().orElse(defaultPerson);
    }

    @PostMapping("/")
    public void add(@RequestBody Person person) {
        personList.add(person);
    }

    @PutMapping("/")
    public void update(@RequestBody Person person) {
        personList.removeIf(p -> Objects.equals(p.getName(), person.getName()));
        personList.add(person);
    }
}

