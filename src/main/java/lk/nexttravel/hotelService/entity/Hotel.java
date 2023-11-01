package lk.nexttravel.hotelService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String location;
    private String hotelLocationMap;
    private String hotelEmail;
    private String contactNo;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] hotelImage;
    private String category;
    private double hotelFee;
    private String cancellation;
    private String remarks;
}
