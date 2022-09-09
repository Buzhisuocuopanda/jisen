package com.ruoyi.common.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;



/**
 * ClassName PdfUtil
 * Description
 * Create by gfy
 * Date 2022/9/6 18:03
 */
public class PdfUtil {
    /**
     *
     * @param o 写入的数据
     * @param out 自定义保存pdf的文件流
     * @param templatePath pdf模板路径
     */
    // 利用模板生成pdf
    public  void fillTemplate(Map<String,Object> o, OutputStream out, String templatePath) {



        PdfReader reader;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 11, Font.NORMAL);
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            form.addSubstitutionFont(bf);
            while (it.hasNext()) {
                String name = it.next().toString();
                String value = o.get(name)!=null?o.get(name).toString():null;
                form.setField(name,value);
            }


            //start

            AcroFields.FieldPosition fieldPosition=form.getFieldPositions("tableArea").get(0);
            PdfPTable relListTable=new PdfPTable(7);
            //表头
            relListTable.setHeaderRows(1);
            relListTable.setWidthPercentage(500);

            //这里根据字段数量，其Size大小必须与字段数一样，否则会报错
            relListTable.setWidths(new float[]{22,50,55,19,40,22,8});
            relListTable.setSpacingBefore(10);
            relListTable.setLockedWidth(true);
            //下方的数字用来对宽度进行校准，数值越大，表格越窄
//            relListTable.setTotalWidth(PageSize.A4.getWidth()-122);
            relListTable.setTotalWidth(PageSize.A4.getWidth()-16.5f);
            //表头字段
//            String[] headerNames={"ce","ce1","ce2","ce3A","ce","ce","ce"};
//            Arrays.asList(headerNames).forEach(v -> {
//                PdfPCell cell=new PdfPCell(new Paragraph(v,font));
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////                cell.setBackgroundColor(new BaseColor(238,238,238));
//                cell.setFixedHeight(25f);
//                relListTable.addCell(cell);
//            });
            for(int i=0;i<10;i++){
                relListTable.addCell(createCell("内容"+i,font));
                relListTable.addCell(createCell("内容2"+i,font));
                relListTable.addCell(createCell("内容3"+i,font));
                relListTable.addCell(createCell("内容4"+i,font));
                relListTable.addCell(createCell("内容5"+i,font));
                relListTable.addCell(createCell("内容6"+i,font));
                relListTable.addCell(createCell("内容7"+i,font));
            }


            PdfContentByte cb =stamper.getOverContent(1);
            relListTable.writeSelectedRows(0,-1,0,-1,fieldPosition.position.getLeft(),
                    fieldPosition.position.getTop(),cb);
            //end


            //创建第二个表单
            AcroFields.FieldPosition fieldPosition2=form.getFieldPositions("table2").get(0);


            PdfPTable tjtable=new PdfPTable(4);
            //表头
            tjtable.setHeaderRows(1);
            tjtable.setWidthPercentage(500);

            //这里根据字段数量，其Size大小必须与字段数一样，否则会报错
            tjtable.setWidths(new float[]{22,50,55,19});
            tjtable.setSpacingBefore(10);
            tjtable.setLockedWidth(true);
            //下方的数字用来对宽度进行校准，数值越大，表格越窄
//            relListTable.setTotalWidth(PageSize.A4.getWidth()-122);
            tjtable.setTotalWidth(PageSize.A4.getWidth()-16.5f);
            //表头字段
//            String[] headerNames={"ce","ce1","ce2","ce3A","ce","ce","ce"};
//            Arrays.asList(headerNames).forEach(v -> {
//                PdfPCell cell=new PdfPCell(new Paragraph(v,font));
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
////                cell.setBackgroundColor(new BaseColor(238,238,238));
//                cell.setFixedHeight(25f);
//                relListTable.addCell(cell);
//            });
            for(int i=0;i<20;i++){
                tjtable.addCell(createCell("内容"+i,font));
                tjtable.addCell(createCell("内容2"+i,font));
                tjtable.addCell(createCell("内容3"+i,font));
                tjtable.addCell(createCell("内容4"+i,font));

            }
            float bottom = fieldPosition.position.getBottom();
            float left = fieldPosition2.position.getLeft();

//            PdfContentByte cb2 =stamper.getOverContent(1);
            PdfContentByte cb2 =stamper.getUnderContent(1);

            tjtable.writeSelectedRows(0,-1,0,-1,fieldPosition2.position.getLeft(),
                    bottom,cb2);



            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);

            doc.open();








//
//            PdfPTable tableBox = new PdfPTable(3);
//            tableBox.setWidths(new float[] { 0.3f, 0.4f, 0.3f });// 每个单元格占多宽
//            tableBox.setWidthPercentage(80f);
//// 获取ATA分类的结果集
////        List<BaselineATA> ataList = countFileOrDMByATA(baselineData);
//// 创建表格格式及内容
//            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//
//            Font fontChinese = new Font(bfChinese, 10.5F, Font.NORMAL);// 五号
//            tableBox.addCell(getCell(new Phrase("基线按ATA章节分类情况", fontChinese), false, 3, 1));
//            tableBox.addCell(getCell(new Phrase("ATA", fontChinese), false, 1, 1));
//            tableBox.addCell(getCell(new Phrase("文件/图样数量", fontChinese), false, 1, 1));
//            tableBox.addCell(getCell(new Phrase("DM数量", fontChinese), false, 1, 1));
//
//            doc.add(tableBox);
//            Paragraph elements = generatePdfATATable();
//            copy.add(elements);
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PdfPCell createCell(String s, Font font) {
        PdfPCell cell=new PdfPCell(new Paragraph(s,font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setBackgroundColor(new BaseColor(238,238,238));
        cell.setFixedHeight(25f);
        return cell;
    }





    /**
     * 合并原pdf为新文件
     *
     * @param files   pdf绝对路径集
     * @param newfile 新pdf绝对路径
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static void mergePdfFiles(ArrayList<String> files, String newfile) throws Exception {
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        for (String file : files) {
            mergePdf.addSource(file);
        }
        mergePdf.setDestinationFileName(newfile);
        mergePdf.mergeDocuments();
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> files =new ArrayList<>();
        files.add("D:\\data\\Detailszx.pdf");
        files.add("D:\\data\\Detailszx.pdf");
        mergePdfFiles(files,"D:\\data\\12121Detailszx.pdf");
    }


//    public  void fillTemplateWithTable(Map<String,Object> o, ServletOutputStream out, String templatePath) {
//        PdfReader reader;
//        ByteArrayOutputStream bos;
//        PdfStamper stamper;
//        try {
//            BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font FontChinese = new Font(bf, 2, Font.NORMAL);
//            reader = new PdfReader(templatePath);// 读取pdf模板
//            bos = new ByteArrayOutputStream();
//            stamper = new PdfStamper(reader, bos);
//            AcroFields form = stamper.getAcroFields();
//            java.util.Iterator<String> it = form.getFields().keySet().iterator();
//            form.addSubstitutionFont(bf);
//            while (it.hasNext()) {
//                String name = it.next().toString();
//                String value = o.get(name)!=null?o.get(name).toString():null;
//                form.setField(name,value);
//            }
//            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
//            stamper.close();
//            Document doc = new Document();
//            PdfCopy copy = new PdfCopy(doc, out);
//            doc.open();
//
//            Table table=new Table(UnitValue.createPercentArray(tableData.get(0).length)).useAllAvailableWidth();
////            设置表格字体
//            table.setFont(tableFont);
////            设置表格列宽
//            table.setWidth(width);
////            设置表格背景色
////            table.setBackgroundColor(ColorConstants.LIGHT_GRAY);
////            设置表格文本居中对齐
//            table.setTextAlignment(TextAlignment.CENTER);
////            设置表格垂直对齐方式
//            table.setVerticalAlignment(VerticalAlignment.MIDDLE);
////            设置表格水平对齐方式
//            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
////            Cell cell=new Cell();
////            设置单元格背景色为深灰色
////            cell.setBackgroundColor(ColorConstants.DARK_GRAY);
//
//
//            for (String[] row :
//                    tableData) {
////                更精确的颜色可以使用new DeviceRgb（）传入三原色的数值[0-255]来设置
////                new DeviceRgb(13,23,5);
//                for (String cell : row) {
//                    table.addCell(new Paragraph(cell).setFontColor(DeviceRgb.BLACK));
//                }
//            }
//            UnitValue height = table.getHeight();
//            doc.add(table);
//
//
//            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
//            copy.addPage(importPage);
//            doc.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        } catch (DocumentException e) {
//            System.out.println(e);
//        }
//    }
//
//

    /**
     * 生成pdf表格
     * @return
     * @see
     */
    private static Paragraph generatePdfATATable() throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 10.5F, Font.NORMAL);// 五号
        Paragraph ret = new Paragraph("附表1： 基线按ATA章节分类情况统计表", fontChinese);
        PdfPTable tableBox = new PdfPTable(3);
        tableBox.setWidths(new float[] { 0.3f, 0.4f, 0.3f });// 每个单元格占多宽
        tableBox.setWidthPercentage(80f);
// 获取ATA分类的结果集
//        List<BaselineATA> ataList = countFileOrDMByATA(baselineData);
// 创建表格格式及内容
        tableBox.addCell(getCell(new Phrase("基线按ATA章节分类情况", fontChinese), false, 3, 1));
        tableBox.addCell(getCell(new Phrase("ATA", fontChinese), false, 1, 1));
        tableBox.addCell(getCell(new Phrase("文件/图样数量", fontChinese), false, 1, 1));
        tableBox.addCell(getCell(new Phrase("DM数量", fontChinese), false, 1, 1));
// 遍历查询出的结果
//        for (BaselineATA ata : ataList) {
            tableBox.addCell(getCell(new Phrase("测试1", fontChinese), false, 1, 1));
            tableBox.addCell(getCell(new Phrase(String.valueOf("测试2"), fontChinese), false, 1, 1));
            tableBox.addCell(getCell(new Phrase(String.valueOf("测试"), fontChinese), false, 1, 1));
           tableBox.addCell(getCell(new Phrase("测试1", fontChinese), false, 1, 1));
            tableBox.addCell(getCell(new Phrase(String.valueOf("测试2"), fontChinese), false, 1, 1));
            tableBox.addCell(getCell(new Phrase(String.valueOf("测试"), fontChinese), false, 1, 1));
//        }
        ret.add(tableBox);
        return ret;

    }
//每个ｃｅｌｌ的格式，合并单元格情况

    private static PdfPCell getCell(Phrase phrase, boolean yellowFlag, int colSpan, int rowSpan) {
        PdfPCell cells = new PdfPCell(phrase);
        cells.setUseAscender(true);
        cells.setMinimumHeight(20f);
        cells.setHorizontalAlignment(1);
        cells.setVerticalAlignment(5);
        cells.setColspan(colSpan);
        cells.setRowspan(rowSpan);
        cells.setNoWrap(false);
        return cells;
    }


//    public static void createTablePdfFile(String savePath, String fontPath, List<String[]> tableData, String title, int width){
//        try{
//            File pdfFile=new File(savePath);
//            if(!pdfFile.exists()){
//                pdfFile.getParentFile().mkdir();
//            }
//            PdfFont pdfFont= PdfFontFactory.createFont(StandardFonts.HELVETICA);
////            设置中文字体为黑体常规(传入一个字体路径或者itext中内置支持的字体，如上）
////            PdfFont documentFont=PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H,true);
////            使用font-asian中的字体,设置字体华文宋体（STSong-Light）
//            PdfFont tableFont=PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H",true);
//            com.itextpdf.kernel.pdf.PdfDocument pdfDocument=new com.itextpdf.kernel.pdf.PdfDocument(new com.itextpdf.kernel.pdf.PdfWriter(pdfFile));
//            com.itextpdf.layout.Document document=new com.itextpdf.layout.Document(pdfDocument);
////            设置文本居中对齐
//            document.setTextAlignment(TextAlignment.CENTER);
//            document.setHorizontalAlignment(HorizontalAlignment.CENTER);
////            设置文档字体
//            document.setFont(pdfFont);
////            表格标题
//            Paragraph tableTitle=new Paragraph(title);
////            设置表格标题字体和颜色（段落）
//            tableTitle.setFont(pdfFont).setFontColor(DeviceGray.BLACK);
//            document.add(tableTitle);
//            Table table=new Table(UnitValue.createPercentArray(tableData.get(0).length)).useAllAvailableWidth();
////            设置表格字体
//            table.setFont(tableFont);
////            设置表格列宽
//            table.setWidth(width);
////            设置表格背景色
////            table.setBackgroundColor(ColorConstants.LIGHT_GRAY);
////            设置表格文本居中对齐
//            table.setTextAlignment(TextAlignment.CENTER);
////            设置表格垂直对齐方式
//            table.setVerticalAlignment(VerticalAlignment.MIDDLE);
////            设置表格水平对齐方式
//            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
////            Cell cell=new Cell();
////            设置单元格背景色为深灰色
////            cell.setBackgroundColor(ColorConstants.DARK_GRAY);
//
//
//            for (String[] row :
//                    tableData) {
////                更精确的颜色可以使用new DeviceRgb（）传入三原色的数值[0-255]来设置
////                new DeviceRgb(13,23,5);
//                for (String cell : row) {
//                    table.addCell(new Paragraph(cell).setFontColor(DeviceRgb.BLACK));
//                }
//            }
//            UnitValue height = table.getHeight();
//            document.add(table);
//            pdfDocument.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    /**
     * 创建表单文本域
     * @author dongdong
     * @date 2022/4/27
     * @param  llx, float lly, float urx, float ury 前面两个参数代表第一个点的 xy 坐标，后面两个参数代表第二个点的 xy 坐标值
     * @return
     */
    public static void createTextFieldByDefine(String readFile, String saveFile, float llx, float lly, float urx, float ury) throws IOException, DocumentException{
        FileOutputStream out = new FileOutputStream(new File(saveFile));
        PdfReader reader=new PdfReader(new FileInputStream(new File(readFile)));
        PdfStamper pdfStamper=new PdfStamper(reader,out);

        PdfWriter writer = pdfStamper.getWriter();

        float height = reader.getPageSize(reader.getNumberOfPages()).getHeight();
        float width = reader.getPageSize(reader.getNumberOfPages()).getWidth();

        PdfFormField form = PdfFormField.createEmpty(writer);
        //普通文本框
        TextField field = new TextField(writer, new Rectangle(llx, lly, urx, ury), "text");
        field.setOptions(TextField.MULTILINE);
        //防止读取pdf文档时，就是有旋转角度的
        field.setRotation(reader.getPageRotation(1));
        //有些状况下，页数问题能够在这里设置，优先级最高
        field.getTextField().setPlaceInPage(1);
        form.addKid(field.getTextField());
        // file.setOptions(TextField.VISIBLE);//文本域可见(相对于文本域是否高亮)
        // file.setOptions(TextField.HIDDEN);//文本域不可见
        // file.setOptions(TextField.VISIBLE_BUT_DOES_NOT_PRINT);//该字段可见，但不打印。
        // file.setOptions(TextField.HIDDEN_BUT_PRINTABLE);//该字段不可见，但不打印。
        // file.setOptions(TextField.HIDDEN_BUT_PRINTABLE);//该字段不可见，但不打印。
        // file.setOptions(TextField.READ_ONLY);//只读
        // file.setOptions(TextField.REQUIRED);//该字段在经过提交表单操做导出时必须具备值。
        // file.setOptions(TextField.MULTILINE);//规定区域内能够换行显示
        // file.setOptions(TextField.DO_NOT_SCROLL);//文本域不会有滚动条,对于单行字段为水平，对于多行字段为垂直,一旦区域满了，将不会再接受任何文字。
        // file.setOptions(TextField.PASSWORD);//该字段用于输入安全密码，该密码不该该被可视地显示在屏幕上。
        // file.setOptions(TextField.FILE_SELECTION);//我的理解好像是上传文件，不是很理解
        // file.setOptions(TextField.DO_NOT_SPELL_CHECK);//无拼写检查
        // file.setOptions(TextField.EDIT);//若是设置组合框包括一个可编辑的文本框以及一个下拉列表;若是清楚，它只包括一个下拉列表。这个标志只对组合字段有意义。
        // file.setOptions(TextField.MULTISELECT);//无论列表是否能够有多个选择。仅适用于/ ch列表字段，而不适用于组合框。
        // file.setOptions(TextField.COMB);//组合框标志。

        pdfStamper.addAnnotation(form, reader.getNumberOfPages());
        // 设置表单域可被编辑，用来做为后面可以填充的模板
        pdfStamper.setFormFlattening(false);

        pdfStamper.close();
        out.close();
    }

}
