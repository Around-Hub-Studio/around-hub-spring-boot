package studio.thinkground.aroundhub.mvc.function.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.mvc.function.service.RestTemplateService;
import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {

  RestTemplateService restTemplateService;

  @Autowired
  public RestTemplateController(RestTemplateService restTemplateService) {
    this.restTemplateService = restTemplateService;
  }

  @GetMapping(value = "/around-hub")
  public String getAroundHub() {
    return restTemplateService.getAroundHub();
  }

  @GetMapping(value = "/name")
  public String getName() {
    return restTemplateService.getName();
  }

  @GetMapping(value = "/name2")
  public String getName2() {
    return restTemplateService.getName2();
  }

  @PostMapping(value = "/dto")
  public ResponseEntity<MemberRequest> postDto() {
    return restTemplateService.postDto();
  }

  @PostMapping(value = "/add-header")
  public ResponseEntity<MemberRequest> addHeader() {
    return restTemplateService.addHeader();
  }
}
