package com.qinweizhao.ware.service;

import com.qinweizhao.ware.domain.WmsWareInfo;

import java.util.List;

/**
 * 仓库信息Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsWareInfoService {
    /**
     * 查询仓库信息
     *
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    WmsWareInfo selectWmsWareInfoById(Long id);

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

    /**
     * 新增仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    int insertWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 修改仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    int updateWmsWareInfo(WmsWareInfo wmsWareInfo);

    /**
     * 批量删除仓库信息
     *
     * @param ids 需要删除的仓库信息主键集合
     * @return 结果
     */
    int deleteWmsWareInfoByIds(Long[] ids);

    /**
     * 删除仓库信息信息
     *
     * @param id 仓库信息主键
     * @return 结果
     */
    int deleteWmsWareInfoById(Long id);
}
