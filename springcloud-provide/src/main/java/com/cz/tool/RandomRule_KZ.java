/*
 * 文件名：RandomRule_KZ.java
 * 版权：Copyright by www.olo-home.com
 * 作者：陈铮
 * 日期：2021年1月21日
 */

package com.cz.tool;


import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;


public class RandomRule_KZ extends AbstractLoadBalancerRule {
    // total = 0 // 当total==5以后，我们指针才能往下走，
    // index = 0 // 当前对外提供服务的服务器地址，
    // total需要重新置为零，但是已经达到过一个5次，我们的index = 1
    // 分析：我们5次，但是微服务只有8001 8002  两台

    private int total = 0; // 总共被调用的次数，目前要求每台被调用5次

    private int currentIndex = 0; // 当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null; //刚开始不知道服务哪个为null

        while (server == null) { //循环判断服务
            if (Thread.interrupted()) { //判断线程是不是中断
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //获取活着的微服务
            List<Server> allList = lb.getAllServers(); //获取所有的微服务

            int serverCount = allList.size(); //统计微服务的数量
            if (serverCount == 0) { //
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            //           int index = rand.nextInt(serverCount);               //假如有三台微服务serverCount=3   随机获取一个数字(nextInt(3)左闭右开)
            //           server = upList.get(index);                          //根据随机数获取集合的一个微服务

            //          private int total = 0;          // 总共被调用的次数，目前要求每台被调用5次
            //          private int currentIndex = 0;   // 当前提供服务的机器号
            if (total < 5) {
                server = upList.get(currentIndex);
                total++ ;
            }
            else {
                total = 0;
                currentIndex++ ;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) { //如果微服务微null
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield(); //线程礼让，
                continue; //继续循环判断
            }

            if (server.isAlive()) { //假如这个微server是活的
                return (server); //返回这个微服务
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server; //最终返回这个微服务

    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }

    public Server choose(Object key) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
