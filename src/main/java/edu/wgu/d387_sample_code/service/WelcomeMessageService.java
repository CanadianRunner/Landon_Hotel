package edu.wgu.d387_sample_code.service;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class WelcomeMessageService implements Callable<String> {
    private final Locale locale;
    private final String bundleName;

    public WelcomeMessageService(Locale locale, String bundleName) {
        this.locale = locale;
        this.bundleName = bundleName;
    }

    @Override
    public String call() {
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
        return bundle.getString("welcome.message");
    }
}