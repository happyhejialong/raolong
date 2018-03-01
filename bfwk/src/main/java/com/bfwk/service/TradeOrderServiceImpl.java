/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.bfwk.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfwk.common.utils.CollectionUtils;
import com.bfwk.common.utils.LimitClauseUtils;
import com.bfwk.controller.WebSocketController;
import com.bfwk.dto.TradeOrderDto;
import com.bfwk.exception.WkException;
import com.bfwk.mapper.TradeGoodsMapper;
import com.bfwk.mapper.TradeOrderMapper;
import com.bfwk.model.TradeGoods;
import com.bfwk.model.TradeGoodsExample;
import com.bfwk.model.TradeOrder;
import com.bfwk.model.TradeOrderExample;

/**
 * @since 2018年3月1日 上午11:33:11
 * @author hjl
 *
 */
@Service
public class TradeOrderServiceImpl implements TradeOrderService {
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Autowired
    private TradeGoodsMapper tradeGoodsMapper;

    /****
     * 用户下单
     * 
     * @throws Exception
     * 
     */
    @Override
    public void add(TradeOrderDto tradeOrderDto) throws Exception {
        TradeOrder tradeOrder = tradeOrderDto.getTradeOder();
        tradeOrder.setTradeId(System.currentTimeMillis());
        insertTradeOrder(tradeOrder);
        List<TradeGoods> tradeGoodsArr = tradeOrderDto.getTradeGoodsArr();
        for (TradeGoods tradeGoods : tradeGoodsArr) {
            tradeGoods.setTradeId(tradeOrder.getTradeId());
        }
        insertTradeGoodsArr(tradeGoodsArr);
        new WebSocketController().sendMessage("您有新的网吧订单请即时查看");
    }

    /***
     * 插入主订单信息
     * 
     * @throws WkException
     */
    public void insertTradeOrder(TradeOrder tradeOrder) throws Exception {
        int insertTradeOrderFlag = tradeOrderMapper.insert(tradeOrder);
        if (insertTradeOrderFlag != 1) {
            throw new WkException("新增主订单信息不为1");
        }
    }

    /****
     * 插入子订单信息
     * 
     * @throws WkException
     */
    public void insertTradeGoodsArr(List<TradeGoods> tradeGoodsArr) throws Exception {

        for (int i = 0; i < tradeGoodsArr.size(); i++) {
            int insertTradeGoodsArrFlag = tradeGoodsMapper.insert(tradeGoodsArr.get(i));
            if (insertTradeGoodsArrFlag != 1) {
                throw new WkException("新增订单货品失败");
            }
        }
    }

    /****
     * 删除订单
     * 
     * @throws Exception
     */
    @Override
    public void delete(Integer[] ids) throws Exception {
        deleteTradeOrder(ids);
        for (int i = 0; i < ids.length; i++) {
            TradeOrder tradeOrder = findTradeOrderById(ids[i]);
            deleteTradeGoodsByTradeId(tradeOrder.getTradeId());
        }
    }

    /****
     * 查询主订单信息
     */
    public TradeOrder findTradeOrderById(Integer id) {
        TradeOrderExample tradeOrderExample = new TradeOrderExample();
        tradeOrderExample.createCriteria().andIdEqualTo(id);
        TradeOrder tradeOrder = CollectionUtils.getFirst(tradeOrderMapper.selectByExample(tradeOrderExample));
        return tradeOrder;
    }

    /****
     * 删除主订单
     * 
     * @throws Exception
     */
    public void deleteTradeOrder(Integer[] ids) throws Exception {
        TradeOrderExample example = new TradeOrderExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        int deleteTradeOrderFlag = tradeOrderMapper.deleteByExample(example);
        if (deleteTradeOrderFlag != ids.length) {
            throw new WkException("删除记录与实际需要删除的记录条数不符合");
        }
    }

    /****
     * 删除子订单
     * 
     */
    public void deleteTradeGoodsByTradeId(Long tradeId) throws Exception {
        TradeGoodsExample example = new TradeGoodsExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        int deleteTradeGoodsFlag = tradeGoodsMapper.deleteByExample(example);
        if (deleteTradeGoodsFlag != 1) {
            throw new WkException("删除记录与实际需要删除的记录条数不符合");
        }
    }

    /****
     * 订单列表
     */
    @Override
    public List<TradeOrder> list(int pageIndex) {
        TradeOrderExample example = new TradeOrderExample();
        example.setLimitByClause(LimitClauseUtils.makeLimitClause(pageIndex, 10));
        return tradeOrderMapper.selectByExample(example);
    }

    /***
     * 查询订单子订单信息
     */
    @Override
    public List<TradeGoods> getTradeGoods(Long tradeId) {
        TradeGoodsExample example = new TradeGoodsExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);
        return tradeGoodsMapper.selectByExample(example);
    }

    /***
     * 查询订单详情
     */
    @Override
    public TradeOrderDto detail(Integer id) {
        TradeOrderDto tradeOrderDto = new TradeOrderDto();
        tradeOrderDto.setTradeOder(findTradeOrderById(id));
        tradeOrderDto.setTradeGoodsArr(getTradeGoods(tradeOrderDto.getTradeOder().getTradeId()));
        return tradeOrderDto;
    }
}
