package vu.lt.persistence;

import vu.lt.entities.Hotel;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;
import javax.inject.Inject;


@ApplicationScoped
public class HotelsDAO {

    @Inject
    private EntityManager em;

    public List<Hotel> loadAll() {
        return em.createNamedQuery("Hotel.findAll", Hotel.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Hotel hotel){
        this.em.persist(hotel);
    }

    public Hotel findOne(Integer id) { return em.find(Hotel.class, id); }
}
