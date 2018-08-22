package json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class JSONStringUtil {
	@Test
	public void PBGORequestJson(){

        WfNodeAttr attr = new WfNodeAttr();
        attr.setAttrId(1l);
        attr.setFieldsetId(1l);

		JSONObject json = JSON.parseObject(attr.toJsonStringExtAttrExp());
		System.out.println(json.toString());
	}
}	
