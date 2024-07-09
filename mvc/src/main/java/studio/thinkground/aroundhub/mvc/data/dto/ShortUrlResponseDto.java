package studio.thinkground.aroundhub.mvc.data.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "shortUrl", timeToLive = 60)
public class ShortUrlResponseDto implements Serializable {

  private static final long serialVersionUID = -214490344996507077L;

  @Id private String orgUrl;

  private String shortUrl;
}
