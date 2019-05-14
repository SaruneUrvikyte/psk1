package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Hotel;
import vu.lt.entities.Room;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.HotelsDAO;
import vu.lt.persistence.RoomsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class RoomsForHotel implements Serializable{

    @Inject
    private HotelsDAO hotelsDAO;

    @Inject
    private RoomsDAO roomsDAO;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Room roomToCreate = new Room();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer hotelId = Integer.parseInt(requestParameters.get("hotelId"));
        this.hotel = hotelsDAO.findOne(hotelId);
    }

    @Transactional
    @LoggedInvocation
    public String createRoom() {
        roomToCreate.setHotel(this.hotel);
        roomsDAO.persist(roomToCreate);
        return "rooms?faces-redirect=true&hotelId=" + this.hotel.getId();
    }
}
