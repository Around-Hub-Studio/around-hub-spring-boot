package studio.thinkground.aroundhub.mvc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.thinkground.aroundhub.mvc.product.dto.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

  ProductDataHandler productDataHandler;

  @Autowired
  public ProductServiceImpl(ProductDataHandler productDataHandler) {
    this.productDataHandler = productDataHandler;
  }

  @Override
  public ProductRequest saveProduct(
      String productId, String productName, int productPrice, int productStock) {

    LOGGER.info("[saveProduct] productDataHandler 로 상품 정보 저장 요청");
    Product product =
        productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

    LOGGER.info("[saveProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}", product.getId());
    ProductRequest productRequest =
        new ProductRequest(
            product.getId(), product.getName(), product.getPrice(), product.getStock());

    return productRequest;
  }

  @Override
  public ProductRequest getProduct(String productId) {

    LOGGER.info("[getProduct] productDataHandler 로 상품 정보 조회 요청");
    Product product = productDataHandler.getProductEntity(productId);

    LOGGER.info("[getProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}", product.getId());
    ProductRequest productRequest =
        new ProductRequest(
            product.getId(), product.getName(), product.getPrice(), product.getStock());

    return productRequest;
  }
}
