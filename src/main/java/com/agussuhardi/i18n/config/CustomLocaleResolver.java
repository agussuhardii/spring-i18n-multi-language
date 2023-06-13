package com.agussuhardi.i18n.config;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :20.06
 * @project i18n
 */
@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Override
    @Nonnull
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return null == headerLang || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.forLanguageTag(headerLang);
    }


    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource() {
        var resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("i18n/messages");
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
        Locale locale = new Locale("id", "ID");
        Locale.setDefault(locale);
        resourceBundleMessageSource.setDefaultLocale(locale);
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }
}