package lk.ijse.springboot.travelService.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Duration {
    private Date startDate;
    private Date endDate;
    private int countOfDays;
    private int countOfNight;

}
