package com.bfwk.model;

public class TradeGoods {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.product_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private Long productId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.product_name
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private String productName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.buy_num
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private Integer buyNum;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.trade_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private Long tradeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column trade_goods.price
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    private Double price;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.id
     * @return  the value of trade_goods.id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.id
     * @param id  the value for trade_goods.id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.product_id
     * @return  the value of trade_goods.product_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.product_id
     * @param productId  the value for trade_goods.product_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.product_name
     * @return  the value of trade_goods.product_name
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.product_name
     * @param productName  the value for trade_goods.product_name
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.buy_num
     * @return  the value of trade_goods.buy_num
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.buy_num
     * @param buyNum  the value for trade_goods.buy_num
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.trade_id
     * @return  the value of trade_goods.trade_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public Long getTradeId() {
        return tradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.trade_id
     * @param tradeId  the value for trade_goods.trade_id
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column trade_goods.price
     * @return  the value of trade_goods.price
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column trade_goods.price
     * @param price  the value for trade_goods.price
     * @mbg.generated  Thu Mar 01 12:35:06 CST 2018
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}