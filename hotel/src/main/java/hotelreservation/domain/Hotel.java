package hotelreservation.domain;

import hotelreservation.HotelApplication;
import hotelreservation.domain.Reservationcompleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Hotel_table")
@Data
//<<< DDD / Aggregate Root
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomId;

    private String userId;

    private String qty;

    private String status;

    private Integer reservationId;

    @PostPersist
    public void onPostPersist() {
        Reservationcompleted reservationcompleted = new Reservationcompleted(
            this
        );
        reservationcompleted.publishAfterCommit();
    }

    public static HotelRepository repository() {
        HotelRepository hotelRepository = HotelApplication.applicationContext.getBean(
            HotelRepository.class
        );
        return hotelRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startReservation(RoomReserved roomReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Hotel hotel = new Hotel();
        repository().save(hotel);

        Reservationcompleted reservationcompleted = new Reservationcompleted(hotel);
        reservationcompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(roomReserved.get???()).ifPresent(hotel->{
            
            hotel // do something
            repository().save(hotel);

            Reservationcompleted reservationcompleted = new Reservationcompleted(hotel);
            reservationcompleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
