package studio.thinkground.aroundhub.mvc.data.dao;

import studio.thinkground.aroundhub.mvc.data.entity.ShortUrl;

public interface ShortUrlDAO {

  ShortUrl saveShortUrl(ShortUrl shortUrl);

  ShortUrl getShortUrl(String originalUrl);

  ShortUrl getOriginalUrl(String shortUrl);

  ShortUrl updateShortUrl(ShortUrl newShortUrl);

  void deleteByShortUrl(String shortUrl);

  void deleteByOriginalUrl(String originalUrl);
}
