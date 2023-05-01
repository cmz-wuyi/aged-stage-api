package cn.age.common.utils.auth;

import cn.hutool.crypto.SecureUtil;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Singer create by Singer email:singer-coder@qq.com
 * @packageName cn.age.common.utils.common
 * @Description: md5工具类
 * @date 2021-01-21
 */
public class Md5Util {

    /**
     * 对字符串进行MD5加密
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     * @param plainText 待加密的字符串
     * @return String
     */
    public static String md5Hex(String plainText) {
        return DigestUtils.md5Hex(plainText);
    }

    /**
     * 对字符串进行MD5加密
     * @author: create by singer - Singer email:singer-coder@qq.com
     * @date 2021/3/30
     * @param plainText 待加密的字符串
     * @return String
     */
    public static String md5(String plainText){
        return SecureUtil.md5(plainText);
    }

}
