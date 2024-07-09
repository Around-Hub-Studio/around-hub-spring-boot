package studio.thinkground.aroundhub.mvc.service;

import studio.thinkground.aroundhub.mvc.data.dto.ProductDto;

public interface ProductService {

  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

  ProductDto getProduct(String productId);
}
