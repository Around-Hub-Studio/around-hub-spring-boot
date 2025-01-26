package studio.thinkground.reactive.user;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

  private final UserService userService;

  public Mono<ServerResponse> getAllUsers(ServerRequest request) {
    Flux<User> users = userService.getAllUsers();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
  }

  public Mono<ServerResponse> getUserById(ServerRequest request) {
    String id = request.pathVariable("id");
    return userService
        .getUserById(Long.parseLong(id))
        .flatMap(
            user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(user))
        .switchIfEmpty(ServerResponse.notFound().build());
  }
}
