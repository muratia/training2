package com.am.training.demo.ifs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "\\uploads\\";

    /**
     * Folder location for storing files
     */
    private String location = UPLOADED_FOLDER;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
