/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.ws;

import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 *
 * @author Maria
 */

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface SurviveServer{
    
 
	
          // Monster Manager
    
         List<MonsterDto> monsterManagerfindAll();
        
         void monsterManagersave(MonsterDto monster);
         
         void monsterManagerupdate(MonsterDto monster);
         
         void monsterManagerdelete(MonsterDto monster);
         
         MonsterDto monsterManagerfindById(Long monsterid);
         
         // Weapon
         
         List<WeaponDto> weaponManagerfindAll();
        
         void weaponManagersave(WeaponDto weapon);
         
         void weaponManagerupdate(WeaponDto weapon);
         
         void weaponManagerdelete(WeaponDto weapon);
         
         WeaponDto weaponManagerfindById(Long weaponid);
         
         //MonsterWeapon
         
         public List<MonsterWeaponDto> monsterweaponManagerfindAll();
         
         public void monsterweaponManagersave(MonsterWeaponDto monsterWeaponDto);
         
         public void monsterweaponManagerupdate(MonsterWeaponDto monsterWeaponDto);
         
         public void monsterweaponManagerdelete(Long monsterid, Long weaponid);
         
         public List<MonsterWeaponDto> monsterweaponManagerfindByWeaponId(Long weaponid);
         
         public MonsterWeaponDto monsterweaponManagerfindById(Long monsterid, Long weaponid);
         
         public List<MonsterWeaponDto> monsterweaponManagerfindByMonsterId(Long monsterid);
         
         
        
        
}