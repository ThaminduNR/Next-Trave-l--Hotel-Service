package lk.nexttravel.hotelService.repo;

import lk.nexttravel.hotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.Query;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {


}
