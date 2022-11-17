package com.qinweizhao.system.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qinweizhao.system.pojo.vo.user.LoginUserVO;
import com.qinweizhao.system.pojo.result.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户接口降级逻辑
 *
 * @author haoxr
 * @createTime 2021/4/23 23:30
 */
@Slf4j
public class UserBlockHandler {

    /**
     * 获取当前登录用户信息的熔断降级处理
     *
     * @param blockException
     * @return
     */
    public static Result<LoginUserVO> handleGetCurrentUserBlock(BlockException blockException) {
        return Result.success(new LoginUserVO());
    }


    public static Result handleGetUserByUsernameBlock(String username, BlockException blockException) {
        log.info("降级了：{}", username);
        return Result.failed("降级了");
    }
}
