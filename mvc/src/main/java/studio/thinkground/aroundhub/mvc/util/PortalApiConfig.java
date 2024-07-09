package studio.thinkground.aroundhub.mvc.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortalApiConfig {
  @Bean
  @ConditionalOnProperty(prefix = "around.hub", name = "portal", havingValue = "naver")
  public PortalApi naverPortalApi() {
    return new NaverPortalApi();
  }

  @Bean
  @ConditionalOnProperty(prefix = "around.hub", name = "portal", havingValue = "kakao")
  public PortalApi kakaoPortalApi() {
    return new KakaoPortalApi();
  }
}
