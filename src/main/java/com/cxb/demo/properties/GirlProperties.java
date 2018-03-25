package com.cxb.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//这是配置文件前缀为girl的   用一个类来接收配置文件里面的定义的值
@ConfigurationProperties(prefix = "girl")
@Component
public class GirlProperties {
    private String cupSize;
    private Integer age;

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }
}
