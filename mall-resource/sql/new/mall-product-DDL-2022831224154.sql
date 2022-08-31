DROP TABLE IF EXISTS pms_attr;
CREATE TABLE pms_attr(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '属性id' ,
    name CHAR(30)    COMMENT '属性名' ,
    type TINYINT(4)    COMMENT '类型;0-销售属性，1-基本属性' ,
    search_type TINYINT(4)    COMMENT '检索类型;0-不需要，1-需要' ,
    sort INT    COMMENT '排序' ,
    status BIGINT(20)    COMMENT '启用状态;0-禁用，1-启用' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '属性';

DROP TABLE IF EXISTS pms_attr_category;
CREATE TABLE pms_attr_category(
    id BIGINT UNSIGNED(21) NOT NULL AUTO_INCREMENT  COMMENT '属性与分类关联id' ,
    category_id BIGINT UNSIGNED(21) NOT NULL   COMMENT '分类id' ,
    attr_id BIGINT(20) NOT NULL   COMMENT '属性id' ,
    create_time DATETIME NOT NULL  DEFAULT 'CURRENT_TIMESTAMP' COMMENT '创建时间' ,
    update_time DATETIME NOT NULL  DEFAULT 'CURRENT_TIMESTAMP' COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '属性&分类';


CREATE UNIQUE INDEX uni_attrgroup_id ON pms_attr_category(category_id,attr_id);
CREATE INDEX idx_attr_id ON pms_attr_category(attr_id);

DROP TABLE IF EXISTS pms_brand;
CREATE TABLE pms_brand(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '品牌id' ,
    name CHAR(50)    COMMENT '品牌名' ,
    logo VARCHAR(2000)    COMMENT '品牌logo地址' ,
    description LONGTEXT    COMMENT '介绍' ,
    status TINYINT(4)    COMMENT '显示状态[0-不显示；1-显示]' ,
    first_letter CHAR(1)    COMMENT '检索首字母' ,
    sort INT(11)    COMMENT '排序' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '品牌';

DROP TABLE IF EXISTS pms_category;
CREATE TABLE pms_category(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '分类id' ,
    name CHAR(50)    COMMENT '分类名称' ,
    parent_id BIGINT(20)    COMMENT '父分类id' ,
    icon VARCHAR(255)    COMMENT '图标' ,
    level INT(11)    COMMENT '层级' ,
    status CHAR(1)    COMMENT '是否显示[0-不显示;1显示]' ,
    sort INT(11)    COMMENT '排序' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '分类';

DROP TABLE IF EXISTS pms_category_brand;
CREATE TABLE pms_category_brand(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '' ,
    brand_id BIGINT(20)    COMMENT '品牌id' ,
    category_id BIGINT(20)    COMMENT '分类id' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '分类&品牌';

DROP TABLE IF EXISTS pms_sku;
CREATE TABLE pms_sku(
    sku_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'skuId' ,
    spu_id BIGINT(20)    COMMENT 'spuId' ,
    name VARCHAR(255)    COMMENT '名称' ,
    img_url VARCHAR(255)    COMMENT '图片' ,
    volume DECIMAL(18,4)    COMMENT '体积' ,
    sale_count BIGINT(20)    COMMENT '销量' ,
    price DECIMAL(18,4)    COMMENT '价格' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (sku_id)
)  COMMENT = 'sku信息';

DROP TABLE IF EXISTS pms_sku_attr_value;
CREATE TABLE pms_sku_attr_value(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    sku_id BIGINT(20)    COMMENT 'sku_id' ,
    attr_id BIGINT(20)    COMMENT 'attr_id' ,
    name VARCHAR(200)    COMMENT '销售属性名' ,
    value VARCHAR(200)    COMMENT '销售属性值' ,
    sort INT(11)    COMMENT '顺序' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = 'sku销售属性';

DROP TABLE IF EXISTS pms_spu;
CREATE TABLE pms_spu(
    spu_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '商品编号' ,
    name VARCHAR(200)    COMMENT '商品名称' ,
    category_id BIGINT(20)    COMMENT '所属分类编号' ,
    brand_id BIGINT(20)    COMMENT '品牌id' ,
    status TINYINT(4)    COMMENT '状态;[0- 新建，1 - 上架，2 - 下架]' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (spu_id)
)  COMMENT = 'spu信息';

DROP TABLE IF EXISTS pms_spu_image;
CREATE TABLE pms_spu_image(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '' ,
    spu_id BIGINT(20) NOT NULL   COMMENT 'spu_id' ,
    name VARCHAR(200)    COMMENT '图片名' ,
    url VARCHAR(255)    COMMENT '图片地址' ,
    sort INT(11)    COMMENT '顺序' ,
    default_image TINYINT(4)    COMMENT '是否默认图' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = 'spu图片';

DROP TABLE IF EXISTS pms_spu_detail;
CREATE TABLE pms_spu_detail(
    spu_id BIGINT(20) NOT NULL   COMMENT '商品id' ,
    detail LONGTEXT    COMMENT '商品介绍' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(255)    COMMENT '备注' ,
    PRIMARY KEY (spu_id)
)  COMMENT = 'spu商品详情';

DROP TABLE IF EXISTS pms_spu_attr_value;
CREATE TABLE pms_spu_attr_value(
    id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    spu_id BIGINT(20)    COMMENT '商品id' ,
    attr_id BIGINT(20)    COMMENT '属性id' ,
    name VARCHAR(200)    COMMENT '属性名' ,
    value VARCHAR(200)    COMMENT '属性值' ,
    sort INT(11)    COMMENT '顺序' ,
    quick_show TINYINT(4)    COMMENT '快速展示【是否展示在介绍上；0-否;1-是】' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = 'spu规格参数';

DROP TABLE IF EXISTS pms_cart_item;
CREATE TABLE pms_cart_item(
    cart_item_id BIGINT UNSIGNED(21) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    shop_id BIGINT(20) NOT NULL   COMMENT '店铺ID' ,
    spu_id BIGINT UNSIGNED(21) NOT NULL  DEFAULT 0 COMMENT '产品ID' ,
    sku_id BIGINT UNSIGNED(21) NOT NULL  DEFAULT 0 COMMENT 'SkuID' ,
    user_id BIGINT UNSIGNED(21) NOT NULL   COMMENT '用户ID' ,
    count INT(11) NOT NULL  DEFAULT 0 COMMENT '购物车产品个数' ,
    price_fee BIGINT UNSIGNED(21) NOT NULL   COMMENT '售价;加入购物车时的商品价格' ,
    checked TINYINT(4)    COMMENT '是否已勾选' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (cart_item_id)
)  COMMENT = '购物车';


CREATE UNIQUE INDEX uk_user_shop_sku ON pms_cart_item(sku_id,user_id,shop_id);
CREATE INDEX idx_shop_id ON pms_cart_item(shop_id);
CREATE INDEX idx_user_id ON pms_cart_item(user_id);

