package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.service.impl.MonsterWeaponServiceImpl;
import com.muni.fi.pa165.dao.MonsterWeaponDao;
import com.muni.fi.pa165.dto.MonsterDto;
import com.muni.fi.pa165.service.AbstractServiceIntegrationTest;
import com.muni.fi.pa165.dto.MonsterWeaponDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.entities.Monster;
import com.muni.fi.pa165.entities.Monsterweapon;
import com.muni.fi.pa165.entities.MonsterweaponPK;
import com.muni.fi.pa165.entities.Weapon;
import com.muni.fi.pa165.enums.MonsterClass;
import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 *
 * @author irina
 */
public class MonsterWeaponServiceImplTest extends AbstractServiceIntegrationTest {

    @Inject
    private MonsterWeaponDao mockDAO;
    private MonsterWeaponServiceImpl service;
    @Inject
    private Mapper mapper;
    private Monster monster = new Monster();
    private Weapon weapon = new Weapon();
    private MonsterWeaponDto monsterWeaponDto = new MonsterWeaponDto();

    @Before
    public void setUp() {
        service = new MonsterWeaponServiceImpl();
        mockDAO = mock(MonsterWeaponDao.class);
        service.setDao(mockDAO);
        service.setMapper(mapper);

        monster.setId(Long.MIN_VALUE);
        monster.setAgility(11.0);
        monster.setDangerlevel(22.4);
        monster.setDescription("Headless Zombie");
        monster.setHeight(11.4);
        monster.setImagepath("C:\\image.png");
        monster.setMonsterclass(MonsterClass.Zombie);
        monster.setStamina(11.5);
        monster.setStrength(11.8);
        monster.setWeight(11.2);
        monster.setName("HeadlessNick");

        weapon.setId(Long.MIN_VALUE);
        weapon.setName("TESTAK47");
        weapon.setCaliber(Double.MIN_NORMAL);
        weapon.setDescription("Africa's favourite");
        weapon.setRounds(44);
        weapon.setRange(100);
        weapon.setWeaponclass(WeaponClass.Ranged);
        weapon.setWeapontype(WeaponType.Gun);
        
        MonsterweaponPK pk = new MonsterweaponPK();
        pk.setMonsterid(monster.getId());
        pk.setWeaponid(weapon.getId());

     monsterWeaponDto.setWeapon(mapper.map(weapon, WeaponDto.class));
       monsterWeaponDto.setMonster(mapper.map(monster, MonsterDto.class));
        monsterWeaponDto.setHitRate(5);
        monsterWeaponDto.setDamage(12);
        monsterWeaponDto.setEfficiency(55);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class MonsterWeaponServiceImpl.
     */
    
    //TEST NEEDS TO BE CHANGED TO IMPLEMENT PK (MONSTERWEAPONPK)
    
    
//    @Test
//    public void testSave() {
//
//        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
//        when(mockDAO.save(any(Monsterweapon.class))).thenReturn(entity);
//        MonsterWeaponDto returned = service.save(monsterWeaponDto);
//        verify(mockDAO, times(1)).save(entity);
//        assertEquals(returned, monsterWeaponDto);
//    }

    /**
     * Test of update method, of class MonsterWeaponServiceImpl.
     */
    
        //TEST NEEDS TO BE CHANGED TO IMPLEMENT PK (MONSTERWEAPONPK)
//    @Test
//    public void testUpdate() {
//
//        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
//        when(mockDAO.update(any(Monsterweapon.class))).thenReturn(entity);
//        MonsterWeaponDto returned = service.update(monsterWeaponDto);
//        verify(mockDAO, times(1)).update(entity);
//        verifyNoMoreInteractions(mockDAO);
//        assertEquals(returned, monsterWeaponDto);
//    }

    /**
     * Test of delete method, of class MonsterWeaponServiceImpl.
     */
    @Test
    public void testDelete() {

        Monsterweapon entity = mapper.map(monsterWeaponDto, Monsterweapon.class);
        service.delete(monsterWeaponDto);
        verify(mockDAO, times(1)).delete(entity);
        verifyNoMoreInteractions(mockDAO);

    }
}
