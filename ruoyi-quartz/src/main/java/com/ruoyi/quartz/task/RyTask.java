package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

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


}
