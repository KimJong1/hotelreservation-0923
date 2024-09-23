package hotelreservation.infra;

import hotelreservation.config.kafka.KafkaProcessor;
import hotelreservation.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class UserpageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private UserpageRepository userpageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomReserved_then_CREATE_1(
        @Payload RoomReserved roomReserved
    ) {
        try {
            if (!roomReserved.validate()) return;

            // view 객체 생성
            Userpage userpage = new Userpage();
            // view 객체에 이벤트의 Value 를 set 함
            userpage.setId(roomReserved.getId());
            userpage.setUserId(roomReserved.getUserId());
            userpage.setRoomId(roomReserved.getRoomId());
            userpage.setStatus(roomReserved.getStatus());
            userpage.setReservationId(roomReserved.getReservationId());
            // view 레파지 토리에 save
            userpageRepository.save(userpage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationcompleted_then_UPDATE_1(
        @Payload Reservationcompleted reservationcompleted
    ) {
        try {
            if (!reservationcompleted.validate()) return;
            // view 객체 조회

            List<Userpage> userpageList = userpageRepository.findByReservationId(
                reservationcompleted.getReservationId()
            );
            for (Userpage userpage : userpageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                userpage.setStatus(reservationcompleted.getStatus());
                // view 레파지 토리에 save
                userpageRepository.save(userpage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOutofstock_then_UPDATE_2(@Payload Outofstock outofstock) {
        try {
            if (!outofstock.validate()) return;
            // view 객체 조회

            List<Userpage> userpageList = userpageRepository.findByReservationId(
                outofstock.getReservationId()
            );
            for (Userpage userpage : userpageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                userpage.setStatus(outofstock.getStatus());
                // view 레파지 토리에 save
                userpageRepository.save(userpage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
