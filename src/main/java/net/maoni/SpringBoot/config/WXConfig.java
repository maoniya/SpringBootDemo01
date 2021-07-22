package net.maoni.SpringBoot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource(value="classpath:pay.properties")
@Data
public class WXConfig implements Serializable {
    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.sercret}")
    private String paySecret;
    @Value("${wx.mechid}")
    private String payMechId;
}
