/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.bfwk.service;

import java.util.List;

import com.bfwk.dto.TradeOrderDto;
import com.bfwk.model.TradeGoods;
import com.bfwk.model.TradeOrder;

/**
 * @since 2018年3月1日 上午11:32:58
 * @author hjl
 *
 */
public interface TradeOrderService {

    /**
     * @param tradeOrderDto
     */
    void add(TradeOrderDto tradeOrderDto) throws Exception;

    /**
     * @param ids
     */
    void delete(Integer[] ids) throws Exception;

    /**
     * @return
     */
    List<TradeOrder> list(int pageIndex);

    /**
     * @param tradeId
     * @return
     */
    List<TradeGoods> getTradeGoods(Long tradeId);

    /**
     * 订单详情
     * 
     * @param id
     * @return
     */
    TradeOrderDto detail(Integer id);

}
