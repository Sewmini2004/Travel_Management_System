package lk.ijse.springboot.vehicleService.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String vehicleCategoryId;
    private String economy;
    private String midRange;
    private String luxury;
    private String superLuxury;
    @OneToMany(mappedBy = "vehicleCategory",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
