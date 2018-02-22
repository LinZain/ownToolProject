package json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONObject;

public class JSONStringUtil {
	@Test
	public void PBGORequestJson(){
        JSONObject json = new JSONObject();
		json.put("funcNum", "210001");
		json.put("operCode", "1");
		json.put("operPswd", "123456");
		json.put("operStation", "0.0.0.0");
		
		List<String> paramList2 = new ArrayList<String>();
		paramList2.add("xshg");
		paramList2.add("600001");
		json.put("paramList", paramList2);
		System.out.println(json.toString());
	}
}	
