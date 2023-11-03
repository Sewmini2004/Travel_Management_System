package lk.ijse.springboot.travelService.bo.impl;

import lk.ijse.springboot.travelService.bo.TravelBO;
import lk.ijse.springboot.travelService.bo.exception.NotFoundException;
import lk.ijse.springboot.travelService.dto.TravelDTO;
import lk.ijse.springboot.travelService.dto.other_service_dto.UserDTO;
import lk.ijse.springboot.travelService.entity.Travel;
import lk.ijse.springboot.travelService.repository.TravelRepo;
import lk.ijse.springboot.travelService.util.EntityDTOConversion;
import lk.ijse.springboot.travelService.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class TravelBoImpl implements TravelBO {

    private final TravelRepo travelRepo;
    private final EntityDTOConversion entityDTOConversion;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClientBuilder;

    public TravelBoImpl(TravelRepo travelRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper, WebClient.Builder webClientBuilder) {
        this.travelRepo = travelRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
        this.webClientBuilder = webClientBuilder;
    }


    @Override
    public void save(TravelDTO travelDTO) throws IOException {
        WebClient webClient = webClientBuilder.build();
//        TODO: check vehicle,guide,user,hotel form other services
//         1-> user
//         2-> hotel vehicle
//         3-> guide

        ResponseUtil userFromUserService = webClient
                .get() //@GetMapping kothnd gatway
                .uri("lb://user-service/api/userService/" + travelDTO.getUserId())
                .retrieve()
                .bodyToMono(ResponseUtil.class)
                .doOnError(throwable -> {
                    throw new NotFoundException("User not found");
                })
                .block();
        LinkedHashMap user = (LinkedHashMap) userFromUserService.getData();
        if (user != null){
            //hotel
            ResponseUtil hotelFormService = webClient
                    .get()
                    .uri("lb://hotel-service/api/hotelService/" + travelDTO.getHotelId())
                    .retrieve()
                    .bodyToMono(ResponseUtil.class)
                    .doOnError(throwable -> {
                        throw new NotFoundException("Hotel Is not found");
                    })
                    .block();

            LinkedHashMap hotel = (LinkedHashMap) hotelFormService.getData();

            if(hotel!=null){

                //vehicle

                ResponseUtil vehicleFormService = webClient
                        .get()
                        .uri("lb://vehicle-service/api/vehicleService/" + travelDTO.getVehicleId())
                        .retrieve()
                        .bodyToMono(ResponseUtil.class)
                        .doOnError(throwable -> {
                            throw new NotFoundException("Vehicle Is not found");
                        })
                        .block();

                LinkedHashMap vehicle = (LinkedHashMap) vehicleFormService.getData();


                if(vehicle!=null) {

                    //guide

                    ResponseUtil guideFormService = webClient
                            .get()
                            .uri("lb://guide-service/api/guideService/" + travelDTO.getGuideId())
                            .retrieve()
                            .bodyToMono(ResponseUtil.class)
                            .doOnError(throwable -> {
                                throw new NotFoundException("Guide Is not found");
                            })
                            .block();

                    LinkedHashMap guide = (LinkedHashMap) guideFormService.getData();



                    if(guide!=null) {

                        travelDTO.setPackageId(generateNextId());
                        Travel travelEntity = travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
                        String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
                        travelEntity.setUserNIC_images(imgBase64);
                        travelRepo.save(travelEntity);


                    }
                }
            }
        }




    }

    @Override
    public void delete(String id) {
        if (travelRepo.existsById(id)) {
            travelRepo.deleteById(id);
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public void update(String id, TravelDTO travelDTO) throws IOException {
        if (travelRepo.existsById(id)) {
            String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
            entityDTOConversion.getTravelEntity(travelDTO).setUserNIC_images(imgBase64);
            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public TravelDTO search(String id) {
        if (travelRepo.existsById(id)) {
            Travel travel = travelRepo.findById(id).get();
            return entityDTOConversion.getTravelDTO(travel);
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public List<TravelDTO> getAll() {
        List<Travel> all = travelRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<TravelDTO>>() {
        }.getType());
    }

    @Override
    public String generateNextId() {
        return String.format("NEXT_%06d", travelRepo.findAll().size() + 1);
    }
}
