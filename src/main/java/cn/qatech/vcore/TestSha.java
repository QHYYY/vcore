package cn.qatech.vcore;

import cn.qatech.vcore.common.Sha1Utils;

import java.io.IOException;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/11/18　11:23
 * @ClassName:TestSha
 */
public class TestSha {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println(Sha1Utils.getHex("D:\\ceshi.zip"));
        System.out.println(System.currentTimeMillis() - start);
    }
}
