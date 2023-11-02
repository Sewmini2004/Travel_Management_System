package lk.ijse.springboot.guideService.repository;


import lk.ijse.springboot.guideService.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,Long> {

}
