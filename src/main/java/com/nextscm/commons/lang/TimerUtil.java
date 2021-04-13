package com.nextscm.commons.lang;

import java.util.Date;

/**
 * A Timer Class that allows measurement of time durations
 */
public class TimerUtil {

	private Date startTime, endTime;

	public TimerUtil() {

	}

	/**
	 * Start the timer
	 */
	public void start() {
		startTime = new Date();
	}

	/**
	 * Stop the timer
	 */
	public void stop() {
		endTime = new Date();
	}

	/**
	 * Get the elapsed time in milliseconds
	 * @return Number of milliseconds elapse
	 */
	public long getDuration() {
		return endTime.getTime() - startTime.getTime();
	}

	/**
	 * Return the elapse time in a formatted String
	 * @return Formatted string representing time elapsed
	 */
	public String getDurationStr() {
		return toStr(getDuration());
	}

	public static String toStr(long milliseconds) {
		long seconds = milliseconds / 1000;
		long ms = milliseconds % 1000;
		return String.format("%d:%02d:%02d:%03d", seconds / 3600, (seconds % 3600) / 60, seconds % 60, ms);
	}
}
