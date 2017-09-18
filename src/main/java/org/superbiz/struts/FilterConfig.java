package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyf
 * @create 2017-09-18 下午2:35
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean struts2RegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterDispatcher());
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("actionPackages","com.lq");
        registrationBean.setInitParameters(initParameters);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean struts2CleanupRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new ActionContextCleanUp());
        registrationBean.setOrder(2);
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean sitemeshRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new PageFilter());
        registrationBean.setOrder(3);
        return registrationBean;
    }
}
