package studio.thinkground.aroundhub.mvc.service;

import org.springframework.http.ResponseEntity;

import studio.thinkground.aroundhub.mvc.data.dto.MemberDTO;

public interface RestTemplateService {

  public String getAroundHub();

  public String getName();

  public String getName2();

  public ResponseEntity<MemberDTO> postDto();

  public ResponseEntity<MemberDTO> addHeader();
}
