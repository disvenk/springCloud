package com.springcloud.orderfegin.writeFallback;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.*;

public class OrderHystrixCommand extends HystrixCommand<JSONObject> {

    public OrderHystrixCommand(){
        super(setter());
    }

    //配置服务隔离机制
    private static Setter setter(){
        //服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("orders");
        //服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("order");
        //线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("order-pool");
        //线程池配置，线程池大小为10，线程存活时间15秒，队列等待的阈值100，超过100执行拒绝策略
        HystrixThreadPoolProperties.Setter threadPoolKeyProperties = HystrixThreadPoolProperties.Setter().
                withCoreSize(10).withKeepAliveTimeMinutes(15).withQueueSizeRejectionThreshold(100);

        //命令属性配置Hystrix，开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter().
                //采用线程池方式隔离服务
                withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                //禁用超时服务降级
                .withExecutionTimeoutEnabled(false);

        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolKeyProperties).andCommandPropertiesDefaults(commandProperties);
    }

    //服务降级
    @Override
    protected JSONObject run() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",401);
        jsonObject.put("msg","服务不可用，稍后访问");
        return jsonObject;
    }

    @Override
    protected JSONObject getFallback() {
        return super.getFallback();
    }
}
