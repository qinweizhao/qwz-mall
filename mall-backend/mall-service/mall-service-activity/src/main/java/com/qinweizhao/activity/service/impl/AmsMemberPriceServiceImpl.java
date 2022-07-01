package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsMemberPrice;
import com.qinweizhao.activity.mapper.AmsMemberPriceMapper;
import com.qinweizhao.activity.service.IAmsMemberPriceService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品会员价格Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsMemberPriceServiceImpl implements IAmsMemberPriceService {
    @Resource
    private AmsMemberPriceMapper amsMemberPriceMapper;

    /**
     * 查询商品会员价格
     *
     * @param id 商品会员价格主键
     * @return 商品会员价格
     */
    @Override
    public AmsMemberPrice selectAmsMemberPriceById(Long id) {
        return amsMemberPriceMapper.selectAmsMemberPriceById(id);
    }

    /**
     * 查询商品会员价格列表
     *
     * @param amsMemberPrice 商品会员价格
     * @return 商品会员价格
     */
    @Override
    public List<AmsMemberPrice> selectAmsMemberPriceList(AmsMemberPrice amsMemberPrice) {
        return amsMemberPriceMapper.selectAmsMemberPriceList(amsMemberPrice);
    }

    /**
     * 新增商品会员价格
     *
     * @param amsMemberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int insertAmsMemberPrice(AmsMemberPrice amsMemberPrice) {
        amsMemberPrice.setCreateTime(DateUtils.getNowDate());
        return amsMemberPriceMapper.insertAmsMemberPrice(amsMemberPrice);
    }

    /**
     * 修改商品会员价格
     *
     * @param amsMemberPrice 商品会员价格
     * @return 结果
     */
    @Override
    public int updateAmsMemberPrice(AmsMemberPrice amsMemberPrice) {
        amsMemberPrice.setUpdateTime(DateUtils.getNowDate());
        return amsMemberPriceMapper.updateAmsMemberPrice(amsMemberPrice);
    }

    /**
     * 批量删除商品会员价格
     *
     * @param ids 需要删除的商品会员价格主键
     * @return 结果
     */
    @Override
    public int deleteAmsMemberPriceByIds(Long[] ids) {
        return amsMemberPriceMapper.deleteAmsMemberPriceByIds(ids);
    }

    /**
     * 删除商品会员价格信息
     *
     * @param id 商品会员价格主键
     * @return 结果
     */
    @Override
    public int deleteAmsMemberPriceById(Long id) {
        return amsMemberPriceMapper.deleteAmsMemberPriceById(id);
    }
}
