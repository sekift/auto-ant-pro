package com.ant.auto.util;

/**
 * @author 作者:sekift
 * @version 创建时间：2015-10-25 上午02:17:28
 */
public class SleepUtil {
	/**
	 * 睡眠，时间单位为d,两个数min、max不论顺序
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleepByDay(int min, int max) {
		SleepUtil.sleepBySecond(min * 24 * 60 * 60, max * 24 * 60 * 60);
	}

	/**
	 * 睡眠，时间单位为h,两个数min、max不论顺序
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleepByHour(int min, int max) {
		SleepUtil.sleepBySecond(min * 60 * 60, max * 60 * 60);
	}

	/**
	 * 睡眠，时间单位为m,两个数min、max不论顺序
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleepByMinute(int min, int max) {
		SleepUtil.sleepBySecond(min * 60, max * 60);
	}

	/**
	 * 睡眠，时间单位为s,两个数min、max不论顺序
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleepBySecond(int min, int max) {
		SleepUtil.sleepByMilliSecond(min * 1000, max * 1000);
	}

	/**
	 * 睡眠，时间单位为ms,两个数min、max不论顺序
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleepByMilliSecond(int min, int max) {
		try {
			Thread.sleep(randomInt(min, max));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 产生一个a到b的随机数,int
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int randomInt(double a, double b) {
		return new Double(Math.abs(b - a) * Math.random() + Math.min(a, b))
				.intValue();
	}

}
