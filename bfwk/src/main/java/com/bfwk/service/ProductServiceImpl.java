package com.bfwk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfwk.common.utils.LimitClauseUtils;
import com.bfwk.exception.WkException;
import com.bfwk.mapper.ProductMapper;
import com.bfwk.model.Product;
import com.bfwk.model.ProductExample;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void add(Product product) throws WkException {
        int insertProductFlag = productMapper.insert(product);
        if (insertProductFlag != 1) {
            throw new WkException("新增货品记录数不为1");
        }
    }

    @Override
    public List<Product> list(int pageIndex) {
        ProductExample example = new ProductExample();
        example.setLimitByClause(LimitClauseUtils.makeLimitClause((pageIndex - 1) * 10, 10));
        List<Product> productList = productMapper.selectByExample(example);
        return productList;
    }

    /****
     * 修改货品信息
     * 
     * @throws Exception
     */
    @Override
    public void modify(Product product) throws Exception {
        int updateProductFlag = productMapper.updateByPrimaryKeySelective(product);
        if (updateProductFlag != 1) {
            throw new WkException("修改货品记录不为1");
        }
    }

}
