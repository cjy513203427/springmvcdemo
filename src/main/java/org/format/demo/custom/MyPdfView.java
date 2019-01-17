package org.format.demo.custom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/**
 * @Auther: 谷天乐
 * @Date: 2019/1/17 14:22
 * @Description:
 */
public class MyPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        List list = (List) model.get("list");
        for (int i = 0; i < list.size(); i++) {
            //将数据加载到视图上
            document.add(new Paragraph((String)(list.get(i))));
        }
    }
}