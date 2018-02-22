package xml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class readXmlFile {
    public static void main(String[] args) throws DocumentException {
        readXmlDom4j();
    }

    public static void readXmlDom4j() throws DocumentException {
        String ssData = "<out>"+"<BEGIN_DATE>20171121</BEGIN_DATE><REPORT_TYPE>01</REPORT_TYPE><SERIAL_NO>HKZL201711210918</SERIAL_NO><FUND_ID>15008</FUND_ID><FILE_TYPE>1251</FILE_TYPE><END_DATE>20171121</END_DATE><DEPT_CODE>0001</DEPT_CODE><CERT_ID></CERT_ID><PRODNO>A03285</PRODNO><RECORD><CHECKER_CODE>系统用户</CHECKER_CODE><RESULT>1</RESULT><TIMESTMP>20171122 09:47:06046</TIMESTMP><REMARK>该报文的划款日期[20171121]已早于今天[20171122]！请核实</REMARK><SEQ_NO>ZLS15008201711211</SEQ_NO></RECORD>"+"</out>";
        Document doc = DocumentHelper.parseText(ssData);
        //3.获取根节点：  
        Element root = doc.getRootElement();
        System.out.println("根节点: " + root.getName());

        System.out.println("----------------");

        //获取子节点  
        Iterator<?> in = root.elementIterator();
        Element inParam = null;
        while (in.hasNext()) {
            inParam = (Element) in.next();
            System.out.println(inParam.getName() + "  " + inParam.getStringValue());
            if (inParam.getName().equals("Record")) {
                Iterator<?> ite = inParam.elementIterator();
                while (ite.hasNext()) {
                    Element child = (Element) ite.next();
                    System.out.println(child.getName() + "  " + child.getStringValue());
                }
            }

            System.out.println("----------------");
        }
    }

    public static void readXmlDom4j1(Map<String,String> map) throws DocumentException {
        StringBuffer key = new StringBuffer();
        StringBuffer responseMsg = new StringBuffer();
        String split = "\1";
        String url = "D:\\zhaos\\";
        String fileName = "1241_ZLS40100520171019HKZL2016033160007.xml";
        File file = new File(url + fileName);
        Element inParam = null;
        Element recordParam = null;

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element root = document.getRootElement();
        Iterator<?> in = root.elementIterator();
        while (in.hasNext()) {
            inParam = (Element) in.next();
            if (inParam.getName().equals(ZhaoSConstants.FUND_ID)) {
                responseMsg.append("fundId=").append(inParam.getStringValue()).append(split);
                key.append(inParam.getStringValue());
            }
            if (inParam.getName().equals(ZhaoSConstants.BEGIN_DATE)) {
                responseMsg.append("beginDate=").append(inParam.getStringValue()).append(split);
            }
            if (inParam.getName().equals(ZhaoSConstants.END_DATE)) {
                responseMsg.append("endDate=").append(inParam.getStringValue()).append(split);
            }
            if (inParam.getName().equals(ZhaoSConstants.DEPT_CODE)) {
                responseMsg.append("deptCode=").append(inParam.getStringValue()).append(split);
                key.append(inParam.getStringValue());
            }
            if (inParam.getName().equals(ZhaoSConstants.SERIAL_NO)) {
                responseMsg.append("serialNO=").append(inParam.getStringValue()).append(split);
                key.append(inParam.getStringValue());
            }
            if (inParam.getName().equals("Record")) {
                Iterator<?> record = inParam.elementIterator();
                while (record.hasNext()) {
                    recordParam = (Element) record.next();
                    if (recordParam.getName().equals(ZhaoSConstants.TIMESTMP)) {
                        responseMsg.append("timestmp=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.CASH)) {
                        responseMsg.append("cash=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.OUT_DEPT_ACCN)) {
                        responseMsg.append("outDeptAccn=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.OUT_DEPT_ACCT_NAME)) {
                        responseMsg.append("outDeptAcctName=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.OUT_ACNT_BANK)) {
                        responseMsg.append("outAcntBank=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.IN_DEPT_ACCN)) {
                        responseMsg.append("inDeptAccn=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.IN_DEPT_ACCT_NAME)) {
                        responseMsg.append("inDeptAcctName=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.IN_ACNT_BANK)) {
                        responseMsg.append("inAcntBank=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.TRADE_DATE)) {
                        responseMsg.append("tradeDate=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.REMARK)) {
                        responseMsg.append("remark=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.VOUCHER_DESC)) {
                        responseMsg.append("voucherDesc=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.OPERATION_TYPE)) {
                        responseMsg.append("operationType=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.INCOR_CODE)) {
                        responseMsg.append("incorCode=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.OUT_ACNT_CUR)) {
                        responseMsg.append("outAcntCur=").append(recordParam.getStringValue()).append(split);
                    }
                    if (recordParam.getName().equals(ZhaoSConstants.IN_ACNT_CUR)) {
                        responseMsg.append("inAcntCur=").append(recordParam.getStringValue());
                    }
                }
            }
        }
        System.out.println(responseMsg.toString());
        paramValues(responseMsg.toString());
        map.put(key.toString(), responseMsg.toString());
    }
    public static void paramValues(String body){
        Map<String, String> map = new HashMap<>();
        String[] subStr = body.split("\1");
        for (String sub : subStr) {
            String[] split = sub.split("=");
            if (split[0].isEmpty()) {
                continue;
            }
            if (split.length == 1) {
                map.put(split[0].trim(), "");
            } else {
                map.put(split[0].trim(), split[1].trim());
            }
        }
        System.out.println(map.toString());
    }
}
