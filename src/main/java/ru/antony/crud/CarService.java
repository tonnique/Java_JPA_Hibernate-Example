package ru.antony.crud;

import ru.antony.entity.Car;

import javax.persistence.*;
import java.util.List;


/**
 * Created by Antony on 07.06.2017.
 */
public class CarService {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Car add(Car car){
        em.getTransaction().begin();
        Car carFromDB = em.merge(car);
        em.getTransaction().commit();
        return carFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Car get(long id){
        return em.find(Car.class, id);
    }

    public void update(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<Car> getAll(){
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }
}
