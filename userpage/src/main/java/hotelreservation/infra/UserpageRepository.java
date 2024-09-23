package hotelreservation.infra;

import hotelreservation.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userpages", path = "userpages")
public interface UserpageRepository
    extends PagingAndSortingRepository<Userpage, Long> {
    List<Userpage> findByReservationId(Integer reservationId);
}
