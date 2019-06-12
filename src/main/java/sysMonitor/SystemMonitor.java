package sysMonitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.StringTokenizer;
import com.sun.management.OperatingSystemMXBean;
import org.apache.commons.lang.StringUtils;


/**
 * 作者：linzp 项目：sims-mid-front-ngt-http 说明：系统监控信息 日期：2017年8月31日 备注：
 */
public class SystemMonitor {

	private static final int CPUTIME = 1000;
	private static final int PERCENT = 100;
	private static String pid = "";

	/**
	 * windows环境下获取JVM的PID
	 */
	private static void getJvmPIDOnWindows() {
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		pid = runtime.getName().split("@")[0];
	}


	/**
	 * 获取windows环境下jvm的内存占用率
	 *
	 * @return
	 */

	public static String getMemoryRateForWindows() {
		if (pid == null || !StringUtils.isNotBlank(pid)) {
			getJvmPIDOnWindows();
		}
		String command = "TASKLIST /NH /FO CSV /FI \"PID EQ " + pid + " \"";
		String remCount = ""; // jvm物理内存占用量
		BufferedReader in = null;
		double result = 0;
		try {
			Process pro = Runtime.getRuntime().exec(command);
			in = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringTokenizer ts = new StringTokenizer(in.readLine(), "\"");
			int i = 1;
			while (ts.hasMoreTokens()) {
				i++;
				ts.nextToken();
				if (i == 9) {
					remCount = ts.nextToken().replace(",", "").replace("K", "").trim();
				}
			}
			double physicalJvmMem = Long.parseLong(remCount) / 1024; // jvm物理内存占用量(MB)
			OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			double physicalTotal = osmxb.getTotalPhysicalMemorySize() / (1024 * 1024); // 获取服务器总物理内存(MB)

			result = physicalJvmMem / physicalTotal * PERCENT;
			BigDecimal bg = new BigDecimal(result);
			result = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

			in.close();
			pro.destroy();

			return String.valueOf(result);
		} catch (Exception e) {
			return "0.0";
		}
	}

	@SuppressWarnings("restriction")
	public static String getCPURateForWindows() {
		try {
			long cpuStartTime = 0l;
			long cpuEndTime = 0l;
			RuntimeMXBean rtMXBean = ManagementFactory.getRuntimeMXBean();
			OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			cpuStartTime = osMXBean.getProcessCpuTime();
			long upTime = rtMXBean.getUptime();
			Thread.sleep(CPUTIME);
			RuntimeMXBean rtMXBean2 = ManagementFactory.getRuntimeMXBean();
			OperatingSystemMXBean osMXBean2 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			cpuEndTime = osMXBean.getProcessCpuTime();

			long upTime2 = rtMXBean2.getUptime();
			double result = (((cpuEndTime - cpuStartTime) / 1000000.0) / (upTime2 - upTime)) * PERCENT;
			BigDecimal bg = new BigDecimal(result);
			result = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

			return String.valueOf(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "0.0";
		}
	}

	/**
	 * 获取运行时长
	 *
	 * @return
	 */
	public static String getRunningTime(long startTime) {
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		long second = (long) (resultTime / 1000);
		long minute = 0;
		long hour = 0;
		int day = 0;

		if (second >= 60) {
			minute = (int) (second / 60);
			second = second % 60;
		}
		if (minute >= 60) {
			hour = (int) minute / 60;
			minute = minute % 60;
		}
		if (hour >= 24) {
			day = (int) hour / 24;
			hour = hour % 24;
		}
		String result = day + "天" + hour + "时" + minute + "分" + second + "秒";
		return result;
	}

}
