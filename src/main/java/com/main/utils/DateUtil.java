package com.main.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {

	// SimpleDateFormat是线程不安全的，采用这种方式避免
	public static ThreadLocal<DateFormat> yyyyMMdd = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	public static ThreadLocal<DateFormat> yyyyMMddLine = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy/MM/dd");
		}
	};

	public static ThreadLocal<DateFormat> YYMMDD = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyMMdd");
		}
	};

	public static ThreadLocal<DateFormat> HHmmss = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("HHmmss");
		}
	};

	public static ThreadLocal<DateFormat> yyyyMMdd10 = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static ThreadLocal<DateFormat> formatter14 = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}
	};

	public static ThreadLocal<DateFormat> formatter18 = new ThreadLocal<DateFormat>() {
		@Override
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
}
