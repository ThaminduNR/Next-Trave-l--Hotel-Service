package lk.nexttravel.hotelService.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lk.nexttravel.hotelService.dto.HotelDto;
import lk.nexttravel.hotelService.entity.Hotel;
import lk.nexttravel.hotelService.exception.InvalidException;
import lk.nexttravel.hotelService.exception.NotFoundException;
import lk.nexttravel.hotelService.repo.HotelRepository;
import lk.nexttravel.hotelService.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ModelMapper mapper;

    @Autowired
    private EntityManager entityManager;
    @Override
    public void saveHotel(HotelDto dto) {
        if (hotelRepository.existsById(dto.getHotelId())) throw new RuntimeException("Hotel Already Added");
            hotelRepository.save(mapper.map(dto, Hotel.class));
    }

    @Override
    public void updateHotel(HotelDto dto) {
        if (hotelRepository.existsById(dto.getHotelId())){
            hotelRepository.save(mapper.map(dto,Hotel.class));
        }else {
            throw new NotFoundException("Hotel Not Found");
        }
    }

    @Override
    public void deleteHotel(String id) {
        if (hotelRepository.existsById(id)){
            hotelRepository.deleteById(id);
        }else {
            throw new InvalidException("Invalid Hotel ID");
        }
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return mapper.map(hotelRepository.findAll(), new TypeToken<List<HotelDto>>() {
        }.getType());

    }


    @Override
    public HotelDto searchHotel(String id) {
        if (hotelRepository.existsById(id)){
            Hotel hotel = hotelRepository.findById(id).get();
            return mapper.map(hotel,HotelDto.class);
        }else {
            throw new NotFoundException("Hotel not Found");
        }

    }

    @Override
    public List<HotelDto> findByHotelCategory(String category) {
        return mapper.map(hotelRepository.findByCategory(category), new TypeToken<List<HotelDto>>() {
        }.getType());
    }


}
