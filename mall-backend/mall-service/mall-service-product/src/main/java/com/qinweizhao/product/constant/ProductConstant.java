package com.qinweizhao.product.constant;

public class ProductConstant {


    public enum AttrEnum {
        ATTR_TYPE_BASE(1, "基本属性"), ATTR_TYPE_SALE(0, "销售属性");
        private int code;
        private String msg;

        AttrEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum StatusEnum {
        NEW_SPU(0L, "新建"), SPU_UP(1L, "商品上架"), SPU_DOWN(2L, "商品下架");
        private Long code;
        private String msg;

        StatusEnum(Long code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Long getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
