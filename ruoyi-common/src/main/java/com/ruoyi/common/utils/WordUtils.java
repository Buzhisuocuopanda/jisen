package com.ruoyi.common.utils;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName WordUtils
 * Description
 * Create by gfy
 * Date 2022/9/8 18:55
 */
public class WordUtils {
    public static XWPFDocument replaceDoc(String srcPath, Map<String, Object> param) {
        try {
            // 读取word模板
            InputStream fis = new FileInputStream(srcPath);
            XWPFDocument doc = new XWPFDocument(fis);
            //处理段落
            List<XWPFParagraph> paragraphList = doc.getParagraphs();
            processParagraph(paragraphList,doc,param);
            //处理表格
            Iterator<XWPFTable> it = doc.getTablesIterator();
            while (it.hasNext()) {
                XWPFTable table = it.next();
                List<XWPFTableRow> rows = table.getRows();
                for (XWPFTableRow row : rows) {
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();
                        processParagraph(paragraphListTable, doc, param);
                    }
                }
            }
            return doc;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {

        Map<String, Object> map=new HashMap<String, Object>();

//文档里面的列名为${name}和${sex}
        map.put("${name}", "姓名");
        map.put("${112}", "性别");

//文件位置和map
        XWPFDocument doc =replaceDoc("D:\\data\\新建 DOCX 文档 (2)(1).docx", map);

//文件保存位置
        OutputStream os = new FileOutputStream("D:\\data\\ces1.docx");
        doc.write(os);
        os.close();
        System.out.println("输出成功！");
    }


    public static void processParagraph(List<XWPFParagraph> paragraphList, XWPFDocument doc, Map<String, Object> param) {
        if(paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    String runString = run.toString();
                    Matcher m = Pattern.compile("\\$\\{(.*?)}").matcher(runString);
                    if (m.find()) {
                        boolean isSetText = false;
                        for (Map.Entry<String, Object> entry : param.entrySet()) {
                            String key = entry.getKey();
                            if (runString.indexOf(key) != -1) {
                                isSetText = true;
                                Object value = entry.getValue();
                                if (entry.getValue() == null || entry.getValue().equals("")){
                                    value = "未填写";
                                }
                                runString = runString.replace(key, value.toString());
                            }
                        }
                        if (isSetText) {
                            run.setText(runString, 0);
                        }
                    }
                }
            }
        }
    }



}
