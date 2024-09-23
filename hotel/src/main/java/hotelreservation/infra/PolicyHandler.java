package hotelreservation.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotelreservation.config.kafka.KafkaProcessor;
import hotelreservation.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    HotelRepository hotelRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RoomReserved'"
    )
    public void wheneverRoomReserved_StartReservation(
        @Payload RoomReserved roomReserved
    ) {
        RoomReserved event = roomReserved;
        System.out.println(
            "\n\n##### listener StartReservation : " + roomReserved + "\n\n"
        );

        // Sample Logic //
        Hotel.startReservation(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
