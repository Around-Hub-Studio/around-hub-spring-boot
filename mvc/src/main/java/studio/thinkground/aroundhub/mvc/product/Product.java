package studio.thinkground.aroundhub.mvc.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import studio.thinkground.aroundhub.mvc.common.entity.BaseEntity;
import studio.thinkground.aroundhub.mvc.product.dto.ProductRequest;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product")
public class Product extends BaseEntity {

  @Id String id;

  String name;

  Integer price;

  Integer stock;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

  public ProductRequest toDto() {
    return ProductRequest.builder()
        .productId(id)
        .productName(name)
        .productPrice(price)
        .productStock(stock)
        .build();
  }
}
