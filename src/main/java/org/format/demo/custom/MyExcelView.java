package org.format.demo.custom;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/17 15:06
 * @Description:
 *
 */
public class MyExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        HSSFSheet sheet;//工作簿的名字
        HSSFRow sheetRow;//行
        HSSFCell cell;//单元格

        sheet = workbook.createSheet("spring");
        sheet.setDefaultColumnWidth(12);

        List list = (List) model.get("list");
        for (int i = 0; i < list.size(); i++) {
            //三个参数，第一个为工作簿，第二个为行，第三个为单元格
            cell = getCell(sheet, 0, i);
            setText(cell, (String) list.get(i));
        }
    }
}