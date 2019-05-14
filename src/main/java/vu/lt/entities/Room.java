package vu.lt.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ROOM")
@NamedQueries({
        @NamedQuery(name = "Room.findAll", query = "select r from Room as r")
})
@Getter @Setter
@EqualsAndHashCode(of = {"id", "no"})
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 10)
    @Column(name = "NO")
    private String no;

    @Column(name = "NUMBER_OF_VISITORS")
    private Integer numberOfVisitors;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToOne
    @JoinColumn(name="HOTEL_ID")
    private Hotel hotel;

    public Room(){}
}
