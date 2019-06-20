package com.show.spring.cloud.hystrix.client.fallback;

import com.show.spring.cloud.hystrix.client.SpringCloudServerClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务降级触发类
 * @author xuanweiyao
 * @date 18:15 2019/6/19
 * @Component 作为组件
 */
@Component
@Slf4j
public class SpringCloudServerClientFallback implements FallbackFactory<SpringCloudServerClient> {

//

    @Override
    public SpringCloudServerClient create(Throwable cause) {

        return new SpringCloudServerClient() {
            @Override
            public String feignOverTime() {
                // 触发服务降级返回
                log.info("feign接口请求异常，触发断路器，返回null");
                return "feign接口请求异常，触发断路器，返回null";
            }

            /**
             * 测试请求
             * @author xuanweiyao
             * @date 16:30 2019/6/20
             * @return java.lang.String
             */
            @Override
            public String feign() {

                // 触发服务降级返回
                log.info("feign接口请求异常，触发断路器，返回null");
                return "feign接口请求异常，触发断路器，返回null";
            }
        };
    }
}