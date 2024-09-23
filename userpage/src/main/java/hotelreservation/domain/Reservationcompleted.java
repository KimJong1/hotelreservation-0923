package hotelreservation.domain;

import hotelreservation.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Reservationcompleted extends AbstractEvent {

    private Long id;
    private String roomId;
    private String userId;
    private String status;
    private String qty;
    private Integer reservationId;
}
