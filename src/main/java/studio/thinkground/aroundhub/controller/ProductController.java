package studio.thinkground.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.aroundhub.data.dto.ProductDto;
import studio.thinkground.aroundhub.dto.MemberDTO;
import studio.thinkground.aroundhub.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService){
    this.productService = productService;
  }

  // http://localhost:8080/api/v1/product-api/product/{productId}
  @GetMapping(value = "/product/{productId}")
  public ProductDto getProduct(@PathVariable String productId) {
    return productService.getProduct(productId);
  }

  // http://localhost:8080/api/v1/product-api/product
  @PostMapping(value = "/product")
  public ProductDto createProduct(@RequestBody ProductDto productDto) {

    String productId = productDto.getProductId();
    String productName = productDto.getProductName();
    int productPrice = productDto.getProductPrice();
    int productStock = productDto.getProductStock();

    return productService.saveProduct(productId,productName,productPrice,productStock);
  }

  // http://localhost:8080/api/v1/product-api/product/{productId}
  @DeleteMapping(value = "/product/{productId}")
  public ProductDto deleteProduct(@PathVariable String productId) {
    return null;
  }

}
