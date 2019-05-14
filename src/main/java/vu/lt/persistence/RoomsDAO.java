package vu.lt.persistence;

import vu.lt.entities.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RoomsDAO {

    @Inject
    private EntityManager em;

    public void persist(Room room){
        this.em.persist(room);
    }

    public Room findOne(Integer id){
        return em.find(Room.class, id);
    }

    public Room update(Room room){
        return em.merge(room);
    }
}
