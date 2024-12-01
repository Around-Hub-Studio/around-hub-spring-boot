package studio.thinkground.aroundhub.mvc.client.portal.kakao;

import lombok.extern.slf4j.Slf4j;

import studio.thinkground.aroundhub.mvc.client.portal.PortalClient;

@Slf4j
public class KakaoPortalClient implements PortalClient {
  public KakaoPortalClient() {
    log.info("[PortalApi] Kakao Portal API");
  }

  @Override
  public String integrate() {
    return "Kakao integration succeeded";
  }
}
