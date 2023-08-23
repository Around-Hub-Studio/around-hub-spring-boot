package studio.thinkground.aroundhub.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NaverPortalApi implements PortalApi{
  public NaverPortalApi() {
    log.info("[PortalApi] Naver Portal API");
  }
  @Override
  public String integrate() {
    return "Naver integration succeeded";
  }
}
