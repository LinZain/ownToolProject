package wechat.util;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import wechat.role.WechatReqMsgRole;

public class XmlUtil {
    public static WechatReqMsgRole xmlToMsgRole(String data) {
        WechatReqMsgRole wechatMsgRole = new WechatReqMsgRole();
        Field field = null;
        Element element = null;
        try {
            Document document = DocumentHelper.parseText(data);
            Element root = document.getRootElement();
            Iterator<?> out = root.elementIterator();
            Class<?> c = Class.forName("com.wechat.role.WechatReqMsgRole");
            wechatMsgRole = (WechatReqMsgRole) c.newInstance();
            while (out.hasNext()) {
                element = (Element) out.next();
                field = c.getDeclaredField(element.getName());
                // 获取set方法，field.getType())获取它的参数数据类型
                Method method = c.getDeclaredMethod("set" + element.getName(), field.getType());
                method.invoke(wechatMsgRole, element.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wechatMsgRole;
    }

    @SuppressWarnings("rawtypes")
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对全部xml节点的转换都添加CDATA标记
                boolean cdata = true;
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                    if (name.equals("CreateTime")) {
                        cdata = false;
                    }
                }
                
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    // 将对象转换成微信XML
    public static String msgRoleToXml(Object obg) {
        String replyInfo = "";
        try {
            xstream.alias("xml", obg.getClass());
            replyInfo = xstream.toXML(obg);
        } catch (Exception e) {
            System.out.println("xml转换异常");
            e.getStackTrace();
        }
        System.out.println(replyInfo);
        return replyInfo;
    }
}
