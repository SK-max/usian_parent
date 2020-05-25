package com.usian.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.usian.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/24 23:50
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FastFileStorageClient storageClient;

    private static final List<String> contentTypeList = Arrays.asList("image/jpeg", "image/gif", "image/png");

    /**
     * 测试
     */
    @RequestMapping("/upload")
    public Result fileUpload(MultipartFile file) throws IOException {
        System.out.println("哈哈哈哈");
        //获取文件名字
        String filename = file.getOriginalFilename();
        //校验文件类型
        if (!contentTypeList.contains(file.getContentType())) {
            return Result.error("文件类型不合法");
        }
        ;
        //校验文件内容
        BufferedImage read = ImageIO.read(file.getInputStream());
        if (read == null) {
            return Result.error("文件内容不合法");
        }
        //上传文件
        String lastName = StringUtils.substringAfterLast(filename, ".");
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), lastName, null);
        //文件的上传路径存入URL
        System.out.println("http://image.usian.com/" + storePath.getFullPath());
        return Result.ok("http://image.usian.com/" + storePath.getFullPath());
    }

}
