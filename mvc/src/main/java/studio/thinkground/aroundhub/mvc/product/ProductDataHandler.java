package studio.thinkground.aroundhub.mvc.product;

public interface ProductDataHandler {

  Product saveProductEntity(
      String productId, String productName, int productPrice, int productStock);

  Product getProductEntity(String productId);
}
