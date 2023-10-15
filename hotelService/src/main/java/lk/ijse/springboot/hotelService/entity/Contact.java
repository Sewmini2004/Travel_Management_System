package lk.ijse.springboot.hotelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Embeddable
@Table(name = "contact_nb")
public class Contact {
    private String contactNumber_1;
    private String contactNumber_2;
}
