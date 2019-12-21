package com.w.attendance;


import java.net.URL;
import java.net.URLDecoder;

/**
 * MP 工具类
 *
 * @author chenwenjie
 * @since 2019-3-11 11:18
 */
public class MybatisUtils {

    private MybatisUtils() {
    }

    /**
     * 获取当前类的类路径
     */
    public static String generatorPath(boolean isLinux, Class utilClass) {
        int index = isLinux ? 0 : 1;
        try {
            URL url = utilClass.getProtectionDomain().getCodeSource().getLocation();
            String filePath = URLDecoder.decode(url.getPath(), "utf-8");
            filePath = filePath.substring(index, filePath.length() - "/target/classes/".length());

            return filePath + "/src/main/java/";
        } catch (Exception e) {
        }
        return null;
    }
}
