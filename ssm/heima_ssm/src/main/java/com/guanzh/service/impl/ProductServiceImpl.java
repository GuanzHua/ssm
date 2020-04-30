package com.guanzh.service.impl;

import com.guanzh.dao.ProductDao;
import com.guanzh.domain.Product;
import com.guanzh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 查询所有产品信息
     *
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * 添加产品
     * @param product
     */
    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
