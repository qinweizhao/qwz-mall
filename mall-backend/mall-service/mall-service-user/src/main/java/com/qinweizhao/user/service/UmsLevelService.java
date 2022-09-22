package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.entity.UmsLevel;

import java.util.List;

/**
 * 会员等级Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsLevelService extends QwzService<UmsLevel> {

    /**
     * 查询会员等级列表
     *
     * @param umsLevel 会员等级
     * @return 会员等级集合
     */
    List<UmsLevel> selectUmsMemberLevelList(UmsLevel umsLevel);

}
