package studio.thinkground.aroundhub.mvc.function.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import studio.thinkground.aroundhub.mvc.member.dto.MemberRequest;

@Service
public class RestClientServiceImpl implements RestClientService {

  public String getName() {
    RestClient restClient =
        RestClient.builder()
            .baseUrl("http://localhost:9090")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    return restClient.get().uri("/api/v1/crud-api").retrieve().body(String.class);
  }

  public String getNameWithPathVariable() {
    RestClient restClient = RestClient.create("http://localhost:9090");

    ResponseEntity<String> responseEntity =
        restClient
            .get()
            .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/{name}").build("Flature"))
            .retrieve()
            .toEntity(String.class);

    ResponseEntity<String> responseEntity1 =
        restClient
            .get()
            .uri("/api/v1/crud-api/{name}", "Flature")
            .retrieve()
            .toEntity(String.class);

    return responseEntity.getBody();
  }

  public String getNameWithParameter() {
    RestClient restClient = RestClient.create("http://localhost:9090");

    return restClient
        .get()
        .uri(
            uriBuilder ->
                uriBuilder.path("/api/v1/crud-api/param").queryParam("name", "Flature").build())
        .retrieve()
        .onStatus(
            HttpStatusCode::is4xxClientError,
            (request, response) -> {
              throw new RuntimeException("400 Error occurred");
            })
        .onStatus(
            HttpStatusCode::is5xxServerError,
            (request, response) -> {
              throw new RuntimeException("500 Error occurred");
            })
        .body(String.class);
  }

  public ResponseEntity<MemberRequest> postWithParamAndBody() {
    RestClient restClient =
        RestClient.builder()
            .baseUrl("http://localhost:9090")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    MemberRequest memberRequest = new MemberRequest();
    memberRequest.setName("flature!!");
    memberRequest.setEmail("flature@gmail.com");
    memberRequest.setOrganization("Around Hub Studio");

    return restClient
        .post()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/api/v1/crud-api")
                    .queryParam("name", "Flature")
                    .queryParam("email", "flature@wikibooks.co.kr")
                    .queryParam("organization", "Wikibooks")
                    .build())
        .body(memberRequest)
        .retrieve()
        .toEntity(MemberRequest.class);
  }

  public ResponseEntity<MemberRequest> postWithHeader() {
    RestClient restClient =
        RestClient.builder()
            .baseUrl("http://localhost:9090")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    MemberRequest memberRequest = new MemberRequest();
    memberRequest.setName("flature!!");
    memberRequest.setEmail("flature@gmail.com");
    memberRequest.setOrganization("Around Hub Studio");

    return restClient
        .post()
        .uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/add-header").build())
        .body(memberRequest)
        .header("my-header", "Wikibooks API")
        .retrieve()
        .toEntity(MemberRequest.class);
  }
}
