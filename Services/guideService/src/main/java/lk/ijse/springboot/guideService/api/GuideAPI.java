package lk.ijse.springboot.guideService.api;

import jakarta.validation.Valid;
import lk.ijse.springboot.guideService.bo.GuideBO;
import lk.ijse.springboot.guideService.dto.GuideDTO;
import lk.ijse.springboot.guideService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/guideService")
@CrossOrigin
public class GuideAPI {
    @Autowired
    GuideBO guideBO;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(@Valid GuideDTO guideDTO) throws IOException {
        guideBO.save(guideDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(String id,@RequestBody @Valid  GuideDTO guideDTO) throws IOException {
        guideBO.update(id, guideDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       guideBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        GuideDTO guideDTO = guideBO.search(id);
        return new  ResponseUtil(200,"OK", guideDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<GuideDTO> all= guideBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
