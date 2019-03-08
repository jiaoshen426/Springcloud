package com.jiaoshen.ribbon;

import java.util.List;


import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;


/**
 * 自定义ribbon负载均衡规则
 * @author 80505
 *
 */

public class MyRule implements IRule {
    private ILoadBalancer lb;
	@Override
	public Server choose(Object key) {
		List<Server> servers = lb.getAllServers();
		System.out.println("自定义服务器规则类");
		for(Server server: servers){
			System.out.println("  "+ server.getHostPort());
		}
		int a= (int)Math.random()*2;
		return servers.get(0);
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb= lb;
		
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return lb;
	}

}
