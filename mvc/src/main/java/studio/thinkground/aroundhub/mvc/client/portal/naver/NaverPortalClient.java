package studio.thinkground.aroundhub.mvc.client.portal.naver;

import lombok.extern.slf4j.Slf4j;

import studio.thinkground.aroundhub.mvc.client.portal.PortalClient;

@Slf4j
public class NaverPortalClient implements PortalClient {
  public NaverPortalClient() {
    log.info("[PortalApi] Naver Portal API");
  }

  @Override
  public String integrate() {
    return "Naver integration succeeded";
  }
}
