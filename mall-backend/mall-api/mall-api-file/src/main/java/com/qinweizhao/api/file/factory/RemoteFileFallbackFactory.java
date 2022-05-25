package com.qinweizhao.api.file.factory;

import com.qinweizhao.common.core.enums.MallResultCodeEnum;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.api.file.RemoteFileService;
import com.qinweizhao.api.file.domain.SysFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteFileFallbackFactory.class);

    @Override
    public RemoteFileService create(Throwable throwable) {
        log.error("文件服务调用失败:{}", throwable.getMessage());
        return new RemoteFileService() {
            @Override
            public R<SysFile> upload(MultipartFile file) {
                // TODO
//                return R.failure("上传文件失败:" + throwable.getMessage());
                return R.failure();
            }
        };
    }
}
