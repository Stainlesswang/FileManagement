package tcu.lxx.filemanage.excel;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.Format;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import tcu.lxx.filemanage.entity.File;

import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Text;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Boolean;
import java.util.List;
import java.util.Vector;

/**
 * Created by stanwang on 2017/4/19.
 */
public class ExcelUtil {
    public Boolean exportExcel(File header,String Sheet ,List<File> content,HttpServletResponse response) {
        WritableWorkbook wwb;
//        FileOutputStream fos;
        try {

            wwb=Workbook.createWorkbook(response.getOutputStream());

//            fos = new FileOutputStream(fileName);
//            wwb = Workbook.createWorkbook(fos);
            // 创建一个工作表
            WritableSheet ws = wwb.createSheet(Sheet, 10);

            //    设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,
                    UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf.setAlignment(Alignment.CENTRE);
            ws.setRowView(1, 500);

            //首先添加表头header
            content.add(0,header);
            //    填充数据的内容
            File[] p = new File[content.size()];
            for (int i = 0; i < content.size(); i++){
                p[i] = (File)content.get(i);
                ws.addCell(new Label(1, i + 1, p[i].getType(), wcf));
                ws.addCell(new Label(2, i + 1, p[i].getJidu(), wcf));
                ws.addCell(new Label(3, i + 1, p[i].getXueyuan(), wcf));
                ws.addCell(new Label(4, i + 1, p[i].getOffice(), wcf));
                ws.addCell(new Label(5, i + 1, p[i].getZhuanye(), wcf));
                ws.addCell(new Label(6, i + 1, p[i].getBanji(), wcf));
                ws.addCell(new Label(7, i + 1, p[i].getCourse(), wcf));
                if(i == 0)
                    wcf = new WritableCellFormat();
            }

            wwb.write();

            wwb.close();
//            fos.close();
            System.out.println("--------------->last!!!!!");
        } catch (IOException e){

            System.out.println("--------------->IOException"+e);
            return false;

        } catch (RowsExceededException e){

            System.out.println("--------------->ExceededException数据"+e);
            return false;

        } catch (WriteException e){
            System.out.println("--------------->WriteException数据"+e);
            return false;

        }
        return true;

    }
}
