package com.github.springbootdocker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
       registry
               .addMapping("/**")
               .allowedOrigins("*")
               .allowedHeaders("*")
               .allowedMethods("*")
               .allowCredentials(false);
    }
}
