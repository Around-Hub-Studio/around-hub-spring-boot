package studio.thinkground.aroundhub.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import studio.thinkground.aroundhub.data.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "product", timeToLive = 60)
public class ProductDto {

  //@Size(min = 8, max = 8) // abcdefg
  @NotNull
  private String productId;

  @NotNull
  @Id
  private String productName;

  @NotNull
  @Min(value = 500)
  @Max(value = 3000000)
  private int productPrice;

  @NotNull
  @Min(value = 0)
  @Max(value = 9999)
  private int productStock;

  public Product toEntity(){
    return Product.builder()
        .id(productId)
        .name(productName)
        .price(productPrice)
        .stock(productStock)
        .build();
  }

}
