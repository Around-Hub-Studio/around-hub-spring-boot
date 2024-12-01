package studio.thinkground.aroundhub.mvc.url.service;

import studio.thinkground.aroundhub.mvc.url.dto.ShortUrlResponse;

public interface ShortUrlService {

  ShortUrlResponse getShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponse generateShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponse updateShortUrl(String clientId, String clientSecret, String originalUrl);

  void deleteShortUrl(String url);
}
