package com.ant.auto.util;

import com.ant.auto.Consts;

/**
 * 为了不影响代码，控制时间的命名越短越好
 * @author sekift
 *
 */
public class S {
	/**
	 * 第零档
	 */
	public static void s0() {
		SleepUtil.sleepBySecond(Consts.SPEED_ZER_MIN, Consts.SPEED_ZER_MAX);
	}
	
	/**
	 * 第一档
	 */
	public static void s1() {
		SleepUtil.sleepBySecond(Consts.SPEED_ONE_MIN, Consts.SPEED_ONE_MAX);
	}
	
	/**
	 * 第二档
	 */
	public static void s2() {
		SleepUtil.sleepBySecond(Consts.SPEED_TWO_MIN, Consts.SPEED_TWO_MAX);
	}
	
	/**
	 * 第三档
	 */
	public static void s3() {
		SleepUtil.sleepBySecond(Consts.SPEED_THR_MIN, Consts.SPEED_THR_MAX);
	}

}
