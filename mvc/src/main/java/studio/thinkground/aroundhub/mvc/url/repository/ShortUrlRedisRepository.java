package studio.thinkground.aroundhub.mvc.url.repository;

import org.springframework.data.repository.CrudRepository;

import studio.thinkground.aroundhub.mvc.url.dto.ShortUrlResponse;

/**
 * PackageName : studio.thinkground.aroundhub.data.repository FileName : ShortUrlRedisRepository
 * Author : Flature Date : 2022-05-21 Description :
 */
public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponse, String> {}
