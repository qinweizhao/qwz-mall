package com.qinweizhao.file.api;

import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.file.api.domain.SysFile;
import com.qinweizhao.file.api.factory.RemoteFileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface RemoteFileService {

    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R<SysFile> upload(@RequestPart(value = "file") MultipartFile file);
}
