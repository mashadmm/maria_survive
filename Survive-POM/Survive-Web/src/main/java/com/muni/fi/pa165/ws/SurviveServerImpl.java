/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.ws;

import com.muni.fi.pa165.dao.WeaponDao;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.service.MonsterService;
import com.muni.fi.pa165.service.MonsterWeaponService;
//import com.muni.fi.pa165.service.WeaponService;
//import com.muni.fi.pa165.service.impl.MonsterServiceImpl;
//import com.muni.fi.pa165.service.impl.MonsterWeaponServiceImpl;
//import com.muni.fi.pa165.service.impl.WeaponServiceImpl;
import com.muni.fi.pa165.service.WeaponService;
import com.sun.jersey.spi.inject.Inject;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Maria
 */

@WebService
public class SurviveServerImpl implements SurviveServer {
    
	ApplicationContext context;
	private MonsterService monsterManager;
        private MonsterWeaponService monsterweaponManager;
        private WeaponService weaponManager;
    
        
        public SurviveServerImpl(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
		monsterManager = (MonsterService) context.getBean("monsterService");
        }
	

        
        @WebMethod 
        @Override
        public List<MonsterDto> monsterManagerfindAll(){
		return monsterManager.findAll();
        }
        @WebMethod
        @Override
        public void monsterManagersave(MonsterDto monster){
            //monsterManager.save(monster);
        } 
        
        @WebMethod
        @Override
        public void monsterManagerupdate(MonsterDto monster){
            monsterManager.update(monster);
        }
         
        @WebMethod
        @Override
        public void monsterManagerdelete(MonsterDto monster){
            //monsterManager.delete(monster);
        }
        
        @WebMethod
        @Override
        public MonsterDto monsterManagerfindById(Long monsterid){
            return monsterManager.findById(monsterid);
        }
        
        // Weapon
        
        @WebMethod 
        @Override
        public List<WeaponDto> weaponManagerfindAll(){
            return weaponManager.findAll();
        }
        @WebMethod
        @Override
        public void weaponManagersave(WeaponDto weapon){
            weaponManager.save(weapon);
        } 
        
        @WebMethod
        @Override
        public void weaponManagerupdate(WeaponDto weapon){
            weaponManager.update(weapon);
        }
         
        @WebMethod
        @Override
        public void weaponManagerdelete(WeaponDto weapon){
            weaponManager.delete(weapon);
        }
        
        @WebMethod
        @Override
        public WeaponDto weaponManagerfindById(Long weaponid){
            return weaponManager.findById(weaponid);
        }
        
        // MonsterWeapon
        
        @WebMethod 
        @Override
        public List<MonsterWeaponDto> monsterweaponManagerfindAll(){
            return monsterweaponManager.findAll();
        }
        @WebMethod
        @Override
        public void monsterweaponManagersave(MonsterWeaponDto monsterWeaponDto){
            monsterweaponManager.save(monsterWeaponDto);
        } 
        
        @WebMethod
        @Override
        public void monsterweaponManagerupdate(MonsterWeaponDto monsterWeaponDto){
            monsterweaponManager.update(monsterWeaponDto);
        }
         
        @WebMethod
        @Override
        public void monsterweaponManagerdelete(Long monsterid, Long weaponid){
            //monsterweaponManager.delete(monsterid, weaponid);
        }
        
        @WebMethod
        @Override
        public MonsterWeaponDto monsterweaponManagerfindById(Long monsterid, Long weaponid){
            return monsterweaponManager.findById(monsterid, weaponid);
        }
        
        @WebMethod
        @Override
        public List<MonsterWeaponDto> monsterweaponManagerfindByWeaponId(Long weaponid){
            return monsterweaponManager.findByWeaponId(weaponid);
        }
        
        @WebMethod
        @Override
        public List<MonsterWeaponDto> monsterweaponManagerfindByMonsterId(Long monsterid){
            return monsterweaponManager.findByMonsterId(monsterid);
        }
              
             
        
}