package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class createXmlFile {
    public static void main(String[] args) {
        try {
            //createXmlByDom();
            createXmlByDom4j();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public static void createXmlByDom() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    
        Document document = builder.newDocument();
        //创建属性名、赋值      
        Element root = document.createElement("IN");
    
        //创建第一个根节点、赋值  
        Element name = document.createElement("FILE_TYPE");
        name.setTextContent("FILE_TYPE");
        root.appendChild(name);
        
        name = document.createElement("FILE_TYPE2");
        name.setTextContent("FILE_TYPE2");
        root.appendChild(name);
        
        name = document.createElement("FILE_TYPE3");
        name.setTextContent("FILE_TYPE3");
        root.appendChild(name);
        
        name = document.createElement("FILE_TYPE4");
        name.setTextContent("FILE_TYPE4");
        root.appendChild(name);
        
        document.appendChild(root);
    
        //定义了用于处理转换指令，以及执行从源到结果的转换的  
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("encoding", "UTF-8");
    
        String url = "d:\\";
        File file = new File(url + "newxml.xml");
        transformer.transform(new DOMSource(document), new StreamResult(file));
    }*/

    public static void createXmlByDom4j() throws Exception {
        // 创建文档并设置文档的根元素节点   
        Element in = DocumentHelper.createElement("IN");
        //子节点  
        Element inParam = in.addElement("FILE_TYPE");
        inParam.addText("FILE_TYPE");
        inParam = in.addElement("FUND_ID");
        inParam.addText("FUND_ID");
        inParam = in.addElement("REPORT_TYPE");
        inParam.addText("REPORT_TYPE");
        inParam = in.addElement("BEGIN_DATE");
        inParam.addText("BEGIN_DATE");
        inParam = in.addElement("END_DATE");
        inParam.addText("END_DATE");
        inParam = in.addElement("DEPT_CODE");
        inParam.addText("DEPT_CODE");
        inParam = in.addElement("SERIAL_NO");
        inParam.addText("SERIAL_NO");
        
        Element record = in.addElement("Record");
        
        Element recordParam = record.addElement("TIMESTMP");
        recordParam.setText("TIMESTMP");
        recordParam = record.addElement("CASH");
        recordParam.setText("CASH");
        recordParam = record.addElement("OUT_DEPT_ACCN");
        recordParam.setText("OUT_DEPT_ACCN");
        recordParam = record.addElement("OUT_DEPT_ACCT_NAME");
        recordParam.setText("OUT_DEPT_ACCT_NAME");
        recordParam = record.addElement("OUT_ACNT_BANK");
        recordParam.setText("OUT_ACNT_BANK");
        recordParam = record.addElement("IN_DEPT_ACCN");
        recordParam.setText("IN_DEPT_ACCN");
        //添加  
        System.out.println(in.asXML());
    }
}
