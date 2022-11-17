package com.qinweizhao.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.pojo.entity.SysOauthClient;
import com.qinweizhao.system.pojo.query.ClientPageQuery;
import com.qinweizhao.system.pojo.vo.client.ClientPageVO;

/**
 * OAuth2客户端接口
 *
 * @author haoxr
 * @date 2022/6/11
 */
public interface SysOauthClientService extends IService<SysOauthClient> {

    /**
     * 客户端分页列表
     *
     * @param queryParams
     * @return
     */
    IPage<ClientPageVO> listClientPages(ClientPageQuery queryParams);


    void cleanCache();
}
