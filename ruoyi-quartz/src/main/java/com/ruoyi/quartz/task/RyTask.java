package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

/**
 * 定时任务调度测试
 *
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }

    public void deleteBYMenuFile()
    {
//        String cmd ="rm -f /data/ruoyidata/";
//        try{
//            Process process = Runtime.getRuntime().exec(cmd);
//            System.out.println("执行删除Linux目录下文件");
//            process.waitFor();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("删除失败");
//        }

        try{
            File index = new File("D:\\ruoyi\\uploadPath\\data");
            File[] files = index.listFiles();
            for (File file : files) {
//                if (file.isDirectory())
//                    delFile(file);
                file.delete();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }
    //删除文件及文件夹方法
    public static void delFile(File index){
        if (index.isDirectory()){
            File[] files = index.listFiles();
            for (File in: files) {
                delFile(in);
            }
        }
        index.delete();
        //出现几次删除成功代表有几个文件和文本文件
        System.out.println("删除成功");
    }



    public void deleteBYMenuFiles(){
        String basePath = "D:\\ruoyi\\uploadPath";
        File dir = new File(basePath);

        List<File> allFileList = new ArrayList<>();

        // 判断文件夹是否存在
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        getAllFile(dir, allFileList);

        for (File file : allFileList) {
            String name = file.getName();
            if (name.length() >28){
                if(file.getName().equals(name)){
                    file.delete();
                    System.out.println("删除文件"+file.getName());
                }
            }
            //  System.out.println(file.getName());
        }


    }
/*
    public static void main(String[] args) {

        String basePath = "D:\\work\\test";
        File dir = new File(basePath);

        List<File> allFileList = new ArrayList<>();

        // 判断文件夹是否存在
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        getAllFile(dir, allFileList);

        for (File file : allFileList) {
            String name = file.getName();
            if (name.length() >28){
                if(file.getName().equals(name)){
                    file.delete();
                    System.out.println("删除文件"+file.getName());
                }
            }
          //  System.out.println(file.getName());
        }

        System.out.println("该文件夹下共有" + allFileList.size() + "个文件");
    }
*/


    public static void getAllFile(File fileInput, List<File> allFileList) {
        // 获取文件列表
        File[] fileList = fileInput.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            if (file.isDirectory()) {
                // 递归处理文件夹
                // 如果不想统计子文件夹则可以将下一行注释掉
                getAllFile(file, allFileList);
            } else {
                // 如果是文件则将其加入到文件数组中
                allFileList.add(file);
            }
        }
    }


}
