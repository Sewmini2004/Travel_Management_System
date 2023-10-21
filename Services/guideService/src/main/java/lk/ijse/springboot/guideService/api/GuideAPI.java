package lk.ijse.springboot.guideService.api;

import lk.ijse.springboot.guideService.bo.GuideBO;
import lk.ijse.springboot.guideService.dto.ResponseDTO;
import lk.ijse.springboot.guideService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guideService")
@CrossOrigin
public class GuideAPI {
    @Autowired
    GuideBO guideBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(ResponseDTO responseDTO){
        guideBO.save(responseDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(String id,@RequestBody ResponseDTO responseDTO){
        guideBO.update(id, responseDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       guideBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        ResponseDTO responseDTO = guideBO.search(id);
        return new  ResponseUtil(200,"OK", responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<ResponseDTO> all= guideBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
