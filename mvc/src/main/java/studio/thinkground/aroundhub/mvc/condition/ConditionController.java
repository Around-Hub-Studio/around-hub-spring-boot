package studio.thinkground.aroundhub.mvc.condition;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.mvc.client.portal.PortalClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condition")
public class ConditionController {
  private final PortalClient portalClient;

  @GetMapping
  public String integratePortal() {
    return portalClient.integrate();
  }
}
