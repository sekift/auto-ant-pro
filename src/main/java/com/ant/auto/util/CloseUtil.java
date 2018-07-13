package com.ant.auto.util;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.zip.ZipFile;

/**
 * 关闭资源的类
 * 
 * @author:sekift
 * @time:2014-7-14 下午05:10:40
 * @version 1.0.0
 */
public class CloseUtil {

	/**
	 * 关闭Connection资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(Connection rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭Statement资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(Statement rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭ResultSet资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(ResultSet rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭InputStream资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(InputStream rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭OutputStream资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(OutputStream rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭Closeable资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(Closeable rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭ServerSocket资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(ServerSocket rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭Socket资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(Socket rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭DatagramSocket资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(DatagramSocket rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭ZipFile资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(ZipFile rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}

	/**
	 * 关闭Scanner资源对象 备注: 如果资源对象不为null, 关闭资源,不抛出任何异常
	 * 
	 * @param rsc
	 *            -- 资源对象
	 */
	public static void closeSilently(Scanner rsc) {

		if (null != rsc) {
			try {
				rsc.close();
			} catch (Exception ex) { /* 消除异常 */
			}
			rsc = null;
		}
	}
}
