package com.example.demo;

import java.io.FileInputStream;
import java.util.Properties;

public class ConnectionManager {
    //вытягиваем properties
    FileInputStream fis;
    Properties property = new Properties();

    fis = new FileInputStream("src/main/java/resources/application.properties");
    property.load(fis);
}
