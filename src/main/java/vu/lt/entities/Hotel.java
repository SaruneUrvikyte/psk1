package vu.lt.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HOTEL")
@NamedQueries({
        @NamedQuery(name = "Hotel.findAll", query = "select h from Hotel as h")
})
@Getter @Setter
@EqualsAndHashCode(of = {"id", "name"})
public class Hotel {

    public Hotel(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();
}
