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

	}

	public static char[] hexs = "0123456789abcdef".toCharArray();

	public static void main(String[] args){
		int count = 40;
		for(int i=1;i<=count;i++) {
			String result = hexAdd("ac233f267324", i);
			System.out.println(result.toUpperCase());
		}
	}

	public static String hexAdd(String hex, int num){
		int len = hex.length()-1;
		//是否需要进位
		boolean b = true;
		//参与了运算的位，运算之后的结果字符串，
		//由右向左运算，首先是最后一位参与运算，如果需要进位，那么倒数第二位也要参与运算。以些类推
		String change = "";
		//最终运算结果，由未参与运算的位和参与了运算的位两部分组成
		String result = "";
		while(b && len>=0){
			char c = hex.charAt(len);
			int index = indexOfCharArray(hexs, c);
			if(index == -1){
				return "所传的字符串参数非法！";
			}else{
				int sum = index+num;
				if(sum<16){
					change = hexs[sum]+change;
					result = hex.substring(0, len)+change;
					b = false;
				}else{
					change = hexs[sum%16]+change;
					num = sum/16;
				}
			}
			--len;
		}
		while(b){
			if(num<16){
				change = hexs[num]+change;
				result = change;
				b= false;
			}else{
				change = hexs[num%16]+change;
				num /= 16;
			}
		}

		return result;
	}
	/**
	 * 获取字符在字符数组中的下标
	 * 参数一：字符数组
	 * 参数二：字符
	 * 返回值：字符在字符数组中的下标，如果字符数组中没有该字符，返回-1
	 */
	public static int indexOfCharArray(char[] charArray, char c){
		for(int i=0, len=charArray.length; i<len; ++i){
			if(charArray[i]==c){
				return i;
			}
		}
		return -1;
	}
}
