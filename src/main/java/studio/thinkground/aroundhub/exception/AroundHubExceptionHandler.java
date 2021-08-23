package studio.thinkground.aroundhub.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AroundHubExceptionHandler {

  private final Logger LOGGER = LoggerFactory.getLogger(AroundHubExceptionHandler.class);

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
    HttpHeaders responseHeaders = new HttpHeaders();
    //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    LOGGER.info("Advice 내 ExceptionHandler 호출");

    Map<String, String> map = new HashMap<>();
    map.put("error type", httpStatus.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "에러 발생");

    return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }

}
