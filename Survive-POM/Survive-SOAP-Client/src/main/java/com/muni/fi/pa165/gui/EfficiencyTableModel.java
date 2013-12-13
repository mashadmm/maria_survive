package com.muni.fi.pa165.gui;

import com.muni.fi.pa165.client.SurviveClient;
import com.muni.fi.pa165.ws.MonsterWeaponDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class EfficiencyTableModel extends AbstractTableModel {
 
    private static final Logger LOGGER = Logger.getLogger(EfficiencyTableModel.class.getName());
    
    
    private List<MonsterWeaponDto> efficiencies = new ArrayList<MonsterWeaponDto>();
    private static enum COLUMNS {
        MONSTER, WEAPON, HITRATE, DAMAGE, EFFICIENCY, DESCRIPTION
    }
    
    private SurviveClient client;
    public  EfficiencyTableModel(){
        this.client = new SurviveClient();
    } 
    
    @Override
    public int getRowCount() {
        return efficiencies.size();
    }
 
    @Override
    public int getColumnCount() {
        return COLUMNS.values().length;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {

	    case MONSTER:
            case WEAPON:
            case DESCRIPTION:
                return String.class;
            case HITRATE:
	    case DAMAGE:
            case EFFICIENCY:
		return Integer.class;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }
   
    
    @Override
    public String getColumnName(int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case MONSTER:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_table_monster");
            case WEAPON:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_table_weapon");
	    case HITRATE:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_hitRate");
	    case DAMAGE:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_damage");
	    case EFFICIENCY:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_efficiency");
	    case DESCRIPTION:
		return java.util.ResourceBundle.getBundle("Bundle").getString("efficiencies_table_description");
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonsterWeaponDto efficiency = efficiencies.get(rowIndex);
        switch (COLUMNS.values()[columnIndex]) {
            case MONSTER:
                return efficiency.getMonster().getName();
            case WEAPON:
                return efficiency.getWeapon().getName();
            case HITRATE:
                return efficiency.getHitRate();
	    case DAMAGE:
                return efficiency.getDamage();
            case EFFICIENCY:
                return efficiency.getEfficiency();
	    case DESCRIPTION:
                return efficiency.getDescription();
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
    
    public void addMonsterweapon(MonsterWeaponDto efficiency) {
	efficiencies.add(efficiency);
	fireTableDataChanged();
    }
    
    public void removeMonsterweapon(MonsterWeaponDto efficiency) {
	efficiencies.remove(efficiency);
	fireTableDataChanged();
    }
    
    public void clear() {
	efficiencies.clear();
        fireTableDataChanged();
    }
    
     public List<MonsterWeaponDto> getAllEfficiencies() {
	return efficiencies;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	MonsterWeaponDto efficiency = efficiencies.get(rowIndex);
	switch (COLUMNS.values()[columnIndex]) {
	    case HITRATE:
		efficiency.setHitRate((Integer) aValue);
		break;
	    case DAMAGE:
		efficiency.setDamage((Integer) aValue);
		break;
	    case EFFICIENCY:
		efficiency.setEfficiency((Integer) aValue);
		break;
            case DESCRIPTION:
		efficiency.setDescription((String) aValue);
		break;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
        try {
            client.monsterweaponManagerupdate(efficiency);
            fireTableDataChanged();
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case MONSTER:
	    case WEAPON:
                 return false;
	    case HITRATE:
            case DAMAGE:
            case EFFICIENCY:
            case DESCRIPTION:
		return true;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }

}
