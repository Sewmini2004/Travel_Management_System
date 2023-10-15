package lk.ijse.springboot.travelService.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable

public class PackageValue {
    private double vehicleFee;
    private double perDayHotel;
    private double guideFee;
}
