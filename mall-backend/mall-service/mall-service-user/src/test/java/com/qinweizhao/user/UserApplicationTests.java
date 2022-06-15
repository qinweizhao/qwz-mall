package com.qinweizhao.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class UserApplicationTests {

    @Test
    void contextLoads() {

    }


    @Test
    void file() throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "mapper");
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();

        assert files != null;
        int length = files.length;
        System.out.println(length);
        for (File f : files) {
            File canonicalFile = f.getCanonicalFile();
            System.out.println(canonicalFile.getName());
        }
    }

    @Test
    public List<File> getAllFile(File dirFile) {
        // 如果文件夹不存在或着不是文件夹，则返回 null
        if (Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile()) {
            return null;
        }

        File[] childrenFiles = dirFile.listFiles();
        if (Objects.isNull(childrenFiles) || childrenFiles.length == 0) {
            return null;
        }

        List<File> files = new ArrayList<>();
        for (File childFile : childrenFiles) {

            // 如果时文件，直接添加到结果集合
            if (childFile.isFile()) {
                files.add(childFile);
            } else {
                // 如果是文件夹，则将其内部文件添加进结果集合
                List<File> cFiles = getAllFile(childFile);
                if (Objects.isNull(cFiles) || cFiles.isEmpty()) {
                    continue;
                }
                files.addAll(cFiles);
            }

        }
        return files;
    }
}
