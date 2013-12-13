/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.dto;

import java.util.Objects;

/**
 *
 * @author irina
 */
public class MonsterAreaDto {

    

    private MonsterDto monster;
    private AreaDto area;
    private int monsterQuantity;

   

    public MonsterDto getMonster() {
        return monster;
    }

    public void setMonster(MonsterDto monster) {
        this.monster = monster;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    } 
    
    public int getMonsterQuantity() {
        return monsterQuantity;
    }

    public void setMonsterQuantity(int monsterQuantity) {
        this.monsterQuantity = monsterQuantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MonsterAreaDto other = (MonsterAreaDto) obj;
        if (!Objects.equals(this.monster, other.monster)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (this.monsterQuantity != other.monsterQuantity) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
}
