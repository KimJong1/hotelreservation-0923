package hotelreservation.domain;

import hotelreservation.ReservationApplication;
import hotelreservation.domain.RoomReserved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomId;

    private String userId;

    private Date qty;

    private String status;

    private Integer reservationId;

    @PostPersist
    public void onPostPersist() {
        RoomReserved roomReserved = new RoomReserved(this);
        roomReserved.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    public void reservation() {
        //implement business logic here:

        RoomReserved roomReserved = new RoomReserved(this);
        roomReserved.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void notifyToUser(Outofstock outofstock) {
        //implement business logic here:

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        /** Example 2:  finding and process
        
        repository().findById(outofstock.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
