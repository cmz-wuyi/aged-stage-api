package cn.age.api;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptUtil {
    public static void main(String[] args) {
        String account="root";
        String password="1111";
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //指定密钥
        encryptor.setPassword("sss1111");


        //加密后的账号
        String newAccount = encryptor.encrypt(account);
        //加密后的密码
        String newPassword = encryptor.encrypt(password);
        System.out.println("加密后："+newAccount+"  "+newPassword);

//        String acc=encryptor.decrypt("ikpwkHFEuDUvcmqJH6kP1w==");
//        String pass=encryptor.decrypt("AUjVYkiSFTQ4jeyONaQE/A==");
//        System.out.println("解密后：" +acc+" "+pass);

    }
}
