package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Roomdecresed extends AbstractEvent {

    private Long id;
    private String roomId;
    private Integer stock;
    private Integer reservationId;
    private String status;

    public Roomdecresed(Room aggregate) {
        super(aggregate);
    }

    public Roomdecresed() {
        super();
    }
}
//>>> DDD / Domain Event
