package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.UmsMemberLevel;
import com.qinweizhao.product.mapper.UmsMemberLevelMapper;
import com.qinweizhao.product.service.IUmsMemberLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员等级Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsMemberLevelServiceImpl implements IUmsMemberLevelService {
    @Resource
    private UmsMemberLevelMapper umsMemberLevelMapper;

    /**
     * 查询会员等级
     *
     * @param id 会员等级主键
     * @return 会员等级
     */
    @Override
    public UmsMemberLevel selectUmsMemberLevelById(Long id) {
        return umsMemberLevelMapper.selectUmsMemberLevelById(id);
    }

    /**
     * 查询会员等级列表
     *
     * @param umsMemberLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel) {
        return umsMemberLevelMapper.selectUmsMemberLevelList(umsMemberLevel);
    }

    /**
     * 新增会员等级
     *
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    @Override
    public int insertUmsMemberLevel(UmsMemberLevel umsMemberLevel) {
        return umsMemberLevelMapper.insertUmsMemberLevel(umsMemberLevel);
    }

    /**
     * 修改会员等级
     *
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    @Override
    public int updateUmsMemberLevel(UmsMemberLevel umsMemberLevel) {
        return umsMemberLevelMapper.updateUmsMemberLevel(umsMemberLevel);
    }

    /**
     * 批量删除会员等级
     *
     * @param ids 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLevelByIds(Long[] ids) {
        return umsMemberLevelMapper.deleteUmsMemberLevelByIds(ids);
    }

    /**
     * 删除会员等级信息
     *
     * @param id 会员等级主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberLevelById(Long id) {
        return umsMemberLevelMapper.deleteUmsMemberLevelById(id);
    }
}
