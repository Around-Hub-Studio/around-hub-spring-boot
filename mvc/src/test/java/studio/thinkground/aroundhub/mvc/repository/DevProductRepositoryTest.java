package studio.thinkground.aroundhub.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;

import studio.thinkground.aroundhub.mvc.data.entity.Product;
import studio.thinkground.aroundhub.mvc.data.repository.ProductRepository;

/**
 * PackageName : studio.thinkground.aroundhub.data.repository FileName : DevProductRepositoryTest
 * Author : Flature Date : 2022-05-11 Description :
 */
@SpringBootTest
@ActiveProfiles("dev")
public class DevProductRepositoryTest {

  @Autowired ProductRepository productRepository;

  @Test
  void devTest() {
    Product product =
        Product.builder().id("testProduct").name("testP").price(1000).stock(500).build();

    productRepository.save(product);
  }
}
