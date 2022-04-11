package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.PmsCommentReplay;

import java.util.List;

/**
 * 商品评价回复关系Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsCommentReplayMapper {
    /**
     * 查询商品评价回复关系
     *
     * @param id 商品评价回复关系主键
     * @return 商品评价回复关系
     */
    PmsCommentReplay selectPmsCommentReplayById(Long id);

    /**
     * 查询商品评价回复关系列表
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 商品评价回复关系集合
     */
    List<PmsCommentReplay> selectPmsCommentReplayList(PmsCommentReplay pmsCommentReplay);

    /**
     * 新增商品评价回复关系
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 结果
     */
    int insertPmsCommentReplay(PmsCommentReplay pmsCommentReplay);

    /**
     * 修改商品评价回复关系
     *
     * @param pmsCommentReplay 商品评价回复关系
     * @return 结果
     */
    int updatePmsCommentReplay(PmsCommentReplay pmsCommentReplay);

    /**
     * 删除商品评价回复关系
     *
     * @param id 商品评价回复关系主键
     * @return 结果
     */
    int deletePmsCommentReplayById(Long id);

    /**
     * 批量删除商品评价回复关系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsCommentReplayByIds(Long[] ids);
}
