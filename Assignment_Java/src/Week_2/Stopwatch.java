package Week_2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Stopwatch {
	private long elapsedTime;
	private long startTime;
	private long endTime;
	private boolean isRunning;

	public Stopwatch() {
		this.elapsedTime = 0;
		this.startTime = System.currentTimeMillis();
		this.endTime = 0;
		this.isRunning = true;
	}

	public String getStartTime() {
		Date date = new Date(startTime);
		SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:ss");
		return formatDate.format(date);
	}

	public String getEndTime() {
		if (isRunning)
			return "Stop watch is still running. Shut it off first!";
		else {
			Date date = new Date(endTime);
			SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:ss");
			return formatDate.format(date);
		}
	}

	public void start() {
		this.startTime = System.currentTimeMillis();
		this.isRunning = true;
	}

	public void stop() {
		this.endTime = System.currentTimeMillis();
		this.isRunning = false;
	}

	public long getElapsedTime() {
		if (isRunning)
			this.elapsedTime = System.currentTimeMillis() - startTime;
		else
			this.elapsedTime = endTime - startTime;
		return elapsedTime;
	}
}
