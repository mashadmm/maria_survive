/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.gui;

import com.muni.fi.pa165.ws.MonsterDto;
import com.muni.fi.pa165.ws.WeaponDto;
import com.muni.fi.pa165.ws.MonsterClass;
import com.muni.fi.pa165.ws.WeaponClass;
import com.muni.fi.pa165.ws.WeaponType;
import java.util.Random;

public class Sampler {
    private static final Random RANDOM = new Random();

    public static WeaponDto createSampleWeapon() {
	String[] WEAPON_MODELS = { "Astra 300", "Dreyse M1907", "Mauser C96", "knife", "glass stick"};
        WeaponClass[] WEAPON_WEAPONCLASS = {WeaponClass.RANGED, WeaponClass.MELEE};
        WeaponType[] WEAPON_WEAPONTYPE = {WeaponType.GUN, WeaponType.BLADE, WeaponType.BLUNT, WeaponType.EXPLOSIVE};

	WeaponDto weapon = new WeaponDto();
	weapon.setName( WEAPON_MODELS[RANDOM.nextInt(WEAPON_MODELS.length)]);
	weapon.setRange(RANDOM.nextInt(100));
	weapon.setWeaponClass(WEAPON_WEAPONCLASS[RANDOM.nextInt(WEAPON_WEAPONCLASS.length)]);
        weapon.setWeaponType(WEAPON_WEAPONTYPE[RANDOM.nextInt(WEAPON_WEAPONTYPE.length)]);
	
	return weapon;
    }
    
    public static MonsterDto createSampleMonster() {
	String[] NAMES = { "Shrek", "Ziliboba", "Ondra", "Josef", "Spiderman"};
	MonsterClass[] MONSTERCLASS = {MonsterClass.ZOMBIE, MonsterClass.ROBOT, MonsterClass.MUTANT};
        
  	MonsterDto monster = new MonsterDto();
	monster.setName(NAMES[RANDOM.nextInt(NAMES.length)]);
	monster.setMonsterClass(MONSTERCLASS[RANDOM.nextInt(MONSTERCLASS.length)]);
	monster.setDangerLevel(RANDOM.nextDouble());
        monster.setAgility(RANDOM.nextDouble());

        return monster;
    }
}
