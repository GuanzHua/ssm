package com.guanzh.dao;


import com.guanzh.domain.Member;
import com.guanzh.domain.Orders;
import com.guanzh.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.guanzh.dao.ProductDao.findById"))
    })
    List<Orders> findAll();

    //多表查询
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.guanzh.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,
                    one = @One(select = "com.guanzh.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = List.class,
                    many = @Many(select = "com.guanzh.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);
}
