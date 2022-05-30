package com.qinweizhao.ware.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.ware.model.WmsWareInfo;

import java.util.List;

/**
 * 仓库信息Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsWareInfoService extends QwzService<WmsWareInfo> {

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

}
