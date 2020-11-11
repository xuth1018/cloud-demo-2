package com.wins.demo.config;

import feign.Logger;
import java.util.BitSet;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.bouncycastle.crypto.macs.VMPCMac;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    /**
     * 设置Fegin日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * feign okhttp
     * @return
     */
    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10, 5L, TimeUnit.SECONDS))
                .build();
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println(ClassLayout.parseInstance(bitSet).toPrintable());

    }

}