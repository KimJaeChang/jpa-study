package kr.co.kjc.study.jpastudy.global.config.web;

import java.util.List;
import kr.co.kjc.study.jpastudy.global.config.interceptor.GlobalLoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CommonWebMvcConfig implements WebMvcConfigurer {

  private final static List<String> LOG_EXCLUDES = List.of("/css/**", "/*.ico", "/error",
      "/error-page/**", "/swagger-ui/**");

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new GlobalLoggingInterceptor())
        .order(1)
        .addPathPatterns("/**")
        .excludePathPatterns(LOG_EXCLUDES);
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    WebMvcConfigurer.super.addArgumentResolvers(resolvers);
  }

}
