package studio.thinkground.reactive.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouterConfig {

  @Bean
  public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler) {
    return route(GET("/users"), userHandler::getAllUsers)
        .andRoute(GET("/users/{id}"), userHandler::getUserById);
  }
}
