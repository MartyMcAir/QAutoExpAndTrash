package com;


import com.connect.HibernateSessionFactory;
import com.model.Person;
import com.services.PersonService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RunUsingPersonDaoSessionFactoryByHibernate {
    public static void main(String[] args) {
//        simpleExample();
//        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
//        saveExample(session, transaction);
        deleteExample(session, transaction);

    }

    private static void deleteExample(Session session, Transaction transaction) {
        Person person = session.get(Person.class, 24);
        session.delete(person);

        transaction.commit();
        session.close();
    }

    private static void saveExample(Session session, Transaction transaction) {
        Person pork = Person.builder().name("Pork").weight(333).build();
        session.save(pork);

        transaction.commit();
        session.close();
    }

    private static void simpleExample() {
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