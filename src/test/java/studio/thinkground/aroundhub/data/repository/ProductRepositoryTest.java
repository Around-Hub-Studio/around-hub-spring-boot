package studio.thinkground.aroundhub.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import studio.thinkground.aroundhub.data.entity.ProductEntity;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void basicCRUDTest() {

        /* create */
        // given
        ProductEntity productEntity = ProductEntity.builder()
            .productId("testProduct")
            .productName("testP")
            .productPrice(1000)
            .productStock(500)
            .build();

        // when
        ProductEntity savedEntity = productRepository.save(productEntity);

        // then
        Assertions.assertThat(savedEntity.getProductId())
            .isEqualTo(productEntity.getProductId());
        Assertions.assertThat(savedEntity.getProductName())
            .isEqualTo(productEntity.getProductName());
        Assertions.assertThat(savedEntity.getProductPrice())
            .isEqualTo(productEntity.getProductPrice());
        Assertions.assertThat(savedEntity.getProductStock())
            .isEqualTo(productEntity.getProductStock());

        /* read */
        // when
        ProductEntity selectedEntity = productRepository.findById("testProduct")
            .orElseThrow(() -> new RuntimeException());

        // then
        Assertions.assertThat(selectedEntity.getProductId())
            .isEqualTo(productEntity.getProductId());
        Assertions.assertThat(selectedEntity.getProductName())
            .isEqualTo(productEntity.getProductName());
        Assertions.assertThat(selectedEntity.getProductPrice())
            .isEqualTo(productEntity.getProductPrice());
        Assertions.assertThat(selectedEntity.getProductStock())
            .isEqualTo(productEntity.getProductStock());

        /* update */


        /* delete */

    }

}