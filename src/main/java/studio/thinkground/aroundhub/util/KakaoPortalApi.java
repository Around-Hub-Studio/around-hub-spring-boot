package studio.thinkground.aroundhub.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoPortalApi implements PortalApi{
  public KakaoPortalApi() {
    log.info("[PortalApi] Kakao Portal API");
  }
  @Override
  public String integrate() {
    return "Kakao integration succeeded";
  }
}
