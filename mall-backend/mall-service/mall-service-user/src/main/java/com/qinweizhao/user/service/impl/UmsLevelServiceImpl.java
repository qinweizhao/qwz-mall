package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsLevel;
import com.qinweizhao.user.mapper.UmsLevelMapper;
import com.qinweizhao.user.service.UmsLevelService;
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
public class UmsLevelServiceImpl extends QwzServiceImpl<UmsLevelMapper, UmsLevel> implements UmsLevelService {

    @Resource
    private UmsLevelMapper umsLevelMapper;

    /**
     * 查询会员等级列表
     *
     * @param umsLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<UmsLevel> selectUmsMemberLevelList(UmsLevel umsLevel) {
        return umsLevelMapper.selectUmsMemberLevelList(umsLevel);
    }

}
