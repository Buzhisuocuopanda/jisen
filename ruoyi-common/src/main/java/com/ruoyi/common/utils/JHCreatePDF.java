package com.ruoyi.common.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;






import java.io.*;

/**
 * ClassName JHCreatePDF
 * Description
 * Create by gfy
 * Date 2022/9/6 16:30
 */
@Slf4j

public class JHCreatePDF {

    // 日志记录对象

    // 系统字体文件在 Windows/Fonts目录下,将其粘到src下即可
    public static final String CHARACTOR_FONT_CH_FILE = "/SIMSUN.TTC,1";  //宋体 常规
    // 纸张尺寸
    public static final Rectangle PAGE_SIZE = PageSize.A4;
    // 边距
    public static final float MARGIN_LEFT = 50;
    public static final float MARGIN_RIGHT = 50;
    public static final float MARGIN_TOP = 50;
    public static final float MARGIN_BOTTOM = 50;
    public static final float SPACING = 20;
    // 文件对象
    private Document document = null;
    private File file;
    /**
     * 功能：创建导出数据的目标文档
     * @return
     */
    public void createDocument() {
        // 创建pdf文件
        FileOutputStream out = null;
        document = new Document(PAGE_SIZE, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM);
        try {
            file = File.createTempFile("temp", ".pdf");
        } catch (IOException e1) {
            log.error("创建临时打印文件失败!");
//            PromptUtil.error("创建临时打印文件失败,请关闭重试");
            e1.printStackTrace();
            return; // 结束后续运行
        }
        try {
            out = new FileOutputStream(file);
            PdfWriter.getInstance(document, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 打开文档准备写入内容
        document.open();
    }
    /**
     * 功能  创建PDF文档中的章节
     * @param title 章节标题
     * @param chapterNum 章节序列号
     * @param alignment 0表示align=left，1表示align=center
     * @param numberDepth 章节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
     * @param font 字体格式
     * @return Chapter章节
     */
    public static Chapter createChapter(String title, int chapterNum, int alignment, int numberDepth, Font font) {
        Paragraph chapterTitle = new Paragraph(title, font);
        chapterTitle.setAlignment(alignment);
        Chapter chapter = new Chapter(chapterTitle, chapterNum);
        chapter.setNumberDepth(numberDepth);
        return chapter;
    }
    /**
     * 功能：创建某指定章节下的小节
     * @param chapter 指定章节
     * @param title 小节标题
     * @param font 字体格式
     * @param numberDepth 小节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
     * @return section在指定章节后追加小节
     */
    public static Section createSection(Chapter chapter, String title, Font font, int numberDepth) {
        Section section = null;
        if(chapter != null) {
            Paragraph sectionTitle = new Paragraph(title, font);
            sectionTitle.setSpacingBefore(SPACING);
            section = chapter.addSection(sectionTitle);
            section.setNumberDepth(numberDepth);
        }
        return section;
    }
    /**
     * 功能：向PDF文档添加chunk
     *
     * @param text
     * @param font
     * @return
     */
    public static Chunk createChunk(String text, Font font) {
        return new Chunk(text, font);
    }
    /**
     * 功能：向PDF文档中添加的内容 (核心句子)
     * @param text 内容
     * @param font 内容对应的字体
     * @return phrase 指定字体格式的内容
     */
    public static Phrase createPhrase(String text, Font font) {
        Phrase phrase = new Paragraph(text,font);
        return phrase;
    }
    /**
     * 最后关闭PDF文档
     */
    public void closeDocument() {
        if(document != null) {
            document.close();
        }
    }
    /**
     * 读PDF文件，使用了pdfbox开源项目
     * @param fileName
     */
    public void readPDF(String fileName) {
        File file = new File(fileName);
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            // 新建一个PDF解析器对象
            PDFParser parser = new PDFParser((RandomAccessRead) in);
            // 对PDF文件进行解析
            parser.parse();
            // 获取解析后得到的PDF文档对象
            PDDocument pdfdocument = parser.getPDDocument();
            // 新建一个PDF文本剥离器
            PDFTextStripper stripper = new PDFTextStripper();
            // 从PDF文档对象中剥离文本
            String result = stripper.getText(pdfdocument);
            System.out.println("PDF文件的文本内容如下：");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("读取PDF文件" + file.getAbsolutePath() + "生失败！" + e);
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    /**
     * 获取临时文件
     *
     * @return
     */
    public File getTempFile() {
        if(file == null);
        log.error("生成的临时文件失败");
        return file;
    }

}
