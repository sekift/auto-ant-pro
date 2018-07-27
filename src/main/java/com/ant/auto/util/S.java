package com.ant.auto.util;

import com.ant.auto.Constants;

/**
 * 为了不影响代码，控制时间的命名越短越好
 * @author sekift
 *
 */
public class S {
	/*
	 * 第一档
	 */
	public static void s1() {
		SleepUtil.sleepBySecond(Constants.SPEED_ONE_MIN, Constants.SPEED_ONE_MAX);
	}
	
	/*
	 * 第二档
	 */
	public static void s2() {
		SleepUtil.sleepBySecond(Constants.SPEED_TWO_MIN, Constants.SPEED_TWO_MAX);
	}
	
	/*
	 * 第三档
	 */
	public static void s3() {
		SleepUtil.sleepBySecond(Constants.SPEED_THR_MIN, Constants.SPEED_THR_MAX);
	}

}
