package lk.ijse.springboot.travelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Table(name = "travelDays")
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Duration {
    @NotEmpty(message = "Start Date shouldn't be empty")
    private Date startDate;
    @NotEmpty(message = "End Date shouldn't be empty")
    private Date endDate;
    @Min(value = 1, message = "Day count shouldn't be less than 0")
    @Max(value = 7, message = "Day count  shouldn't be greater than 7")
    private int countOfDays;
    @Min(value = 1, message = "Night count shouldn't be less than 0")
    @Max(value = 7, message = "Night count  shouldn't be greater than 7")
    private int countOfNight;

}
