package com.qinweizhao.ware.mapper;

import com.qinweizhao.ware.domain.WmsWareInfo;

import java.util.List;

/**
 * 仓库信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsWareInfoMapper {
    /**
     * 查询仓库信息
     *
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    public WmsWareInfo selectWmsWareInfoById(Long id);

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

    /**
     * 新增仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    public int insertWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 修改仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    public int updateWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 删除仓库信息
     *
     * @param id 仓库信息主键
     * @return 结果
     */
    public int deleteWmsWareInfoById(Long id);

    /**
     * 批量删除仓库信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWareInfoByIds(Long[] ids);
}
