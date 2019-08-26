package com.collabera.configfile;


import java.sql.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConfigFile{
	

    public static void main(String[] args) throws Exception 
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Yutyrannus\\Desktop\\config.config");
        System.out.println("File found");
        
        Properties props = new Properties();
        props.load(file);
        String url = (String)props.get("url");
        String username = (String)props.get("username");
        String pass = (String)props.get("password");
        
        file.close();
        
        Connection conn = null;
        
        try
        {
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Connection made");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        try 
        {
            conn.close();
            System.out.println("Connection was closed");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
