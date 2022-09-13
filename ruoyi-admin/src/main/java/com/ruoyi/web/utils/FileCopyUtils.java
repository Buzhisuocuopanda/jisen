package com.ruoyi.web.utils;

import java.io.*;

/**
 * ClassName FileUtils
 * Description
 * Create by gfy
 * Date 2022/9/13 15:43
 */
public class FileCopyUtils {

//    public static  void copyFile(String oldFilePath,String newFilePath) throws IOException {
//        FileInputStream fileInputStream=null;
//        FileOutputStream fileOutputStream =null;
//        try {
//
//
////获取要复制的文件
//
//            File oldfile = new File(oldFilePath);
//
////文件输入流，用于读取要复制的文件
//
//             fileInputStream = new FileInputStream(oldfile);
//
////要生成的新文件(指定路径如果没有则创建)
//
//            File newfile = new File(newFilePath);
//
////获取父目录
//
//            File fileParent = newfile.getParentFile();
//
//            System.out.println(fileParent);
//
////判断是否存在
//
//            if (!fileParent.exists()) {
//
//// 创建父目录文件夹
//
//                fileParent.mkdirs();
//
//            }
//
////判断文件是否存在
//
//            if (!newfile.exists()) {
//
////创建文件
//
//                newfile.createNewFile();
//
//            }
//
////新文件输出流
//
//             fileOutputStream = new FileOutputStream(newfile);
//
//            byte[] buffer = new byte[1024];
//
//            int len;
//
////将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
//
//            while ((len = fileInputStream.read(buffer)) != -1) {
//
//                fileOutputStream.write(buffer, 0, len);
//
//                fileOutputStream.flush();
//
//            }
//
//
//        } finally {
//            if(fileInputStream!=null){
//                fileInputStream.close();
//            }
//
//            if(fileOutputStream!=null){
//                fileOutputStream.close();
//            }
//
//
//        }
//    }

    /**
     * 复制文件
     * @param oldDir 原来的文件
     * @param newDir 复制到的文件
     */
    public static void copyFile(File oldDir, File newDir) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        byte[] b = new byte[1024];
        try {
            // 将要复制文件输入到缓冲输入流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(oldDir));
            // 将复制的文件定义为缓冲输出流
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newDir));
            // 定义字节数
            int len;
            while ((len = bufferedInputStream.read(b)) > -1) {
                // 写入文件
                bufferedOutputStream.write(b, 0, len);
            }
            //刷新此缓冲输出流
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    // 关闭流
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
