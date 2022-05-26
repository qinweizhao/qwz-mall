package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsMemberLevel;
import com.qinweizhao.user.mapper.UmsMemberLevelMapper;
import com.qinweizhao.user.service.UmsMemberLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员等级Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsUmsMemberLevelServiceImpl extends QwzServiceImpl<UmsMemberLevelMapper, UmsMemberLevel> implements UmsMemberLevelService {

    @Resource
    private UmsMemberLevelMapper umsMemberLevelMapper;

    /**
     * 查询会员等级列表
     *
     * @param umsMemberLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel) {
        return umsMemberLevelMapper.selectUmsMemberLevelList(umsMemberLevel);
    }

}
