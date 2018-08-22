//package request;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import net.sf.json.JSONObject;
//
//
//public class RequestTest {
//    @Test
//    public void requestTestByPost(){
//        //http://10.5.5.37:8080/pbgo/list.json//http://127.0.0.1:8080/pbgo/list.json
//        String url = "http://127.0.0.1:8080/pbgo/list.json";
//
//        HttpClientUtil util = new HttpClientUtil();
//        util.executeByPOST(url, pbGoQueryRequestJson());
//    }
//
//    public JSONObject pbGoQueryRequestJson(){
//        JSONObject json = new JSONObject();
//        json.put("funcNum", "210100");
//        json.put("operCode", "9999");
//        json.put("operPswd", "888888");
//        json.put("operStation", "0.0.0.0");
//
//        List<String> paramList2 = new ArrayList<String>();
//        paramList2.add("xshg");
//        paramList2.add("600000");
//        json.put("paramList", paramList2);
//        return json;
//    }
//}
