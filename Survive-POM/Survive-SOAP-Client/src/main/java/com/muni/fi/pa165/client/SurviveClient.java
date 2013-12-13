/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.client;

import com.muni.fi.pa165.ws.MonsterDto;
import com.muni.fi.pa165.ws.MonsterWeaponDto;
import com.muni.fi.pa165.ws.WeaponDto;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Maria
 */
public class SurviveClient {

    public SurviveClient() {}
        
         // Monster
        
        public List<MonsterDto> monsterManagerfindAll(){
                List<MonsterDto> result = new ArrayList<MonsterDto>();
                    try { // Call Web Service Operation
                        com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                        com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                        // TODO process result here
                        result = port.monsterManagerfindAll();
                        //System.out.println("Result = "+result);
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                    return result;
        }
        
        public void monsterManagersave(MonsterDto monster){
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.MonsterDto arg0 = new com.muni.fi.pa165.ws.MonsterDto();
                arg0 = monster;
                port.monsterManagersave(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        } 
        
        
        public void monsterManagerupdate(MonsterDto monster){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.MonsterDto arg0 = new com.muni.fi.pa165.ws.MonsterDto();
                arg0 = monster;
                port.monsterManagerupdate(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
         
       
        public void monsterManagerdelete(MonsterDto monster){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.MonsterDto arg0 = new com.muni.fi.pa165.ws.MonsterDto();
                arg0 = monster;
                port.monsterManagerdelete(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
 
        }
        
        
        public MonsterDto monsterManagerfindById(Long monsterid){
            
            MonsterDto result = new MonsterDto();
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = monsterid;
                // TODO process result here
                result = port.monsterManagerfindById(arg0);
                //System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
        // Weapon
        
        
        public List<WeaponDto> weaponManagerfindAll(){
            List<WeaponDto> result = new ArrayList<WeaponDto>();
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO process result here
                result = port.weaponManagerfindAll();
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
        public void weaponManagersave(WeaponDto weapon){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.WeaponDto arg0 = new com.muni.fi.pa165.ws.WeaponDto();
                arg0 = weapon;
                port.weaponManagersave(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        } 
        
        
        public void weaponManagerupdate(WeaponDto weapon){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.WeaponDto arg0 = new com.muni.fi.pa165.ws.WeaponDto();
                arg0 = weapon;
                port.weaponManagerupdate(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
         
       
        public void weaponManagerdelete(WeaponDto weapon){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.WeaponDto arg0 = new com.muni.fi.pa165.ws.WeaponDto();
                arg0 = weapon;
                port.weaponManagerdelete(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
        
        
        public WeaponDto weaponManagerfindById(Long weaponid){
            WeaponDto result = new WeaponDto();
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = weaponid;
                // TODO process result here
                result = port.weaponManagerfindById(arg0);
                //System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
        // MonsterWeapon
        
        
        public List<MonsterWeaponDto> monsterweaponManagerfindAll(){
            List<MonsterWeaponDto> result = new ArrayList<MonsterWeaponDto>();
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO process result here
                result = port.monsterweaponManagerfindAll();
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
        public void monsterweaponManagersave(MonsterWeaponDto monsterWeaponDto){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.MonsterWeaponDto arg0 = new com.muni.fi.pa165.ws.MonsterWeaponDto();
                arg0 = monsterWeaponDto;
                port.monsterweaponManagersave(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        } 
        
        
        public void monsterweaponManagerupdate(MonsterWeaponDto monsterWeaponDto){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                com.muni.fi.pa165.ws.MonsterWeaponDto arg0 = new com.muni.fi.pa165.ws.MonsterWeaponDto();
                arg0 = monsterWeaponDto;
                port.monsterweaponManagerupdate(arg0);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
         
        
        public void monsterweaponManagerdelete(Long monsterid, Long weaponid){
            
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = monsterid;
                java.lang.Long arg1 = weaponid;
                port.monsterweaponManagerdelete(arg0, arg1);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
        
        
        public MonsterWeaponDto monsterweaponManagerfindById(Long monsterid, Long weaponid){
            
            MonsterWeaponDto result = new MonsterWeaponDto();
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = monsterid;
                java.lang.Long arg1 = weaponid;
                // TODO process result here
                result = port.monsterweaponManagerfindById(arg0, arg1);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
       
        public List<MonsterWeaponDto> monsterweaponManagerfindByWeaponId(Long weaponid){
            List<MonsterWeaponDto> result = new ArrayList<MonsterWeaponDto>();
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = weaponid;
                // TODO process result here
                result = port.monsterweaponManagerfindByWeaponId(arg0);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
        
        public List<MonsterWeaponDto> monsterweaponManagerfindByMonsterId(Long monsterid){
            List<MonsterWeaponDto> result = new ArrayList<MonsterWeaponDto>();
            
            try { // Call Web Service Operation
                com.muni.fi.pa165.ws.SurviveServerImplService service = new com.muni.fi.pa165.ws.SurviveServerImplService();
                com.muni.fi.pa165.ws.SurviveServerImpl port = service.getSurviveServerImplPort();
                // TODO initialize WS operation arguments here
                java.lang.Long arg0 = monsterid;
                // TODO process result here
                result = port.monsterweaponManagerfindByMonsterId(arg0);
                System.out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

            return result;
        }
        
    }

