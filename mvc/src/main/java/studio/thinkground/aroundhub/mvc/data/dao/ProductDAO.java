package studio.thinkground.aroundhub.mvc.data.dao;

import studio.thinkground.aroundhub.mvc.data.entity.Product;

public interface ProductDAO {

  Product saveProduct(Product product);

  Product getProduct(String productId);
}
