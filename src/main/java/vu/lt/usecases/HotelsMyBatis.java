package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.model.Hotel;
import vu.lt.mybatis.dao.HotelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class HotelsMyBatis {

    @Inject
    private HotelMapper hotelMapper;

    @Getter
    private List<Hotel> allHotels;

    @Getter @Setter
    private Hotel hotelToCreate = new Hotel();

    @PostConstruct
    public void init() {
        this.loadAllHotels();
    }

    private void loadAllHotels() {
        this.allHotels = hotelMapper.selectAll();
    }

    @Transactional
    public String createHotel() {
        hotelMapper.insert(hotelToCreate);
        return "/myBatis/hotels?faces-redirect=true";
    }
}
