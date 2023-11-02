package lk.ijse.springboot.vehicleService;

import jakarta.annotation.PostConstruct;
import lk.ijse.springboot.vehicleService.bo.VehicleCategoryBO;
import lk.ijse.springboot.vehicleService.dto.VehicleCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
public class VehicleServiceApplication {

    @Autowired
    private VehicleCategoryBO categoryBO;

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

    @PostConstruct
    public void saveVehicleCategory() {
       if(categoryBO.isEmpty()){
           ArrayList<VehicleCategoryDto> vehicleCategoryDtos = new ArrayList<>();
           Collections.addAll(vehicleCategoryDtos,
                   new VehicleCategoryDto("economy", null),
                   new VehicleCategoryDto("midRange", null),
                   new VehicleCategoryDto("luxury", null),
                   new VehicleCategoryDto("superLuxury", null)
           );
           categoryBO.saveCategories(vehicleCategoryDtos);
       }
    }
}
