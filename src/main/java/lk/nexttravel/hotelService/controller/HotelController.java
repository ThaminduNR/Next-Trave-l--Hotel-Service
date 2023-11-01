package lk.nexttravel.hotelService.controller;

import lk.nexttravel.hotelService.dto.HotelDto;
import lk.nexttravel.hotelService.service.HotelService;
import lk.nexttravel.hotelService.util.IdGenerator;
import lk.nexttravel.hotelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("nexttravel/hotel/service")
@CrossOrigin
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestPart String hotelName,@RequestPart String location,String hotelLocationMap,
                                    @RequestPart String hotelEmail,@RequestPart byte[] hotelImage,@RequestPart String contactNo,
                                    @RequestPart String category,@RequestPart String fee,@RequestPart String cancellation,
                                    @RequestPart String remarks){

        double hotelFee = Double.parseDouble(fee);
        IdGenerator idGenerator = new IdGenerator();
        String hotelId = idGenerator.generateID();


        HotelDto hotelDto = new HotelDto(hotelId,hotelName, location, hotelLocationMap, hotelEmail, hotelImage,
                contactNo, category, hotelFee, cancellation, remarks);

        hotelService.saveHotel(hotelDto);
        return new ResponseUtil(200,"Hotel Saved",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestPart String hotelId,@RequestPart String hotelName,@RequestPart String location,String hotelLocationMap,
                                      @RequestPart String hotelEmail,@RequestPart byte[] hotelImage,@RequestPart String contactNo,
                                      @RequestPart String category,@RequestPart String fee,@RequestPart String cancellation,
                                      @RequestPart String remarks){

        double hotelFee = Double.parseDouble(fee);


        HotelDto hotelDto = new HotelDto(hotelId,hotelName, location, hotelLocationMap, hotelEmail, hotelImage,
                contactNo, category, hotelFee, cancellation, remarks);

        hotelService.updateHotel(hotelDto);
        return new ResponseUtil(200,"Hotel Updated",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle(){
        List<HotelDto> allHotels = hotelService.getAllHotels();
        return new ResponseUtil(200,"Get All",allHotels);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String id){
        hotelService.deleteHotel(id);

        return new ResponseUtil(200,"deleted",null);
    }


    @GetMapping(value = "/{id}")
    public ResponseUtil searchVehicle(@PathVariable String id){
        HotelDto hotelDto = hotelService.searchHotel(id);
        return new ResponseUtil(200,"search",hotelDto);
    }
    @GetMapping(params = {"category"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findByHotelCategory(@RequestParam String category){
        List<HotelDto> hotelCategory = hotelService.findByHotelCategory(category);
        return new ResponseUtil(200,"Hotel Category",hotelCategory);
    }

}
