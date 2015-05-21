/**
 * 
 */
package com.songo.gather.javased.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>decription:</p>
 * <p>date:2015年2月26日 上午9:51:47</p>
 * @author gsu·napoleon
 */
public abstract class Animator implements Cloneable {

	List<AnimatorListener> listeners = null;
	
	public void start() {}
	
	public void cancel() {}
	
	public void end() {}
	
	public abstract long getStartDelay();
	
	public abstract void setStartDelay(long startDelay);
	
	public abstract Animator setDuration(long duration);
	
	public abstract long getDuration();
	
	public abstract void setInterpolator(Interpolator value);
	
	public abstract boolean isRunning();
	
	public boolean isStarted() {
		return isRunning();
	}
	
	public void addListener(AnimatorListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<Animator.AnimatorListener>();
		}
		listeners.add(listener);
	}
	
	public void removeListener(AnimatorListener listener) {
		if (listeners == null) {
			return;
		}
		listeners.remove(listener);
		if (listeners.size() == 0) {
			listeners = null;
		}
	}
	
	/**
	 * @return the listeners
	 */
	public List<AnimatorListener> getListeners() {
		return listeners;
	}

	public void removeAllListeners() {
		if (listeners == null) {
			listeners.clear();
			listeners = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Animator clone() {
		try {
			final Animator animator = (Animator) super.clone();
			if (listeners != null) {
				List<AnimatorListener> oldListeners = listeners;
				animator.listeners = new ArrayList<Animator.AnimatorListener>();
				int numListeners = oldListeners.size();
				for (int i = 0; i < numListeners; i ++) {
					animator.listeners.add(oldListeners.get(i));
				}
			}
			return animator;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
	}
	
	public void setupStartValues() {}
	
	public void setupEndValues() {}
	
	public void setTarget(Object target) {}

	public static interface AnimatorListener {
		
		void onAnimationStart(Animator animator);
		
		void onAnimationEnd(Animator animator);
		
		void onAnimationCancel(Animator animator);
		
		void onAnimationRepeat(Animator animator);
		
	}
	
}
