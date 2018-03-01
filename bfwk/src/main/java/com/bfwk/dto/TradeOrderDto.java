/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.bfwk.dto;

import java.util.List;

import com.bfwk.model.TradeGoods;
import com.bfwk.model.TradeOrder;

/**
 * @since 2018年3月1日 上午11:35:24
 * @author hjl
 *
 */
public class TradeOrderDto {
    private TradeOrder tradeOder;
    private List<TradeGoods> tradeGoodsArr;

    public TradeOrder getTradeOder() {
        return tradeOder;
    }

    public void setTradeOder(TradeOrder tradeOder) {
        this.tradeOder = tradeOder;
    }

    public List<TradeGoods> getTradeGoodsArr() {
        return tradeGoodsArr;
    }

    public void setTradeGoodsArr(List<TradeGoods> tradeGoodsArr) {
        this.tradeGoodsArr = tradeGoodsArr;
    }

}
