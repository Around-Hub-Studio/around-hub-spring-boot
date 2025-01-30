package studio.thinkground.reactive.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/controller")
public class BasicController {

  @GetMapping("/hello")
  public Mono<String> hello() {
    return Mono.just("Hello, Around Hub Studio!");
  }

  @GetMapping("/hello/{name}")
  public Mono<String> hello(@PathVariable String name) {
    return Mono.just("Hello, " + name + "!");
  }

  @GetMapping("/greet")
  public Mono<String> greet(@RequestParam(defaultValue = "Guest") String name) {
    return Mono.just("Hello, " + name + "!");
  }

  @GetMapping("/check-header")
  public Mono<String> checkHeader(
      @RequestHeader(name = "X-Request-ID", required = false) String requestId) {
    if (requestId == null) {
      return Mono.just("X-Request-ID is null");
    }
    return Mono.just("Request Id: " + requestId);
  }
}
