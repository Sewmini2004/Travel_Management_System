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
    private String category;
    @OneToMany(mappedBy = "vehicleCategory",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
}

