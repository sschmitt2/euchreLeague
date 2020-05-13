package com.euchreleague.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Eric Knapp
 */
public interface PropertiesLoader {

    /**
     * Loads a properties file for whichever programs are implementing the PropertiesLoader interface.
     *
     * @param  propertiesFilePath the name of the properties file
     * @return the loaded properties file
     * @throws IOException if the properties file cannot be loaded
     * @throws Exception if there is a more general error
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        final Logger logger = LogManager.getLogger(this.getClass());
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("The filepath could not be read", ioException);
            throw ioException;
        } catch (Exception exception) {
            logger.error("Error", exception);
            throw exception;
        }
        return properties;
    }
}