package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RoomReserved extends AbstractEvent {

    private Long id;
    private String roomId;
    private String userId;
    private String status;
    private Date qty;
    private Integer reservationId;
}
