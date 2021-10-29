package studio.thinkground.aroundhub.data.dao;

import studio.thinkground.aroundhub.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);

}
