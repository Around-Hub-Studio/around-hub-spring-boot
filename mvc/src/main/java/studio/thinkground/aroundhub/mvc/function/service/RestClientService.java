package studio.thinkground.aroundhub.mvc.function.service;

import org.springframework.http.ResponseEntity;

import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

public interface RestClientService {

  String getName();

  String getNameWithPathVariable();

  String getNameWithParameter();

  ResponseEntity<MemberRequest> postWithParamAndBody();

  ResponseEntity<MemberRequest> postWithHeader();
}
