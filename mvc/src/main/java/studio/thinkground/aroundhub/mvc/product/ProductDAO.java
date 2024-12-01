package studio.thinkground.aroundhub.mvc.product;

public interface ProductDAO {

  Product saveProduct(Product product);

  Product getProduct(String productId);
}
