package lk.ijse.springboot.travelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
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
    private Date startDate;
    private Date endDate;
    private int countOfDays;
    private int countOfNight;

}
