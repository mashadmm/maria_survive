/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import javax.xml.ws.Endpoint;
import com.muni.fi.pa165.ws.SurviveServerImpl;

/**
 *
 * @author Maria
 */

public class SurvivePublisher {

   
    public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8081/ws/survive", new SurviveServerImpl());
    }
}
