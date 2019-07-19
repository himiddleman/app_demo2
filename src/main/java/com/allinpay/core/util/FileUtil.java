package com.allinpay.core.util;

import com.allinpay.core.constant.enums.BizEnums;
import com.allinpay.core.exception.AllinpayException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
public class FileUtil {
    private FileUtil() {
    }

    /**
     * @Description: 文件上传，重新设置文件名，保证每个文件夹中只有一份机构图片
     * @Param: multipartFile, saveDir
     * @Return: String
     */
    public static String getFileName(MultipartFile multipartFile, String saveDir) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            //未上传文件、上传文件大小为0
            if (StringUtils.isBlank(fileName) ||
                    multipartFile.getSize() == 0) {
                return "";
            }

            File file = new File(saveDir);

            if (file.exists() && FileUtils.sizeOf(file) > 0) {
                FileUtils.deleteDirectory(file);
            }

            file.mkdirs();

            //图片名称重命名
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
            String fullName = UUID.randomUUID().toString().replace("-", "") + fileSuffix;

            multipartFile.transferTo(new File(saveDir + fullName));
            return fullName;
        } catch (Exception e) {
            log.info("文件上传失败！", e);
            throw new AllinpayException(BizEnums.FILE_UPLOAD_EXCEPTION.getCode(), BizEnums.FILE_UPLOAD_EXCEPTION.getMsg());
        }
    }

    /**
     * @Description: 机构编号生成规则:15位机构编号的生成规则 uuid前4 + 分秒7位 + uuid后4
     * @Param:
     * @Return: String
     */
    public static String generatePartnerId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String timeStr = Long.valueOf(System.currentTimeMillis()).toString();
        return (uuid.substring(0, 4) + timeStr.substring(timeStr.length() - 7)
                + uuid.substring(28, 32)).toUpperCase();
    }
}
