package com.hp.roam.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author ck
 * @date 2019年3月13日 下午4:48:50
 */
@Configuration
@EnableAsync
public class TreadPoolConfig {
	@Bean
	public Executor getAsyncExecutor() {
		
		ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
		//核心线程数
		threadPoolExecutor.setCorePoolSize(500);
		 // 最大线程数 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
		threadPoolExecutor.setMaxPoolSize(10100);
        // 队列最大长度
		threadPoolExecutor.setQueueCapacity(1000);
        // 线程池维护线程所允许的空闲时间(单位秒)
		threadPoolExecutor.setKeepAliveSeconds(120);
        // 线程池对拒绝任务(无线程可用)的处理策略 ThreadPoolExecutor.CallerRunsPolicy策略 ,
		//调用者的线程会执行该任务,如果执行器已关闭,则丢弃.
		threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		//用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他Bean
		threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);
		//用来设置线程池中任务的等待时间，超过时间强制销毁，以确保应用最后能够被关闭，而不是被阻塞住。
		threadPoolExecutor.setAwaitTerminationSeconds(60);
		threadPoolExecutor.setThreadNamePrefix("testopenfire-");
		threadPoolExecutor.initialize();
        return threadPoolExecutor;
	}
}
