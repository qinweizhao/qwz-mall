package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.PmsSpuInfo;

import java.util.List;

/**
 * spu信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface PmsSpuInfoMapper {
    /**
     * 查询spu信息
     *
     * @param id spu信息主键
     * @return spu信息
     */
    public PmsSpuInfo selectPmsSpuInfoById(Long id);

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息集合
     */
    public List<PmsSpuInfo> selectPmsSpuInfoList(PmsSpuInfo pmsSpuInfo);

    /**
     * 新增spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    public int insertPmsSpuInfo(PmsSpuInfo pmsSpuInfo);

    /**
     * 修改spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    public int updatePmsSpuInfo(PmsSpuInfo pmsSpuInfo);

    /**
     * 删除spu信息
     *
     * @param id spu信息主键
     * @return 结果
     */
    public int deletePmsSpuInfoById(Long id);

    /**
     * 批量删除spu信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSpuInfoByIds(Long[] ids);
}
