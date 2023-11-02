package lk.ijse.springboot.hotelService.api;

import jakarta.validation.Valid;
import lk.ijse.springboot.hotelService.bo.HotelBO;
import lk.ijse.springboot.hotelService.dto.HotelDTO;

import lk.ijse.springboot.hotelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/hotelService")
@CrossOrigin
public class HotelAPI {
    private final HotelBO hotelBO;

    public HotelAPI(HotelBO hotelBO) {
        this.hotelBO = hotelBO;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(@ModelAttribute @Valid HotelDTO hotelDTO){
        hotelBO.save(hotelDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }


    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(String id,@RequestBody  @Valid  HotelDTO hotelDTO){
        hotelBO.update(id, hotelDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       hotelBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        HotelDTO hotelDTO = hotelBO.search(id);
        return new  ResponseUtil(200,"OK", hotelDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<HotelDTO> all= hotelBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
