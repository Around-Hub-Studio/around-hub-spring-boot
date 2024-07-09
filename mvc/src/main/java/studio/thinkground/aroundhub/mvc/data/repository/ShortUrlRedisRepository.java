package studio.thinkground.aroundhub.mvc.data.repository;

import org.springframework.data.repository.CrudRepository;

import studio.thinkground.aroundhub.mvc.data.dto.ShortUrlResponseDto;

/**
 * PackageName : studio.thinkground.aroundhub.data.repository FileName : ShortUrlRedisRepository
 * Author : Flature Date : 2022-05-21 Description :
 */
public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {}
