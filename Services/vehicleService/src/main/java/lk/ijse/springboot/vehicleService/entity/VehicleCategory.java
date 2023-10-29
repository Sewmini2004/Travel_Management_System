package lk.ijse.springboot.vehicleService.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity

public class VehicleCategory {
    @Id
    private String vehicleCategoryId;
    private String economy;
    private String midRange;
    private String luxury;
    private String superLuxury;
    @OneToMany(mappedBy = "vehicleCategory",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
