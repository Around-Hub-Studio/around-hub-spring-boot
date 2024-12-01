package studio.thinkground.aroundhub.mvc.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.aroundhub.mvc.url.entity.ShortUrl;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

  ShortUrl findByUrl(String url);

  ShortUrl findByOrgUrl(String originalUrl);
}
