package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomReserved extends AbstractEvent {

    private Long id;
    private String roomId;
    private String userId;
    private String status;
    private Date qty;
    private Integer reservationId;

    public RoomReserved(Reservation aggregate) {
        super(aggregate);
    }

    public RoomReserved() {
        super();
    }
}
//>>> DDD / Domain Event
