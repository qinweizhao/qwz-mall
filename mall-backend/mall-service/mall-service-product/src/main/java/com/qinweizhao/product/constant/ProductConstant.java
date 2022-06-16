package com.qinweizhao.product.constant;

/**
 * @author weizhao
 */
public class ProductConstant {


    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    public enum SearchEnum {
        Yes(1L, "需要检索"), No(0L, "不需要检索");

        private Long code;
        private String msg;

        SearchEnum(Long code, String msg) {
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
