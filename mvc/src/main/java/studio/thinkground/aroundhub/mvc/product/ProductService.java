package studio.thinkground.aroundhub.mvc.product;

import studio.thinkground.aroundhub.mvc.product.dto.ProductRequest;

public interface ProductService {

  ProductRequest saveProduct(
      String productId, String productName, int productPrice, int productStock);

  ProductRequest getProduct(String productId);
}
