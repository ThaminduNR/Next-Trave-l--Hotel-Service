package lk.nexttravel.hotelService.service;

import lk.nexttravel.hotelService.dto.HotelDto;

import java.util.List;

public interface HotelService {

    void saveHotel(HotelDto dto);
    void updateHotel(HotelDto dto);
    void deleteHotel(String id);
    List<HotelDto> getAllHotels();
    HotelDto searchHotel(String id);

}
