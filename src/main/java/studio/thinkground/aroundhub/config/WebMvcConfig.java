package studio.thinkground.aroundhub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import studio.thinkground.aroundhub.interceptor.HttpInterceptor;

/**
 * PackageName : studio.thinkground.aroundhub.config
 * FileName : WebMvcConfig
 * Author : Flature
 * Date : 2022-06-05
 * Description :
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/hello");
    }
}
