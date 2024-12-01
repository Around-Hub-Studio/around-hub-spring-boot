package studio.thinkground.aroundhub.mvc.product;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studio.thinkground.aroundhub.mvc.common.constant.Constants;
import studio.thinkground.aroundhub.mvc.common.exception.AroundHubException;
import studio.thinkground.aroundhub.mvc.product.dto.ProductRequest;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // http://localhost:8080/api/v1/product-api/product/{productId}
  @GetMapping(value = "/product/{productId}")
  public ProductRequest getProduct(@PathVariable String productId) {

    long startTime = System.currentTimeMillis();
    LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

    ProductRequest productRequest = productService.getProduct(productId);

    LOGGER.info(
        "[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
        productRequest.getProductId(),
        productRequest.getProductName(),
        productRequest.getProductPrice(),
        productRequest.getProductStock(),
        (System.currentTimeMillis() - startTime));
    return productRequest;
  }

  // http://localhost:8080/api/v1/product-api/product
  @Parameters({
    @Parameter(
        name = "X-AUTH-TOKEN",
        description = "로그인 성공 후 access_token",
        required = true,
        schema = @Schema(implementation = String.class),
        in = ParameterIn.HEADER)
  })
  @PostMapping(value = "/product")
  public ResponseEntity<ProductRequest> createProduct(
      @Valid @RequestBody ProductRequest productRequest) {

    LOGGER.info("[createProduct] perform {} of Around Hub API.", "createProduct");

    // Validation Code Example
    if (productRequest.getProductId().equals("") || productRequest.getProductId().isEmpty()) {
      LOGGER.error("[createProduct] failed Response :: productId is Empty");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productRequest);
    }

    String productId = productRequest.getProductId();
    String productName = productRequest.getProductName();
    int productPrice = productRequest.getProductPrice();
    int productStock = productRequest.getProductStock();

    ProductRequest response =
        productService.saveProduct(productId, productName, productPrice, productStock);

    LOGGER.info(
        "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
        response.getProductId(),
        response.getProductName(),
        response.getProductPrice(),
        response.getProductStock());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // http://localhost:8080/api/v1/product-api/product/{productId}
  @Parameters({
    @Parameter(
        name = "X-AUTH-TOKEN",
        description = "로그인 성공 후 access_token",
        required = true,
        schema = @Schema(implementation = String.class),
        in = ParameterIn.HEADER)
  })
  @DeleteMapping(value = "/product/{productId}")
  public ProductRequest deleteProduct(@PathVariable String productId) {
    return null;
  }

  @PostMapping(value = "/product/exception")
  public void exceptionTest() throws AroundHubException {
    throw new AroundHubException(
        Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
  }
}
