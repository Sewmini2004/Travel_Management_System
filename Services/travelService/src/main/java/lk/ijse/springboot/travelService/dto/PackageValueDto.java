package lk.ijse.springboot.travelService.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class PackageValueDto {
    @Positive(message = "Vehicle Fee shouldn't be empty")
    @Min(value = 1, message = "Vehicle Fee shouldn't be less than 0")
    private double vehicleFee;
    @Positive(message = "Per Day Hotel shouldn't be empty")
    @Min(value = 1, message = "Per Day Hotel shouldn't be less than 0")
    private double perDayHotel;
    @Positive(message = "Guide Fee shouldn't be empty")
    @Min(value = 1, message = "Guide Fee shouldn't be less than 0")
    private double guideFee;
}
