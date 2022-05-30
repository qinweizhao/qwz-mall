package com.qinweizhao.ware.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.ware.model.WmsWareInfo;

import java.util.List;

/**
 * 仓库信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsWareInfoMapper extends QwzBaseMapper<WmsWareInfo> {

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);

}
