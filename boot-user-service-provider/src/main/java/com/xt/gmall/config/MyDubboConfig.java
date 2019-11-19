package com.xt.gmall.config;

import com.xt.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.dubbo.config.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三种方式: dubbo 配置类
 */
@Configuration
public class MyDubboConfig {

    // <dubbo:application name="boot-user-service-provider"/>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    // <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"/>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("192.168.239.13:2181");
        return registryConfig;
    }

    // <dubbo:protocol name="dubbo" port="20880" />
    @Bean
    protected ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * <dubbo:service interface="com.xt.gmall.service.UserService" ref="userServiceImpl" timeout="3000" version="1.0.0">
     *      <dubbo:method name="getUserAddressList" timeout="5000"/>
     * </dubbo:service>
     *
     * <bean id="userServiceImpl" class="com.xt.gmall.service.impl.UserServiceImpl"/>
     */
    @Bean
    public ServiceConfig<UserService> serviceConfig (UserService userService) {
        ServiceConfig<UserService> serviceConfig = new com.alibaba.dubbo.config.ServiceConfig<UserService>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        // 配置每一个 method 的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);

        // 将 method 的设置关联到 service 配置中

        serviceConfig.setMethods(methods);
        return serviceConfig;
    }

    // ProviderConfig

    // <dubbo:monitor protocol="registry"/>
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
}
