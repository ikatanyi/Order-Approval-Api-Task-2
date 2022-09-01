package com.castille.config;

import java.util.Properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
@Configuration
@ConfigurationProperties("spring.mail")
public class EmailConfiguration {

    public String host;
    public int port;
    public String agentEmail;
    public String username;
    public String password;
    public String smtpAuth;
    public String smtpStarttlsEnable;

//    @Value("${spring.mail.templates.path}")
//    private String mailTemplatesPath;



}
