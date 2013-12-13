package com.muni.fi.pa165.gui;

import com.muni.fi.pa165.client.SurviveClient;
import com.muni.fi.pa165.ws.WeaponDto;
import com.muni.fi.pa165.ws.WeaponClass;
import com.muni.fi.pa165.ws.WeaponType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
//import net.sourceforge.stripes.integration.spring.SpringBean;

public class WeaponTableModel extends AbstractTableModel {
    
    private static final Logger LOGGER = Logger.getLogger(WeaponTableModel.class.getName());

    private List<WeaponDto> weapons = new ArrayList<WeaponDto>();
    private static enum COLUMNS {
        ID, NAME, WEAPONTYPE, WEAPONCLASS, RANGE, CALIBER, ROUNDS, DESCRIPTION
 
    }
    
    private SurviveClient client;
    public  WeaponTableModel(){
        this.client = new SurviveClient();
    } 
    
    @Override
    public int getRowCount() {
        return weapons.size();
    }
 
    @Override
    public int getColumnCount() {
        return COLUMNS.values().length;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	switch (columnIndex) {
	    case 0:
		return Long.class;
	    case 1:
	    case 2:
            case 3:
            case 7:
		return String.class;
	    case 4:
            case 6:
		return Integer.class;
            case 5:
		return Double.class;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
 
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WeaponDto weapon = weapons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return weapon.getId();
            case 1:
                return weapon.getName();
            case 2:
                return weapon.getWeaponType();
            case 3:
                return weapon.getWeaponClass();
            case 4:
                return weapon.getRange();
            case 5:
                return weapon.getCaliber();
            case 6:
                return weapon.getRounds();
            case 7:
                return weapon.getDescription();
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
    
    public void addWeapon(WeaponDto weapon) {
	weapons.add(weapon);
	fireTableDataChanged();
    }
    
    public void removeWeapon(WeaponDto weapon) {
	weapons.remove(weapon);
	fireTableDataChanged();
    }
    
    public void clear() {
	weapons.clear();
        fireTableDataChanged();
    }
    
     public List<WeaponDto> getAllWeapons() {
	return weapons;
    }

    
    @Override
    public String getColumnName(int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case ID:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_id");
	    case NAME:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_name");
	    case WEAPONTYPE:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_weaponType");
	    case WEAPONCLASS:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_weaponClass");
            case RANGE:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_range");
	    case CALIBER:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_caliber");
	    case ROUNDS:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_rounds");
	    case DESCRIPTION:
		return java.util.ResourceBundle.getBundle("Bundle").getString("weapons_table_description");
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	WeaponDto weapon = weapons.get(rowIndex);
	switch (COLUMNS.values()[columnIndex]) {
            case ID:
		weapon.setId((Long) aValue);
                break;
	    case NAME:
		weapon.setName((String) aValue);
                break;
	    case WEAPONTYPE:
		weapon.setWeaponType((WeaponType) aValue);
                break;
	    case WEAPONCLASS:
		weapon.setWeaponClass((WeaponClass) aValue);
                break;
            case RANGE:
		weapon.setRange((Integer) aValue);
                break;
	    case CALIBER:
		weapon.setCaliber((Double) aValue);
                break;
	    case ROUNDS:
		weapon.setRounds((Integer) aValue);
                break;
	    case DESCRIPTION:
		weapon.setDescription((String) aValue);
                break;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
        try {
            client.weaponManagerupdate(weapon);
            fireTableDataChanged();
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	switch (columnIndex) {
	    case 1:
	    case 2:
            case 3:
            case 4:
	    case 5:
            case 6:
            case 7:
		return true;
	    case 0:
		return false;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }

}
