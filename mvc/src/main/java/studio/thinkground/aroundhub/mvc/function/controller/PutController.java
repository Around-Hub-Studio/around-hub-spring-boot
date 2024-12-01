package studio.thinkground.aroundhub.mvc.function.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

  // http://localhost:8080/api/v1/put-api/default
  @PutMapping(value = "/default")
  public String putMethod() {
    return "Hello World!";
  }

  // http://localhost:8080/api/v1/put-api/member
  @PutMapping(value = "/member")
  public String postMember(@RequestBody Map<String, Object> putData) {
    StringBuilder sb = new StringBuilder();

    putData
        .entrySet()
        .forEach(
            map -> {
              sb.append(map.getKey() + " : " + map.getValue() + "\n");
            });

    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
     */

    return sb.toString();
  }

  // http://localhost:8080/api/v1/put-api/member2
  @PutMapping(value = "/member1")
  public String postMemberDto1(@RequestBody MemberRequest memberRequest) {
    return memberRequest.toString();
  }

  // http://localhost:8080/api/v1/put-api/member2
  @PutMapping(value = "/member2")
  public MemberRequest postMemberDto2(@RequestBody MemberRequest memberRequest) {
    return memberRequest;
  }

  // http://localhost:8080/api/v1/put-api/member2
  @PutMapping(value = "/member3")
  public ResponseEntity<MemberRequest> postMemberDto3(@RequestBody MemberRequest memberRequest) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberRequest);
  }
}