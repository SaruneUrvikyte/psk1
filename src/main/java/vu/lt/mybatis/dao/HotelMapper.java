package vu.lt.mybatis.dao;

import java.util.List;
import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Hotel;

@Mapper
public interface HotelMapper {

    int deleteByPrimaryKey(String id);

    int insert(Hotel record);

    Hotel selectByPrimaryKey(String id);

    List<Hotel> selectAll();

    int updateByPrimaryKey(Hotel record);
}