package com;


import com.model.Person;
import com.services.PersonService;

public class RunUsingPersonDaoSessionFactoryByHibernate {
    public static void main(String[] args) {
        PersonService service = new PersonService();


        Person people = Person.builder().name("People").weight(999).build();
        Person proselyte = Person.builder().name("Proselyte").build();
        int peopleId = service.add(people);
        int proselyteId = service.add(proselyte);

        System.out.println("\nList before: ");
        service.showAllElementsFromTable();

        service.removeById(proselyteId);
        service.updateName(peopleId, "Another Name");

        System.out.println("\nList after: ");
        service.showAllElementsFromTable();


        service.closeSession();
    }
}