/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Asker:How to sort list of objects by some property
 * </p>
 * <p>
 * Answer:Collections.sort(list) or Collections.sort(list,compartor);<br/>
 * In general, it's a good idea to implement Comparable<T> if there's a single "natural" sort order... otherwise (if you happen to want to sort in a particular order, but might equally easily want a different one) it's better to implement Comparator<T>. 
 * </p>
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年4月24日 上午9:11:12
 * </p>
 * 
 * @author gsu·napoleon
 */
public class AboutSortListOfObjectBySomeProperty {
	
	public static void main(String[] args) {
		List<ActiveAlarm> list = new ArrayList<ActiveAlarm>();
		list.add(new ActiveAlarm(5L, 5L, "Jon", "Skeet", "Sort"));
		list.add(new ActiveAlarm(3L, 5L, "Jon", "Skeet", "Sort"));
		list.add(new ActiveAlarm(4L, 5L, "Jon", "Skeet", "Sort"));
		list.add(new ActiveAlarm(2L, 5L, "Jon", "Skeet", "Sort"));
		list.add(new ActiveAlarm(1L, 5L, "Jon", "Skeet", "Sort"));
		Collections.sort(list, new AlarmCompartor());
	}
	
}

class ActiveAlarm {
	public long timeStarted;
	public long timeEnded;
	private String name = "";
	private String description = "";
	private String event;
	private boolean live = false;
	
	public ActiveAlarm(long timeStarted, long timeEnded, String name, String description, String event) {
		this.timeStarted = timeStarted;
		this.timeEnded = timeEnded;
		this.name = name;
		this.description = description;
		this.event = event;
	}

	/**
	 * @return the timeStarted
	 */
	public long getTimeStarted() {
		return timeStarted;
	}

	/**
	 * @param timeStarted the timeStarted to set
	 */
	public void setTimeStarted(long timeStarted) {
		this.timeStarted = timeStarted;
	}

	/**
	 * @return the timeEnded
	 */
	public long getTimeEnded() {
		return timeEnded;
	}

	/**
	 * @param timeEnded the timeEnded to set
	 */
	public void setTimeEnded(long timeEnded) {
		this.timeEnded = timeEnded;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the live
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * @param live the live to set
	 */
	public void setLive(boolean live) {
		this.live = live;
	}
	
}

class AlarmCompartor implements Comparator<ActiveAlarm> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ActiveAlarm x, ActiveAlarm y) {
		// TODO: Handle null x or y values
		int startComparison = compare(x.timeStarted, y.timeStarted);
		return startComparison != 0 ? startComparison 
									: compare(x.timeEnded, y.timeEnded);
	}

	// I don't know why this isn't in Long...
	private static int compare(long a, long b) {
		return a < b ? -1 : a > b ? 1 : 0;
	}
}