package studio.thinkground.aroundhub.data.handler;

import studio.thinkground.aroundhub.data.entity.Product;

public interface ProductDataHandler {

  Product saveProductEntity(String productId, String productName, int productPrice, int productStock);

  Product getProductEntity(String productId);

}
