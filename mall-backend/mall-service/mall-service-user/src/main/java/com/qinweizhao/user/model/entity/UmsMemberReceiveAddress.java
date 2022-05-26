package com.qinweizhao.user.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收货地址对象 ums_member_receive_address
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UmsMemberReceiveAddress extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    @Excel(name = "member_id")
    private Long memberId;

    /**
     * 收货人姓名
     */
    @Excel(name = "收货人姓名")
    private String name;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;

    /**
     * 邮政编码
     */
    @Excel(name = "邮政编码")
    private String postCode;

    /**
     * 省份/直辖市
     */
    @Excel(name = "省份/直辖市")
    private String province;

    /**
     * 城市
     */
    @Excel(name = "城市")
    private String city;

    /**
     * 区
     */
    @Excel(name = "区")
    private String region;

    /**
     * 详细地址(街道)
     */
    @Excel(name = "详细地址(街道)")
    private String detailAddress;

    /**
     * 省市区代码
     */
    @Excel(name = "省市区代码")
    private String areaCode;

    /**
     * 是否默认
     */
    @Excel(name = "是否默认")
    private Integer defaultStatus;


}
