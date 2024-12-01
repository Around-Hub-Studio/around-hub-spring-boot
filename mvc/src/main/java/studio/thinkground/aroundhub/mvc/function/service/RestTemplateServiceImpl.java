package studio.thinkground.aroundhub.mvc.function.service;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

  private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

  @Override
  public String getAroundHub() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/around-hub")
            .encode()
            .build()
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public String getName() {

    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/name")
            .queryParam("name", "Flature")
            .encode()
            .build()
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public String getName2() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/path-variable/{name}")
            .encode()
            .build()
            .expand("Flature") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public ResponseEntity<MemberRequest> postDto() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/member")
            .queryParam("name", "Flature")
            .queryParam("email", "jjj@jjj.com")
            .queryParam("organization", "Around Hub Studio")
            .encode()
            .build()
            .toUri();

    MemberRequest memberRequest = new MemberRequest();
    memberRequest.setName("flature!!");
    memberRequest.setEmail("aaa@aaa.com");
    memberRequest.setOrganization("Around Hub Studio!!");

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberRequest> responseEntity =
        restTemplate.postForEntity(uri, memberRequest, MemberRequest.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity;
  }

  @Override
  public ResponseEntity<MemberRequest> addHeader() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/add-header")
            .encode()
            .build()
            .toUri();

    MemberRequest memberRequest = new MemberRequest();
    memberRequest.setName("flature");
    memberRequest.setEmail("jjj@jjj.com");
    memberRequest.setOrganization("Around Hub Studio");

    RequestEntity<MemberRequest> requestEntity =
        RequestEntity.post(uri).header("around-header", "Around Hub Studio").body(memberRequest);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberRequest> responseEntity =
        restTemplate.exchange(requestEntity, MemberRequest.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity;
  }
}
