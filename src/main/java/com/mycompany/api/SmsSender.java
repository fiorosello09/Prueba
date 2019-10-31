/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author fioro
 */
public class SmsSender
{

    /**
     *
     */
    public static final String ACCOUNT_SID = "ACf6a571f167b851713a1848352af18347";

    /**
     *
     */
    public static final String AUTH_TOKEN ="12123595ac1f2a8ea8af2f0928e43424";

    /**
     *
     * @param texto
     */
    public void enviarMensaje(String texto) {
    
    Twilio.init(ACCOUNT_SID,AUTH_TOKEN );

    Message message = Message.creator(new PhoneNumber("+50683476871"),
        new PhoneNumber("+1 541 435 2044"), 
       texto).create();

    System.out.println(message.getSid());
  
  }
    
}
