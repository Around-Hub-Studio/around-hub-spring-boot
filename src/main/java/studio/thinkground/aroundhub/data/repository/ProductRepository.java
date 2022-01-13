package studio.thinkground.aroundhub.data.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import studio.thinkground.aroundhub.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    /* 쿼리 메소드의 주제 키워드 */

    // 조회
    List<Product> findByName(String name);
    List<Product> queryByName(String name);

    // 존재 유무
    boolean existsByName(String name);

    // 쿼리 결과 개수
    long countByName(String name);

    // 삭제
    void deleteByName(String name);
    long removeByName(String name);

    // 값 개수 제한
    List<Product> findFirst5ByName(String name);
    List<Product> findTop3ByName(String name);

    /* 쿼리 메소드의 조건자 키워드 */

    // Is, Equals (생략 가능)
    // Logical Keyword : IS , Keyword Expressions : Is, Equals, (or no keyword)
    // findByNumber 메소드와 동일하게 동작
    Product findByIdIs(String id);
    Product findByIdEquals(String id);

    // (Is)Not
    List<Product> findByIdNot(String id);
    List<Product> findByIdIsNot(String id);

    // (Is)Null, (Is)NotNull
    List<Product> findByStockIsNull();
    List<Product> findByStockIsNotNull();

    // And, Or
    List<Product> findTopByIdAndName(String id, String name);

    // (Is)GreaterThan, (Is)LessThan, (Is)Between
    List<Product> findByPriceGreaterThan(Integer price);

    // (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith
    List<Product> findByNameContaining(String name);


    /* 정렬과 페이징 */

    // Asc : 오름차순, Desc : 내림차순
    List<Product> findByNameContainingOrderByStockAsc(String name);
    List<Product> findByNameContainingOrderByStockDesc(String name);

    // 여러 정렬 기준 사용
    List<Product> findByNameContainingOrderByPriceAscStockDesc(String name);

    // 매개변수를 활용한 정렬
    List<Product> findByNameContaining(String name, Sort sort);

    // 페이징 처리하기
    List<Product> findByPriceGreaterThan(Integer price, Pageable pageable);


    /* @Query 사용하기 */

    @Query("SELECT p FROM Product p WHERE p.price > 2000")
    List<Product> findByPriceBasis();

    @Query(value = "SELECT * FROM product p WHERE p.price > 2000", nativeQuery = true)
    List<Product> findByPriceBasisNativeQuery();

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findByPriceWithParameter(Integer price);

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceWithParameterNaming(Integer price);

    @Query("SELECT p FROM Product p WHERE p.price > :pri")
    List<Product> findByPriceWithParameterNaming2(@Param("pri") Integer price);

    @Query(value = "SELECT * FROM product WHERE price > :price",
    countQuery = "SELECT count(*) FROM product WHERE price > ?1",
    nativeQuery = true)
    List<Product> findByPriceWithParameterPaging(Integer price, Pageable pageable);
}
