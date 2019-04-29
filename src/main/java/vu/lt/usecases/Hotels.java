package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Hotel;
import vu.lt.persistence.HotelsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Hotels {
    @Inject
    private HotelsDAO hotelsDAO;

    @Getter @Setter
    private Hotel hotelToCreate = new Hotel();

    @Getter
    private List<Hotel> allHotels;

    @PostConstruct
    public void init(){
        loadAllHotels();
    }

    @Transactional
    public String createHotel(){
        this.hotelsDAO.persist(hotelToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllHotels(){
        this.allHotels = hotelsDAO.loadAll();
    }

}
