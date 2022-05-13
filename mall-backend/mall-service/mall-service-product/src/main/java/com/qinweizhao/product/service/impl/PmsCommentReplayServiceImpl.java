package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.model.entity.PmsCommentReplay;
import com.qinweizhao.product.mapper.PmsCommentReplayMapper;
import com.qinweizhao.product.service.IPmsCommentReplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品评价回复关系Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCommentReplayServiceImpl implements IPmsCommentReplayService {
    @Resource
    private PmsCommentReplayMapper pmsCommentReplayMapper;

    /**
     * 查询商品评价回复关系
     *
     * @param id 商品评价回复关系主键
     * @return 商品评价回复关系
     */
    @Override
    public PmsCommentReplay selectPmsCommentReplayById(Long id) {
        return pmsCommentReplayMapper.selectPmsCommentReplayById(id);
    }

    /**
     * 查询商品评价回复关系列表
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 商品评价回复关系
     */
    @Override
    public List<PmsCommentReplay> selectPmsCommentReplayList(PmsCommentReplay pmsCommentReplay) {
        return pmsCommentReplayMapper.selectPmsCommentReplayList(pmsCommentReplay);
    }

    /**
     * 新增商品评价回复关系
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 结果
     */
    @Override
    public int insertPmsCommentReplay(PmsCommentReplay pmsCommentReplay) {
        pmsCommentReplay.setCreateTime(DateUtils.getNowDate());
        return pmsCommentReplayMapper.insertPmsCommentReplay(pmsCommentReplay);
    }

    /**
     * 修改商品评价回复关系
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 结果
     */
    @Override
    public int updatePmsCommentReplay(PmsCommentReplay pmsCommentReplay) {
        pmsCommentReplay.setUpdateTime(DateUtils.getNowDate());
        return pmsCommentReplayMapper.updatePmsCommentReplay(pmsCommentReplay);
    }

    /**
     * 批量删除商品评价回复关系
     *
     * @param ids 需要删除的商品评价回复关系主键
     * @return 结果
     */
    @Override
    public int deletePmsCommentReplayByIds(Long[] ids) {
        return pmsCommentReplayMapper.deletePmsCommentReplayByIds(ids);
    }

    /**
     * 删除商品评价回复关系信息
     *
     * @param id 商品评价回复关系主键
     * @return 结果
     */
    @Override
    public int deletePmsCommentReplayById(Long id) {
        return pmsCommentReplayMapper.deletePmsCommentReplayById(id);
    }
}
