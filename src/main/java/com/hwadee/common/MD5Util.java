package com.hwadee.common;

import java.security.MessageDigest;

/**
 * 对密钥加密加盐的工具栏
 */
public class MD5Util {

    /**
     * 通用默认盐值
     */
    public static final String DEFAULT_SALT = "hwadee";

    /**
     * 数据和盐值进行拼接
     * @param data
     * @param salt
     * @return
     */
    private static String mergeDataAndSalt(String data, Object salt){
        if(data == null){
            return "";
        }
        if(salt == null || salt.equals("")){
            return data;
        }
        return data + "{" + salt +" }";
    }

    /**
     * 将给定的数据转换为16进制
     * @param resultBytes
     * @return
     */
    private static String fromBytesToHex(byte[] resultBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte resultByte : resultBytes) {
            if (Integer.toHexString(0XFF & resultByte).length() == 1) {
                stringBuilder.append("0").append(Integer.toHexString(0XFF & resultByte));
            } else {
                stringBuilder.append(Integer.toHexString(0XFF & resultByte));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 对数据进行MD5算法的摘要计算，并加入盐值
     * @param data 原始数据
     * @param salt 加入的盐值
     * @return
     */
    public static String encryptMD5AndSalt(String data, Object salt){
        try{
            // 把data和盐拼接
            String dataSalt = mergeDataAndSalt(data, salt);
            // 获取MD5加密器
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 加入要获取摘要的数据
            md5.update(dataSalt.getBytes());
            // 得到数据的信息摘要
            byte[] digest = md5.digest();
            // 将字节数据转化为16进制
            return fromBytesToHex(digest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//    /**
//     * 测试转换进制函数
//     */
////        byte[] a = {1,2,3,10, 11, 15,16,20,55};
////        String s = fromBytesToHex(a);
////        System.out.println(s);
//        /**
//         * 测试加盐算法
//         */
//        String hwadee = encryptMD5AndSalt("123456", "hwadee");
//        System.out.println(hwadee);
//     }
}
