package com.ruoyi.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import org.slf4j.Logger;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

/**
 * ClassName JHPrintor
 * Description
 * Create by gfy
 * Date 2022/9/6 15:59
 */
@Slf4j
public class JHPrintor {

    /** 日志记录对象 */

    /** 私有构造器 */
    private JHPrintor() {
    }
    /**
     * 打印pdf文件
     *
     * @param file 需打印的pdf文件
     */
    public static void print(File file) {
        try {
            PDDocument document = PDDocument.load(file);
            // 加载成打印文件
            PDFPrintable printable = new PDFPrintable(document, Scaling.ACTUAL_SIZE);
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(printable);
            job.defaultPage();
            job.print();
        } catch (InvalidPasswordException e) {
            log.error("打印异常：文档初始化密码失败!");

            e.printStackTrace();
        } catch (IOException e) {
            log.error("打印异常！");

            e.printStackTrace();
        } catch (PrinterException e) {
            log.error("未正常连接打印机");

            e.printStackTrace();
        }
    }
}
