package studio.thinkground.aroundhub.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.aroundhub.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class DeleteController {

  // http://localhost:8080/api/v1/get-api/variable1/{String 값}
  @DeleteMapping(value = "/delete/{variable}")
  public String DeleteVariable(@PathVariable String variable) {
    return variable;
  }

}
