package com.ss.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * MyRule
 * 规则：每台服务器访问五次，然后切下一个
 * 该类不能放在spring能扫描的类下 不然会不起作用
 *
 * @author shisong
 * @date 2020-05-10
 */
public class MyRule extends AbstractLoadBalancerRule {

    /**
     * 每次访问的次数
     */
    private static final int count = 5;

    /**
     * 当前第几次访问
     */
    private int num = 0;

    /**
     * 那一套服务
     */
    private int index = 0;

    public MyRule() {
    }

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //所有up的服务 根据 private static final String REST_URL_PREFIX= "http://MICROSERVICECLOUD-DEPT"; 中的MICROSERVICECLOUD-DEPT查询到的所有服务
            List<Server> upList = lb.getReachableServers();
            //所有服务，包括down的服务
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            /*int index = rand.nextInt(serverCount);
            server = upList.get(index);*/
            //当num小于等于最大访问次数时，num++
            //否则num=1 index++
            if(num < count){
                num++;
            }else{
                num = 1;
                index ++;
            }
            if(index >= upList.size()){
                index = 0;
            }
            server = upList.get(index);

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
