package studio.thinkground.aroundhub.mvc.function.service;

import org.springframework.http.ResponseEntity;

import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

public interface RestTemplateService {

  String getAroundHub();

  String getName();

  String getName2();

  ResponseEntity<MemberRequest> postDto();

  ResponseEntity<MemberRequest> addHeader();
}
