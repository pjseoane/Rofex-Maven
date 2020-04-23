/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Test 1
 */
package com.qaant.rofexmaven;

/**
 * * 
 * @author pjseoane@qaantcap.com
 */
public class MainAccess {
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
             
            loginREST newConnection = new loginREST();
            System.out.println("\nTOKEN->>>>>>>>>>:"+newConnection.getToken());
            
            String instruments =newConnection.getInstruments();
            System.out.println("Elements "+instruments);
            
            String instDetails =newConnection.getInstrumentDetail("RFX20Jun19");
            System.out.println("Detail "+instDetails);
        
    }
}
