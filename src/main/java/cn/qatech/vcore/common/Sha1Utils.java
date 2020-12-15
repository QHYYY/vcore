package cn.qatech.vcore.common;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description:判断文件一致性
 * @Author:qihaoyuan
 * @Date:Create：in2020/11/18　17:00
 * @ClassName:ShaUtils
 */
public class Sha1Utils {

    /**
     * 根据路径获取文件哈希值
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static String getHex(String path) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        return DigestUtils.sha1Hex(inputStream);
    }

    /**
     * 比较文件哈希值
     *
     * @param path
     * @param hex
     * @return
     * @throws IOException
     */
    public static Boolean equalHex(String path, String hex) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        String equalHex = DigestUtils.sha1Hex(inputStream);
        return hex.equalsIgnoreCase(equalHex);
    }
}
