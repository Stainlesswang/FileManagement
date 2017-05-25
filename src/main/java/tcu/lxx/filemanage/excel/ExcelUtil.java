package tcu.lxx.filemanage.excel;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import tcu.lxx.filemanage.entity.File;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Boolean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class ExcelUtil {

    /**
     * @param header   包含的属性为表头
     * @param Sheet    工作表的名字
     * @param content  File的集合，显示的多条数据，一条数据代表一个File对象
     * @param response 设置过响应头的response，目的是弹出下载选择路径。
     * @return
     */
    public Boolean exportExcel(File header, String Sheet, List<File> content, HttpServletResponse response) {
        WritableWorkbook wwb;
//        FileOutputStream fos;
        try {

            wwb = Workbook.createWorkbook(response.getOutputStream());

//            fos = new FileOutputStream(fileName);
//            wwb = Workbook.createWorkbook(fos);
            // 创建一个工作表
            WritableSheet ws = wwb.createSheet(Sheet, 10);

            //    设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
                    UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf.setAlignment(Alignment.CENTRE);
            ws.setRowView(1, 500);

            //首先添加表头header
            content.add(0, header);
            // 填充数据的内容，遍历创建表格
            File[] p = new File[content.size()];
            for (int i = 0; i < content.size(); i++) {
                p[i] = (File) content.get(i);
                ws.addCell(new Label(1, i + 1, p[i].getType(), wcf));
                ws.addCell(new Label(2, i + 1, p[i].getJidu(), wcf));
                ws.addCell(new Label(3, i + 1, p[i].getXueyuan(), wcf));
                ws.addCell(new Label(4, i + 1, p[i].getOffice(), wcf));
                ws.addCell(new Label(5, i + 1, p[i].getZhuanye(), wcf));
                ws.addCell(new Label(6, i + 1, p[i].getBanji(), wcf));
                ws.addCell(new Label(7, i + 1, p[i].getCourse(), wcf));
                ws.addCell(new Label(8, i + 1, p[i].getFileCode(), wcf));
                List<String> listCode=new ArrayList<String>();
                listCode=p[i].getFileCodeList();
                for (int a=0;a<listCode.size();a++){
                    ws.addCell(new Label(9+a, i + 1, listCode.get(a), wcf));
                }
                if (i == 0)
                    wcf = new WritableCellFormat();
            }

            wwb.write();

            wwb.close();
//            fos.close();
            System.out.println("--------------->last!!!!!");
        } catch (IOException e) {

            System.out.println("--------------->IOException" + e);
            return false;

        } catch (RowsExceededException e) {

            System.out.println("--------------->ExceededException数据" + e);
            return false;

        } catch (WriteException e) {
            System.out.println("--------------->WriteException数据" + e);
            return false;

        }
        return true;

    }



    //只生成编码的方法
    public Boolean exportExcelOnlyCode(String Sheet, List<File> content, HttpServletResponse response) {
        WritableWorkbook wwb;

        try {

            //创建一个WritableWorkbook别名交wwb,就是创建一个excel表格对象
            wwb = Workbook.createWorkbook(response.getOutputStream());
            // 创建一个工作表WritableSheet 别名ws
            WritableSheet ws = wwb.createSheet(Sheet, 10);

            // 设置单元格的文字格式 对应参数: 字体样式(黑体,宋体什么的),字号大小,WritableFont.BOLD
            //粗体,UnderlineStyle.NO_UNDERLINE 没有下划线,Colour.BLACK 字体颜色为黑色
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 28, WritableFont.BOLD, false,
                    UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
//            每一个cell的样式,把刚才设置好的字体构造注入进去
            WritableCellFormat wcf = new WritableCellFormat(wf);
            //设置每一个cell对齐方式,都是居中
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf.setAlignment(Alignment.CENTRE);
//            设置每一个cell的宽度为82（A4）
            ws.getSettings().setDefaultColumnWidth(82);









            //将File对象里边的FileCodeList取出来装到一个List里边



            //新建一个list集合
            List<String> listCode=new ArrayList<String>();

            //循环遍历把每一个File对象里边的 FileCodeList取出来,增加到新建的listCode集合里边
            File[] f = new File[content.size()];
            for (int i = 0; i < content.size(); i++) {
                f[i] = (File) content.get(i);
               listCode.addAll(f[i].getFileCodeList());
            }

            // 此时的listCode便包含所有我们需要的编码,然后填充数据的内容，遍历创建表格

            for (int i = 0; i < listCode.size(); i++) {
//                工作表添加一个格子就是 addCell
//                new Label(0, i + 1, listCode.get(i), wcf)三个参数分别是:
//                0:代表我们看到的第一列, i+1:代表行号,listCode.get(i):取出当前i对应的listCode编码,wcf:前边设置好的各种样式
                ws.addCell(new Label(0, i + 1, listCode.get(i), wcf));
            }

            //执行创建方法
            wwb.write();













            //关闭wwb流
            wwb.close();
        } catch (IOException e) {

            return false;

        } catch (RowsExceededException e) {

            return false;

        } catch (WriteException e) {
            return false;

        }
        return true;

    }
}
