package studio.thinkground.aroundhub.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import studio.thinkground.aroundhub.data.entity.Product;

/**
 * PackageName : studio.thinkground.aroundhub.data.repository
 * FileName : DevProductRepositoryTest
 * Author : Flature
 * Date : 2022-05-11
 * Description :
 */
@SpringBootTest
@ActiveProfiles("dev")
public class DevProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void devTest(){
        Product product = Product.builder()
                .id("testProduct")
                .name("testP")
                .price(1000)
                .stock(500)
                .build();

        productRepository.save(product);
    }

}
