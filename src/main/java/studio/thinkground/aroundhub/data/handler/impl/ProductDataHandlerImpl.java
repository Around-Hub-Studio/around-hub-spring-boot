package studio.thinkground.aroundhub.data.handler.impl;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.aroundhub.data.dao.ProductDAO;
import studio.thinkground.aroundhub.data.entity.ProductEntity;
import studio.thinkground.aroundhub.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductDataHandlerImpl.class);

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice,
        int productStock) {

        LOGGER.debug("[saveProductEntity] 매개변수를 통해 Entity 객체 생성");
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice,
            productStock);

        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 저장 요청. productId : {}", productId);
        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        LOGGER.info("[saveProductEntity] productDAO로 Product 정보 요청. productId : {}", productId);
        return productDAO.getProduct(productId);
    }
}
