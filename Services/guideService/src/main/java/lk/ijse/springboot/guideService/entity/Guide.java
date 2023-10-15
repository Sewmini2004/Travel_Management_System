package lk.ijse.springboot.guideService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Guide implements Super {
    @Id
    private String guideId;
    private String guideName;
    private String guideAddress;
    private String address;
    private byte[] guideIdImage;
    private String gender;
    private String contactNumber;
    private byte[] nicImage;
    private String Experience;
    private int manDayValue;
    private String remarks;

}
