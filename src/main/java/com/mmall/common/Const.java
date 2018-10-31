package com.mmall.common;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 * 声明一个常量类
 */
public class Const {
    //静态常量 currentUser当前用户
    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }

    public interface Cart{
        int CHECKED = 1;//被选中
        int UN_CHECKED = 0;//不被选中
        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";//限制数量失败，买200，库存只有100，返回该值，并将买的数量变为100
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";//限制数量成功
    }

    public enum ProductStatusEnum{
        ON_SALE(1,"在线");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    /*
    public enum OrderStatusEnum{
        CANCELED(0,"宸插彇娑?),
                NO_PAY(10,"鏈敮浠?),
                        PAID(20,"宸蹭粯娆?),
                                SHIPPED(40,"宸插彂璐?),
                                        ORDER_SUCCESS(50,"璁㈠崟瀹屾垚"),
                                        ORDER_CLOSE(60,"璁㈠崟鍏抽棴");


        OrderStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("涔堟湁鎵惧埌瀵瑰簲鐨勬灇涓");
        }
    }
    public interface  AlipayCallback{
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }



    public enum PayPlatformEnum{
        ALIPAY(1,"鏀粯瀹?");

                PayPlatformEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
        }

    public enum PaymentTypeEnum{
        ONLINE_PAY(1,"鍦ㄧ嚎鏀粯");

        PaymentTypeEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum : values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("涔堟湁鎵惧埌瀵瑰簲鐨勬灇涓?");
        }

    }*/

}
