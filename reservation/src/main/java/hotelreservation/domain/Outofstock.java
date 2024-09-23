package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Outofstock extends AbstractEvent {

    private Long id;
    private String roomId;
    private String userId;
    private Integer stock;
    private Integer reservationId;
    private String status;
}
