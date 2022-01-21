package com.services;

import com.connect.HibernateSessionFactory;
import com.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonService {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    public PersonService() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void closeSession() {
        transaction.commit();
        session.close();
    }

    // .................................................................................................................

    public void showAllElementsFromTable() {
        List<Person> list = (List<Person>) session.createQuery("FROM Person ").list();
        for (Person current : list)
            System.out.println(current);
    }

    public int add(Person developer) {
        return (int) (Integer) session.save(developer);
    }

    public void updateName(int id, String name) {
        Person person = session.get(Person.class, id);
        person.setName(name);
        session.update(person);
    }

    public void removeById(int id) {
        // IllegalStateException: Transaction already active
//        Transaction transaction = session.beginTransaction();
        Person developer = session.get(Person.class, id);
        session.delete(developer);
//        transaction.commit();
    }

    // .................................................................................................................

    public Person findById(int id) {
        return session.get(Person.class, id);
    }

    public void save(Person user) {
        session.save(user);
    }

    public void update(Person user) {
        session.update(user);
    }

    public void delete(Person user) {
        session.delete(user);
    }

}
