package studio.thinkground.aroundhub.mvc.service;

import org.springframework.http.ResponseEntity;

import studio.thinkground.aroundhub.mvc.data.dto.MemberDTO;

public interface RestClientService {

  String getName();

  String getNameWithPathVariable();

  String getNameWithParameter();

  ResponseEntity<MemberDTO> postWithParamAndBody();

  ResponseEntity<MemberDTO> postWithHeader();
}
