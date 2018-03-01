/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.bfwk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfwk.common.WkResponse;
import com.bfwk.dto.TradeOrderDto;
import com.bfwk.model.TradeGoods;
import com.bfwk.model.TradeOrder;
import com.bfwk.service.TradeOrderService;

/**
 * @since 2018年3月1日 上午11:48:31
 * @author hjl
 *
 */
@RestController
@RequestMapping("/tradeOrder")
public class TradeOrderController {
    @Autowired
    private TradeOrderService tradeOrderService;

    @PostMapping("/add")
    public WkResponse<Object> add(TradeOrderDto tradeOrderDto) {
        WkResponse<Object> wr = new WkResponse<Object>();
        try {
            tradeOrderService.add(tradeOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setCode(e.hashCode());
            wr.setMsg(e.getMessage());
        }
        return wr;
    }

    @GetMapping("/delete")
    public WkResponse<Object> delete(Integer[] ids) {
        WkResponse<Object> wr = new WkResponse<Object>();
        try {
            tradeOrderService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setCode(e.hashCode());
            wr.setMsg(e.getMessage());
        }
        return wr;
    }

    @GetMapping("/list")
    public WkResponse<List<TradeOrder>> list(@RequestParam(defaultValue = "1") int pageIndex) {
        WkResponse<List<TradeOrder>> wr = new WkResponse<List<TradeOrder>>();
        try {
            List<TradeOrder> tradeOrderList = tradeOrderService.list(pageIndex);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setCode(e.hashCode());
            wr.setMsg(e.getMessage());
        }
        return wr;
    }

    @GetMapping("/getTradeGoods")
    public WkResponse<List<TradeGoods>> getTradeGoods(Long tradeId) {
        WkResponse<List<TradeGoods>> wr = new WkResponse<List<TradeGoods>>();
        try {
            List<TradeGoods> tradeGoodsList = tradeOrderService.getTradeGoods(tradeId);
            wr.getResult().setData(tradeGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setCode(e.hashCode());
            wr.setMsg(e.getMessage());
        }
        return wr;
    }

    @GetMapping("/detail")
    public WkResponse<TradeOrderDto> detail(Integer id) {
        WkResponse<TradeOrderDto> wr = new WkResponse<TradeOrderDto>();
        try {
            TradeOrderDto tradeOrderDto = tradeOrderService.detail(id);
            wr.getResult().setData(tradeOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setCode(e.hashCode());
            wr.setMsg(e.getMessage());
        }
        return wr;
    }
}
