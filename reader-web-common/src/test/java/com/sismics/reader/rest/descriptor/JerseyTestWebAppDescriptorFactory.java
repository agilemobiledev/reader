package com.sismics.reader.rest.descriptor;

import java.io.File;

import com.sismics.util.filter.RequestContextFilter;
import com.sismics.util.filter.TokenBasedSecurityFilter;
import com.sun.jersey.test.framework.WebAppDescriptor;

/**
 * Jersey tests Webapp descriptor.
 * 
 * @author jtremeaux
 */
public class JerseyTestWebAppDescriptorFactory {
    private static String basePath = new File("src/main/webapp").getAbsolutePath();
    
    /**
     * Constructs a new descriptor.
     * 
     * @return Descriptor
     */
    public static WebAppDescriptor build() {
        // Target the base path to the Webapp resources
        System.setProperty("user.dir", basePath);
        
        return new WebAppDescriptor.Builder("com.sismics.reader.rest.resource")
            .contextPath("reader")
            .addFilter(RequestContextFilter.class, "requestContextFilter")
            .addFilter(TokenBasedSecurityFilter.class, "tokenBasedSecurityFilter")
            .initParam("com.sun.jersey.spi.container.ContainerRequestFilters", "com.sun.jersey.api.container.filter.LoggingFilter")
            .initParam("com.sun.jersey.spi.container.ContainerResponseFilters", "com.sun.jersey.api.container.filter.LoggingFilter")
            .build();
    }
}
