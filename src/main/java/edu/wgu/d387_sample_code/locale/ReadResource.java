package edu.wgu.d387_sample_code.locale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class ReadResource {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage() {
        try {
            return resourceBundle.getString("welcome.message");
        } catch (MissingResourceException e) {
            System.err.println("Error: 'welcome.message' key not found in resource bundle for locale " + locale);
            return null;
        }
    }

    public ReadResource() {

    }

    public ReadResource(String language, String country) {
        locale = new Locale(language, country);
        try {
            resourceBundle = ResourceBundle.getBundle("rBundle", locale);
            System.out.printf("Loaded resource bundle for %s, %s%n", language, country);
        } catch (MissingResourceException e) {
            System.err.printf("Error loading resource bundle for %s, %s%n", language, country);
            resourceBundle = null;
        }
    }
}
