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
    RoomRepository roomRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RoomReserved'"
    )
    public void wheneverRoomReserved_DecreseRoom(
        @Payload RoomReserved roomReserved
    ) {
        RoomReserved event = roomReserved;
        System.out.println(
            "\n\n##### listener DecreseRoom : " + roomReserved + "\n\n"
        );

        // Sample Logic //
        Room.decreseRoom(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
