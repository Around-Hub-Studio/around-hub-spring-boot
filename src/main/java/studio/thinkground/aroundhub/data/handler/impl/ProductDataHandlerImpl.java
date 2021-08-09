package studio.thinkground.aroundhub.data.handler.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.dao.ProductDAO;
import studio.thinkground.aroundhub.data.entity.ProductEntity;
import studio.thinkground.aroundhub.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

  ProductDAO productDAO;

  @Autowired
  public ProductDataHandlerImpl(ProductDAO productDAO){
    this.productDAO = productDAO;
  }

  @Override
  public ProductEntity saveProductEntity(String productId, String productName, int productPrice,
      int productStock) {
    ProductEntity productEntity = new ProductEntity(productId, productName, productPrice,
        productStock);

    return productDAO.saveProduct(productEntity);
  }

  @Override
  public ProductEntity getProductEntity(String productId) {
    return productDAO.getProduct(productId);
  }
}
