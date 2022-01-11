package studio.thinkground.aroundhub.data.dao;

import studio.thinkground.aroundhub.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(String productId);

}
