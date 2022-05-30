package com.qinweizhao.ware.service.impl;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.ware.mapper.WmsWareInfoMapper;
import com.qinweizhao.ware.model.entity.WmsWareInfo;
import com.qinweizhao.ware.model.param.WareInfoPageParam;
import com.qinweizhao.ware.service.IWmsWareInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仓库信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsWareInfoServiceImpl extends QwzServiceImpl<WmsWareInfoMapper, WmsWareInfo> implements IWmsWareInfoService {

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo) {
        return this.baseMapper.selectWmsWareInfoList(wmsWareInfo);
    }

    @Override
    public PageResult<WmsWareInfo> page(WareInfoPageParam pageParam) {
        return  this.baseMapper.selectPage(pageParam);
    }

}
