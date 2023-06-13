package com.agussuhardi.i18n.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :20.06
 * @project i18n
 */
@Component
public class i18n {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    i18n(ResourceBundleMessageSource resourceBundleMessageSource) {
        messageSource = resourceBundleMessageSource;
    }

    public static String translate(String messageCode, Object... arguments) {
        return messageSource.getMessage(messageCode, arguments, LocaleContextHolder.getLocale());
    }
}