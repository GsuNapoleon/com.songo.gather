/**
 * 
 */
package com.songo.gather.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>decription:摘抄自Spring源码,处理Filter链</p>
 * <p>date:2014年4月28日 上午11:59:06</p>
 * @author gsu·napoleon
 */
public class CompositeFilter implements Filter {
	
	private List<? extends Filter> filters = new ArrayList<Filter>();

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		for (Filter filter : filters) {
			filter.init(filterConfig);
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		new VirtualFilterChain(chain, filters).doFilter(request, response);
	}
	
	public static class VirtualFilterChain implements FilterChain {
		
		private FilterChain originChain;
		private List<? extends Filter> additionalFilters;
		private int currentPosition = 0;
		
		private VirtualFilterChain(FilterChain chain, List<? extends Filter> additionalFilters) {
			this.originChain = chain;
			this.additionalFilters = additionalFilters;
		}

		/* (non-Javadoc)
		 * @see javax.servlet.FilterChain#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
		 */
		@Override
		public void doFilter(ServletRequest request, ServletResponse response)
				throws IOException, ServletException {
			if (currentPosition == additionalFilters.size()) {
				originChain.doFilter(request, response);
			} else {
				currentPosition ++;
				Filter nextFilter = additionalFilters.get(currentPosition - 1);
				nextFilter.doFilter(request, response, this);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		for (Filter filter : filters) {	// 这种写法,不使用于Filter Chain的后进先出的操作原理
			filter.destroy();
		}
		for (int i = filters.size(); i -- > 0; ) {	// 实现后进先出
			Filter filter = filters.get(i);
			filter.destroy();
		}
	}

}
