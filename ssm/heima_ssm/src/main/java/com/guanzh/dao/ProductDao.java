package com.guanzh.dao;

import com.guanzh.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll();

    //根据id查询
    @Select("select * from product where id = #{id}")
    public Product findById(String id);

    //添加产品
    @Insert("insert into\n" +
             "product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)\n" +
             "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
