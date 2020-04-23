/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Test 1
 */
package com.qaant.rofexmaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * * 
 * @author pjseoane@qaantcap.com
 */
public class MainAccess {
    
    public static String marketID;
    public static String endpoint;
    public static String usr;
    public static String pswd;
    public static String ticker;
    public static String author;
    public static String version;
    
    public static void main(String[] args) throws Exception{
          
        
    try (InputStream input = new FileInputStream ("src/main/java/com/qaant/configuration/config.properties")){
    
        Properties prop =new Properties();
        prop.load(input);
            
        // *** upload variables in cfg file
            
        marketID        =prop.getProperty("ra.marketID");
        endpoint        =prop.getProperty("ra.endpoint");
        usr             =prop.getProperty("ra.usr");
        pswd            =prop.getProperty("ra.pswd");
        ticker          =prop.getProperty("ra.exampleTicker");
        author          =prop.getProperty("ra.author");
        version         =prop.getProperty("ra.version");
            
             
        //loginREST newConnection = new loginREST(); 
        System.out.println("Author :"+author);
            
        
        // print outputs
        System.out.println("\nREST Outputs:....");
        System.out.println("\nREST Version:...."+version);
        System.out.println("\nTOKEN->>>>>>>>>>:"+loginREST.getToken());
            
        String instruments =loginREST.getInstruments();
        System.out.println("Elements "+instruments);
           
        String instDetails =loginREST.getInstrumentDetail(ticker);
        System.out.println("Detail "+instDetails);
           
             
    }catch (IOException ex){
        System.out.println("Some error loading config.properties");
    }
        
    }
}

