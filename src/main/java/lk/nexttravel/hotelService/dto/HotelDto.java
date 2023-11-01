package lk.nexttravel.hotelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDto {

    private String hotelId;
    private String hotelName;
    private String location;
    private String hotelLocationMap;
    private String hotelEmail;
    private byte[] hotelImage;
    private String contactNo;
    private String category;
    private double hotelFee;
    private String cancellation;
    private String remarks;



}
