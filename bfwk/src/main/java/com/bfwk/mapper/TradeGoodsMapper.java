package com.bfwk.mapper;

import com.bfwk.model.TradeGoods;
import com.bfwk.model.TradeGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeGoodsMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    long countByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    int deleteByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    int insert(TradeGoods record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    int insertSelective(TradeGoods record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    List<TradeGoods> selectByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    int updateByExample(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);
}