package com.mall4j.cloud.common.database.config;

/**
 * @author FrozenWatermelon
 * @date 2020/11/27
 */
//@Component
//@ConditionalOnClass({RequestInterceptor.class, GlobalTransactional.class})
//public class SeataRequestInterceptor implements RequestInterceptor {
//
//    private static final Logger logger = LoggerFactory.getLogger(SeataRequestInterceptor.class);
//
//    @Override
//    public void apply(RequestTemplate template) {
//        String currentXid = RootContext.getXID();
//        if (StrUtil.isNotBlank(currentXid) && !template.url().startsWith(Auth.CHECK_TOKEN_URI) && !template.url().startsWith(Auth.CHECK_RBAC_URI)) {
//            template.header(RootContext.KEY_XID, currentXid);
//        }
//    }
//}
