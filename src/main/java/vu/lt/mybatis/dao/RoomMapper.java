package vu.lt.mybatis.dao;

import java.util.List;
import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Room;


@Mapper
public interface RoomMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    Room selectByPrimaryKey(Integer id);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);
}