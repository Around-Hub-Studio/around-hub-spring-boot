package studio.thinkground.aroundhub.mvc.client.portal;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import studio.thinkground.aroundhub.mvc.client.portal.kakao.KakaoPortalClient;
import studio.thinkground.aroundhub.mvc.client.portal.naver.NaverPortalClient;

@Configuration
public class PortalClientConfig {
  @Bean
  @ConditionalOnProperty(prefix = "around.hub", name = "portal", havingValue = "naver")
  public PortalClient naverPortalApi() {
    return new NaverPortalClient();
  }

  @Bean
  @ConditionalOnProperty(prefix = "around.hub", name = "portal", havingValue = "kakao")
  public PortalClient kakaoPortalApi() {
    return new KakaoPortalClient();
  }
}
