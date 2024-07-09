package studio.thinkground.aroundhub.mvc.data.handler;

import studio.thinkground.aroundhub.mvc.data.entity.Product;

public interface ProductDataHandler {

  Product saveProductEntity(
      String productId, String productName, int productPrice, int productStock);

  Product getProductEntity(String productId);
}
