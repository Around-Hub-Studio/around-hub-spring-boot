package studio.thinkground.reactive.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class BasicRouter {

  @Bean
  public RouterFunction<ServerResponse> basicRoute() {
    return RouterFunctions.route()
        .GET(
            "/api/router/hello",
            request -> ServerResponse.ok().bodyValue("Hello, Around Hub Studio!"))
        .GET(
            "/api/router/hello/{name}",
            request -> {
              String name = request.pathVariable("name");
              return ServerResponse.ok().bodyValue("Hello, " + name + "!");
            })
        .GET(
            "/api/router/greet",
            request -> {
              String name = request.queryParam("name").orElse("Guest");
              return ServerResponse.ok().bodyValue("Hello, " + name + "!");
            })
        .GET(
            "/api/router/check-header",
            request -> {
              String requestId = request.headers().firstHeader("X-Request-Id");
              String response =
                  (requestId == null) ? "No Request Id found" : "Request Id: " + requestId;
              return ServerResponse.ok().bodyValue(response);
            })
        .build();
  }
}
