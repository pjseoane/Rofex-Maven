/*
 
 */
package com.qaant.rofexmaven;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 *
 * @author pjseoane@qaantcap.com
 */
public final class loginREST {
    
    public static String marketID;
    public static String endpoint;
    public static String usr;
    public static String pswd;
    public static String ticker;
    
    
    private static String url;
    private static String token=null;
          
    
    loginREST() throws Exception{
        //System.out.println(msg);
        System.out.println("Login to: "+MainAccess.endpoint);
        System.out.println("Processing token...:");
        getToken();
    }        

    public static String getToken()throws Exception{
        if (token == null){
            url=    MainAccess.endpoint+ "auth/getToken";
        
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String userCredentials = MainAccess.usr+":"+MainAccess.pswd;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", basicAuth);
            con.setDoOutput(true);
            token=con.getHeaderField("X-Auth-Token");
        }
           
        return token;
    }
    
    private static String doGET(String url) throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("X-Auth-Token",token);
        con.setRequestMethod("GET");
               
        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputline;
        StringBuilder content = new StringBuilder();
                
        while ((inputline = in.readLine()) != null) {
            content.append(inputline);
        }
        in.close();
        con.disconnect();
        return content.toString();
        
    }
    public static String getInstruments()throws Exception{
        url = MainAccess.endpoint+ "rest/instruments/all";
        
        return doGET(url);
    }
    public static String getInstrumentDetail(String symbol)throws Exception{
        url = MainAccess.endpoint + "rest/instruments/detail?symbol=" + symbol + "&marketId=" + MainAccess.marketID;
        return doGET(url);
    }
}

