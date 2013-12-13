package com.muni.fi.pa165.gui;


import com.muni.fi.pa165.client.SurviveClient;
import com.muni.fi.pa165.ws.MonsterDto;
import com.muni.fi.pa165.ws.MonsterClass;
import com.muni.fi.pa165.service.MonsterService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
//import net.sourceforge.stripes.integration.spring.SpringBean;


public class MonsterTableModel extends AbstractTableModel {
    
    private static final Logger LOGGER = Logger.getLogger(MonsterTableModel.class.getName());

    private List<MonsterDto> monsters = new ArrayList<MonsterDto>();
    private static enum COLUMNS {
        ID, MONSTERCLASS, NAME, DESCRIPTION, HEIGHT, WEIGHT, AGILITY, STRENGTH, STAMINA, DANGERLEVEL, IMAGEPATH
    }
 
    private SurviveClient client;
    public  MonsterTableModel(){
        this.client = new SurviveClient();
    } 
    
    @Override
    public int getRowCount() {
        return monsters.size();
    }
 
    @Override
    public int getColumnCount() {
        return COLUMNS.values().length;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case ID:
		return Long.class;
	    case MONSTERCLASS:
	    case NAME:
	    case DESCRIPTION:
            case IMAGEPATH:
		return String.class;
	    case HEIGHT:
            case WEIGHT:
	    case AGILITY:
	    case STRENGTH:
            case STAMINA:    
            case DANGERLEVEL:
		return Double.class;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }
    
    @Override
    public String getColumnName(int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case ID:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_id");
	    case MONSTERCLASS:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_monsterClass");
	    case NAME:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_name");
	    case DESCRIPTION:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_description");
	    case HEIGHT:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_height");
            case WEIGHT:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_weight");
	    case AGILITY:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_agility");
	    case STRENGTH:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_strength");
	    case STAMINA:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_stamina");
	    case DANGERLEVEL:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_dangerLevel");
            case IMAGEPATH:
		return java.util.ResourceBundle.getBundle("Bundle").getString("monsters_table_imagePath");
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonsterDto monster = monsters.get(rowIndex);
        switch (COLUMNS.values()[columnIndex]) {
            case ID:
		return monster.getId();
	    case MONSTERCLASS:
		return monster.getMonsterClass();
	    case NAME:
		return monster.getName();
	    case DESCRIPTION:
		return monster.getDescription();
	    case IMAGEPATH:
		return monster.getImagePath();
            case HEIGHT:
		return monster.getHeight();
	    case WEIGHT:
		return monster.getWeight();
	    case AGILITY:
		return monster.getAgility();
	    case STRENGTH:
		return monster.getStrength();
	    case STAMINA:
		return monster.getStamina();
            case DANGERLEVEL:
		return monster.getDangerLevel();
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
    
    public void addMonster(MonsterDto monster) {
	monsters.add(monster);
	fireTableDataChanged();
    }
        
    public void removeMonster(MonsterDto monster) {
	monsters.remove(monster);
	fireTableDataChanged();
    }
    
    public void clear() {
	monsters.clear();
        fireTableDataChanged();
    }
    
     public List<MonsterDto> getAllCustomers() {
	return monsters;
    }
    
    @Override 
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	MonsterDto monster = monsters.get(rowIndex);
	switch (COLUMNS.values()[columnIndex]) {
	    case ID:
		monster.setId((Long) aValue);
		break;
	    case MONSTERCLASS:
		monster.setMonsterClass((MonsterClass) aValue);
		break;
	    case NAME:
		monster.setName((String) aValue);
		break;
	    case DESCRIPTION:
		monster.setDescription((String) aValue);
		break;
            case HEIGHT:
		monster.setHeight((Double) aValue);
		break;
            case WEIGHT:
		monster.setWeight((Double) aValue);
		break;
            case AGILITY:
		monster.setAgility((Double) aValue);
		break;
            case STRENGTH:
		monster.setStrength((Double) aValue);
		break;
            case STAMINA:
		monster.setStamina((Double) aValue);
		break;
            case DANGERLEVEL:
		monster.setDangerLevel((Double) aValue);
		break;
            case IMAGEPATH:
		monster.setImagePath((String) aValue);
		break;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
        try {
            client.monsterManagerupdate(monster);
            fireTableDataChanged();
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	switch (COLUMNS.values()[columnIndex]) {
	    case ID:
		return false;
	    case MONSTERCLASS:
            case NAME:
	    case DESCRIPTION:
	    case IMAGEPATH:
            case HEIGHT:
	    case WEIGHT:
	    case AGILITY:
	    case STRENGTH:
	    case STAMINA:
            case DANGERLEVEL:
		return true;
	    default:
		throw new IllegalArgumentException("columnIndex");
	}
    }

}
