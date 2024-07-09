package studio.thinkground.aroundhub.mvc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.aroundhub.mvc.data.entity.ShortUrl;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

  ShortUrl findByUrl(String url);

  ShortUrl findByOrgUrl(String originalUrl);
}
