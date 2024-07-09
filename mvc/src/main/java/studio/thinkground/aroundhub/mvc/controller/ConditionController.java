package studio.thinkground.aroundhub.mvc.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.mvc.util.PortalApi;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condition")
public class ConditionController {
  private final PortalApi portalApi;

  @GetMapping
  public String integratePortal() {
    return portalApi.integrate();
  }
}
