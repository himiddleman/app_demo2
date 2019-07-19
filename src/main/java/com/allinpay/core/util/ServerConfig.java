package com.allinpay.core.util;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * 获取服务请求方法
 *
 * @author xuming
 * @date 2019-07-09
 */
@Component
public class ServerConfig implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private int serverPort;

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "http://" + address.getHostAddress() + ":" + this.serverPort + "/";
    }

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent embeddedServletContainerInitializedEvent) {
        this.serverPort = embeddedServletContainerInitializedEvent.getEmbeddedServletContainer().getPort();
    }
}
