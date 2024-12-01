package studio.thinkground.aroundhub.mvc.url.repository;

import studio.thinkground.aroundhub.mvc.url.entity.ShortUrl;

public interface ShortUrlDAO {

  ShortUrl saveShortUrl(ShortUrl shortUrl);

  ShortUrl getShortUrl(String originalUrl);

  ShortUrl getOriginalUrl(String shortUrl);

  ShortUrl updateShortUrl(ShortUrl newShortUrl);

  void deleteByShortUrl(String shortUrl);

  void deleteByOriginalUrl(String originalUrl);
}
