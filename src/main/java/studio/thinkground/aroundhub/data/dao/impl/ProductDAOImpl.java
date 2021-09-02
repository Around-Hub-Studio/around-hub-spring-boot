package studio.thinkground.aroundhub.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.dao.ProductDAO;
import studio.thinkground.aroundhub.data.entity.ProductEntity;
import studio.thinkground.aroundhub.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

  ProductRepository productRepository;

  @Autowired
  public ProductDAOImpl(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  @Override
  public ProductEntity saveProduct(ProductEntity productEntity) {
    productRepository.save(productEntity);
    return productEntity;
  }

  @Override
  public ProductEntity getProduct(String productId) {
    ProductEntity productEntity = productRepository.getById(productId);
    return productEntity;
  }

  /**
   * Repository에서 기본적으로 제공하는 대표적인 메소드
   */
  private void testRepositoryMethod(){
/*    productRepository.save();
    productRepository.getById();
    productRepository.delete();
    productRepository.deleteAll();
    productRepository.findAll();
    productRepository.saveAll();*/
  }
}
