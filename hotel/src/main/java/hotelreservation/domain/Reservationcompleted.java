package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Reservationcompleted extends AbstractEvent {

    private Long id;
    private String roomId;
    private String userId;
    private String status;
    private String qty;
    private Integer reservationId;

    public Reservationcompleted(Hotel aggregate) {
        super(aggregate);
    }

    public Reservationcompleted() {
        super();
    }
}
//>>> DDD / Domain Event
