package com.gl.microservices.zull.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZullLogingFilter extends ZuulFilter{

	
	public Object run() {
		HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
		
		String message = String.format("request -> %s request uri -> %s ", request, request.getRequestURI());
		System.out.println(message);
		return null;
	}

	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
