package hotelreservation.domain;

import hotelreservation.RoomApplication;
import hotelreservation.domain.Outofstock;
import hotelreservation.domain.Roomdecresed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Room_table")
@Data
//<<< DDD / Aggregate Root
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomId;

    private Integer stock;

    private Integer reservationId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Roomdecresed roomdecresed = new Roomdecresed(this);
        roomdecresed.publishAfterCommit();

        Outofstock outofstock = new Outofstock(this);
        outofstock.publishAfterCommit();
    }

    public static RoomRepository repository() {
        RoomRepository roomRepository = RoomApplication.applicationContext.getBean(
            RoomRepository.class
        );
        return roomRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreseRoom(RoomReserved roomReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        Roomdecresed roomdecresed = new Roomdecresed(room);
        roomdecresed.publishAfterCommit();
        Outofstock outofstock = new Outofstock(room);
        outofstock.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(roomReserved.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);

            Roomdecresed roomdecresed = new Roomdecresed(room);
            roomdecresed.publishAfterCommit();
            Outofstock outofstock = new Outofstock(room);
            outofstock.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
