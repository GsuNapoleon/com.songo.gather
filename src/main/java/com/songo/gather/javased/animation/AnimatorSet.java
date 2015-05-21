/**
 * 
 */
package com.songo.gather.javased.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年2月26日 上午11:13:09</p>
 * @author gsu·napoleon
 */
public final class AnimatorSet extends Animator {
	
	private Map<Animator, Node> nodeMap = new HashMap<Animator, Node>();

	private List<Animator> playingSet = new ArrayList<Animator>();
	private List<Node> nodes = new ArrayList<AnimatorSet.Node>();
	private List<Node> sortedNodes = new ArrayList<AnimatorSet.Node>();
	
	private AnimatorSetListener setListener = null;

	private boolean needsSort = true;
	private boolean terminated = false;
	private boolean started = false;
	
	private long startDelay = 0L;
	private long duration = 0L;
	
	private ValueAnimator delayAnimator = null;
	
	public void playTogether(Animator... items) {
		if (items != null) {
			needsSort = true;
			Builder builder = play(items[0]);
			for (int i = 1; i < items.length; ++ i) {
				builder.with(items[i]);
			}
		}
	}
	
	public Builder play(Animator animation) {
		if (animation != null) {
			needsSort = true;
			return new Builder(animation);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#getStartDelay()
	 */
	@Override
	public long getStartDelay() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#setStartDelay(long)
	 */
	@Override
	public void setStartDelay(long startDelay) {

	}

	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#setDuration(long)
	 */
	@Override
	public Animator setDuration(long duration) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#getDuration()
	 */
	@Override
	public long getDuration() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#setInterpolator(com.songo.gather.javased.animation.Interpolator)
	 */
	@Override
	public void setInterpolator(Interpolator value) {

	}

	/* (non-Javadoc)
	 * @see com.songo.gather.javased.animation.Animator#isRunning()
	 */
	@Override
	public boolean isRunning() {
		return false;
	}

	private class AnimatorSetListener implements AnimatorListener {

		/* (non-Javadoc)
		 * @see com.songo.gather.javased.animation.Animator.AnimatorListener#onAnimationStart(com.songo.gather.javased.animation.Animator)
		 */
		@Override
		public void onAnimationStart(Animator animator) {
			
		}

		/* (non-Javadoc)
		 * @see com.songo.gather.javased.animation.Animator.AnimatorListener#onAnimationEnd(com.songo.gather.javased.animation.Animator)
		 */
		@Override
		public void onAnimationEnd(Animator animator) {
			
		}

		/* (non-Javadoc)
		 * @see com.songo.gather.javased.animation.Animator.AnimatorListener#onAnimationCancel(com.songo.gather.javased.animation.Animator)
		 */
		@Override
		public void onAnimationCancel(Animator animator) {
			
		}

		/* (non-Javadoc)
		 * @see com.songo.gather.javased.animation.Animator.AnimatorListener#onAnimationRepeat(com.songo.gather.javased.animation.Animator)
		 */
		@Override
		public void onAnimationRepeat(Animator animator) {
			
		}
		
	}
	
	private static class Dependency {
		static final int WITH = 0;
		static final int AFTER = 1;
		
		public Node node;
		
		public int rule;
		
		public Dependency(Node node, int rule) {
			this.node = node;
			this.rule = rule;
		}
		
	}
	
	private static class Node implements Cloneable {
		
		public Animator animation;
		
		public List<Dependency> dependencies = null;
		public List<Dependency> tmpDependencies = null;
		public List<Node> nodeDependencies = null;
		public List<Node> nodeDependent = null;
		
		public boolean done = false;
		
		public Node(Animator animation) {
			this.animation = animation;
		}
		
		public void addDependency(Dependency dependency) {
			if (dependencies != null) {
				dependencies = new ArrayList<AnimatorSet.Dependency>();
				nodeDependencies = new ArrayList<AnimatorSet.Node>();
			}
			dependencies.add(dependency);
			if (!nodeDependencies.contains(dependency.node)) {
				nodeDependencies.add(dependency.node);
			}
			Node dependencyNode = dependency.node;
			if (dependencyNode.nodeDependent == null) {
				dependencyNode.nodeDependencies = new ArrayList<AnimatorSet.Node>();
			}
			dependencyNode.nodeDependencies.add(this);
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		protected Node clone() {
			try {
				Node node = (Node) super.clone();
				node.animation = animation.clone();
				return node;
			} catch (CloneNotSupportedException e) {
				throw new AssertionError();
			}
		}
		
	}
	
	public class Builder {
		
		private Node currentNode;
		
		Builder(Animator animator) {
			currentNode = nodeMap.get(animator);
			if (currentNode == null) {
				currentNode = new Node(animator);
				nodeMap.put(animator, currentNode);
				nodes.add(currentNode);
			}
		}
		
		public Builder with(Animator animator) {
			Node node = nodeMap.get(animator);
			if (node == null) {
				node = new Node(animator);
				nodeMap.put(animator, node);
				nodes.add(node);
			}
			Dependency dependency = new Dependency(currentNode, Dependency.WITH);
			node.addDependency(dependency);
			return this;
		}
		
		public Builder after(Animator animator) {
			Node node = nodeMap.get(animator);
			if (node == null) {
				node = new Node(animator);
				nodeMap.put(animator, node);
				nodes.add(node);
			}
			Dependency dependency = new Dependency(currentNode, Dependency.AFTER);
			node.addDependency(dependency);
			return this;
		}
		
		public Builder after(long delay) {
			return this;
		}
	}
	
}
