package com.qinweizhao.ware.mapper;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;
import com.qinweizhao.ware.model.entity.WmsWareInfo;
import com.qinweizhao.ware.model.param.WareInfoPageParam;

import java.util.List;

/**
 * 仓库信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsWareInfoMapper extends QwzMapper<WmsWareInfo> {

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息集合
     */
    List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo);


    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    default PageResult<WmsWareInfo> selectPage(WareInfoPageParam pageParam){
        return selectPage(pageParam, new QwzLambdaQueryWrapper<WmsWareInfo>()
                .likeIfPresent(WmsWareInfo::getName, pageParam.getName())
                .orderByDesc(WmsWareInfo::getCreateTime));
    }
}
