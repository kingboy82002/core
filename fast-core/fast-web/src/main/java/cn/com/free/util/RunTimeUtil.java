package cn.com.free.util;

/**
 * 计算运行时间工具类
 * @author intel
 *
 */
public class RunTimeUtil {
	/**
	 * 获取当前时间
	 * @return
	 */
	public static long currentTime(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 计算毫秒数
	 * @param timeStart
	 * @return
	 */
	public static long calc(long timeStart){
		return System.currentTimeMillis()-timeStart;
	}
}
