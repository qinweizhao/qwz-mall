package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.user.model.entity.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberLevelMapper extends QwzMapper<UmsMemberLevel> {

    /**
     * 查询会员等级列表
     *
     * @param umsMemberLevel 会员等级
     * @return 会员等级集合
     */
    List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel);


}
