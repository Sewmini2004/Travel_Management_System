package lk.ijse.springboot.travelService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DurationDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Min(value = 1, message = "Day count shouldn't be less than 0")
    @Max(value = 7, message = "Day count  shouldn't be greater than 7")
    private int countOfDays;
    @Min(value = 1, message = "Night count shouldn't be less than 0")
    @Max(value = 7, message = "Night count  shouldn't be greater than 7")
    private int countOfNight;

}
