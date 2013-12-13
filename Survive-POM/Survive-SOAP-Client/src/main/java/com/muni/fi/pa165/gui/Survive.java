package com.muni.fi.pa165.gui;


import com.muni.fi.pa165.client.SurviveClient;
import com.muni.fi.pa165.ws.MonsterDto;
import com.muni.fi.pa165.ws.MonsterWeaponDto;
import com.muni.fi.pa165.ws.WeaponDto;
import com.muni.fi.pa165.ws.MonsterClass;
import com.muni.fi.pa165.ws.WeaponClass;
import com.muni.fi.pa165.ws.WeaponType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.TableColumn;
//import net.sourceforge.stripes.integration.spring.SpringBean;


/**
 *
 * @author Maria
 */
public class Survive extends javax.swing.JFrame {

    
    private static final Logger LOGGER = Logger.getLogger(Survive.class.getName());
    private String action;
    private Long monsterweapon_monsterid;
    private Long monsterweapon_weaponid;
    
    //@SpringBean
    private SurviveClient client;
    
  
    EfficiencyTableModel monsterweaponTableModel;
    MonsterTableModel monsterTableModel;
    WeaponTableModel weaponTableModel;
    

    private MonsterweaponsSwingWorker monsterweaponsSwingWorker;
    private class MonsterweaponsSwingWorker extends SwingWorker<Void, MonsterWeaponDto> {

	@Override
	protected Void doInBackground() throws Exception {
	    monsterweaponTableModel = (EfficiencyTableModel) efficiencies_table.getModel();
            int counter = 0;
	    for (MonsterWeaponDto monsterweapon : client.monsterweaponManagerfindAll()) {
                counter++;
                Thread.sleep(150);
		publish(monsterweapon);
                setProgress(counter);
	    }
	    return null;
	}
	
	@Override
	protected void process(List<MonsterWeaponDto> items) {
	    for (MonsterWeaponDto i : items) {
                monsterweaponTableModel.addMonsterweapon(i);
	    }
	}

        @Override
        protected void done() {
            efficiencies_load.setEnabled(true);
            efficiencies_progress.setValue(100);
            monsterweaponsSwingWorker = null;
        }
    }
    private MonstersSwingWorker monstersSwingWorker;
    private class MonstersSwingWorker extends SwingWorker<Void, MonsterDto> {

	@Override
	protected Void doInBackground() throws Exception {
	    monsterTableModel = (MonsterTableModel) monsters_table.getModel();
            int counter = 0;
	    for (MonsterDto monster : client.monsterManagerfindAll()) {
                counter++;
                Thread.sleep(50);
		publish(monster);
                setProgress(counter);
	    }
	    return null;
	}
	
	@Override
	protected void process(List<MonsterDto> items) {
	    for (MonsterDto i : items) {
                monsterTableModel.addMonster(i);
	    }
	}

        @Override
        protected void done() {
            monsters_load.setEnabled(true);
            monsters_progress.setValue(100);
            monstersSwingWorker = null;
        }
    }
    private WeaponsSwingWorker weaponsSwingWorker;
    private class WeaponsSwingWorker extends SwingWorker<Void, WeaponDto> {

	@Override
	protected Void doInBackground() throws Exception {
	    weaponTableModel = (WeaponTableModel) weapons_table.getModel();
            int counter = 0;
	    for (WeaponDto weapon : client.weaponManagerfindAll()) {
                counter++;
                Thread.sleep(100);
		publish(weapon);
                setProgress(counter);
	    }
	    return null;
	}
	
	@Override
	protected void process(List<WeaponDto> items) {
	    for (WeaponDto i : items) {
                weaponTableModel.addWeapon(i);
	    }
	}

        @Override
        protected void done() {
            weapons_load.setEnabled(true);
            weapons_progress.setValue(100);
            weaponsSwingWorker = null;
        }
    }
    
    private void setUp() throws Exception {
        
    }

    public Survive() throws MalformedURLException {
        
        try {
            setUp();
        } catch (Exception ex) {
	    String msg = "Application setup failed.";
            LOGGER.log(Level.SEVERE, msg, ex);
        }
          
        
	initComponents();
     
        client = new SurviveClient();
	        
        monsterweaponsSwingWorker = new MonsterweaponsSwingWorker();
        monsterweaponsSwingWorker.addPropertyChangeListener(monsterweaponsProgressListener);
        monsterweaponsSwingWorker.execute();
        
        monstersSwingWorker = new MonstersSwingWorker();
        monstersSwingWorker.addPropertyChangeListener(monstersProgressListener);
        monstersSwingWorker.execute();
        
        weaponsSwingWorker = new WeaponsSwingWorker();
        weaponsSwingWorker.addPropertyChangeListener(weaponsProgressListener);
        weaponsSwingWorker.execute();
    }
    
    /* SwingWorkers Progress Linsteners */
    private PropertyChangeListener monsterweaponsProgressListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("progress")) {
                efficiencies_progress.setValue((Integer) evt.getNewValue());
            }
        }
    };
    
    private PropertyChangeListener monstersProgressListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("progress")) {
                monsters_progress.setValue((Integer) evt.getNewValue());
            }
        }
    };
    
    private PropertyChangeListener weaponsProgressListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("progress")) {
                weapons_progress.setValue((Integer) evt.getNewValue());
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                dialog_efficiencies = new javax.swing.JDialog();
                dialog_efficiencies_monsterLabel = new javax.swing.JLabel();
                dialog_efficiencies_monsterInput = new javax.swing.JTextField();
                dialog_efficiencies_monsterHelper = new javax.swing.JLabel();
                dialog_efficiencies_weaponLabel = new javax.swing.JLabel();
                dialog_efficiencies_weaponInput = new javax.swing.JTextField();
                dialog_efficiencies_weaponHelper = new javax.swing.JLabel();
                dialog_efficiencies_hitRateLabel = new javax.swing.JLabel();
                dialog_efficiencies_hitRateInput = new javax.swing.JTextField();
                dialog_efficiencies_damageLabel = new javax.swing.JLabel();
                dialog_efficiencies_damageInput = new javax.swing.JTextField();
                dialog_efficiencies_efficiencyLabel = new javax.swing.JLabel();
                dialog_efficiencies_efficiencyInput = new javax.swing.JTextField();
                dialog_efficiencies_cancel = new javax.swing.JButton();
                dialog_efficiencies_submit = new javax.swing.JButton();
                dialog_efficiencies_descriptionLabel1 = new javax.swing.JLabel();
                dialog_efficiencies_descriptionInput = new javax.swing.JTextField();
                dialog_monsters = new javax.swing.JDialog();
                dialog_monsters_idLabel = new javax.swing.JLabel();
                dialog_monsters_idInput = new javax.swing.JTextField();
                dialog_monsters_monsterClassLabel = new javax.swing.JLabel();
                dialog_monsters_nameLabel = new javax.swing.JLabel();
                dialog_monsters_nameInput = new javax.swing.JTextField();
                dialog_monsters_heightLabel = new javax.swing.JLabel();
                dialog_monsters_heightInput = new javax.swing.JTextField();
                dialog_monsters_weightLabel = new javax.swing.JLabel();
                dialog_monsters_weightInput = new javax.swing.JTextField();
                dialog_monsters_cancel = new javax.swing.JButton();
                dialog_monsters_submit = new javax.swing.JButton();
                dialog_monsters_agilityLabel = new javax.swing.JLabel();
                dialog_monsters_agilityInput = new javax.swing.JTextField();
                dialog_monsters_strengthLabel = new javax.swing.JLabel();
                dialog_monsters_strengthInput = new javax.swing.JTextField();
                dialog_monsters_staminaLabel = new javax.swing.JLabel();
                dialog_monsters_staminaInput = new javax.swing.JTextField();
                dialog_monsters_dangerLevelLabel = new javax.swing.JLabel();
                dialog_monsters_dangerLevelInput = new javax.swing.JTextField();
                dialog_monsters_imagePathLabel = new javax.swing.JLabel();
                dialog_monsters_imagePathInput = new javax.swing.JTextField();
                dialog_monsters_descriptionLabel = new javax.swing.JLabel();
                dialog_monsters_descriptionInput = new javax.swing.JTextField();
                dialog_monsters_monsterClassInput = new javax.swing.JComboBox();
                dialog_weapons = new javax.swing.JDialog();
                dialog_weapons_idLabel = new javax.swing.JLabel();
                dialog_weapons_idInput = new javax.swing.JTextField();
                dialog_weapons_nameLabel = new javax.swing.JLabel();
                dialog_weapons_nameInput = new javax.swing.JTextField();
                dialog_weapons_weaponTypeLabel = new javax.swing.JLabel();
                dialog_weapons_weaponClassLabel = new javax.swing.JLabel();
                dialog_weapons_submit = new javax.swing.JButton();
                dialog_weapons_cancel = new javax.swing.JButton();
                dialog_weapons_rangeLabel = new javax.swing.JLabel();
                dialog_weapons_rangeInput = new javax.swing.JTextField();
                dialog_weapons_caliberLabel = new javax.swing.JLabel();
                dialog_weapons_caliberInput = new javax.swing.JTextField();
                dialog_weapons_roundsLabel = new javax.swing.JLabel();
                dialog_weapons_roundsInput = new javax.swing.JTextField();
                dialog_weapons_descriptionLabel = new javax.swing.JLabel();
                dialog_weapons_descriptionInput = new javax.swing.JTextField();
                dialog_weapons_weaponTypeInput = new javax.swing.JComboBox();
                dialog_weapons_weaponClassInput = new javax.swing.JComboBox();
                header = new javax.swing.JPanel();
                header_title = new javax.swing.JLabel();
                sample_monster = new javax.swing.JButton();
                sample_weapon = new javax.swing.JButton();
                content = new javax.swing.JPanel();
                efficiencies = new javax.swing.JPanel();
                efficiencies_scroll = new javax.swing.JScrollPane();
                efficiencies_table = new javax.swing.JTable();
                efficiencies_add = new javax.swing.JButton();
                efficiencies_update = new javax.swing.JButton();
                efficiencies_delete = new javax.swing.JButton();
                efficiencies_title = new javax.swing.JLabel();
                efficiencies_load = new javax.swing.JButton();
                efficiencies_progress = new javax.swing.JProgressBar();
                monsters = new javax.swing.JPanel();
                monsters_scroll = new javax.swing.JScrollPane();
                monsters_table = new javax.swing.JTable();
                monsters_add = new javax.swing.JButton();
                monsters_update = new javax.swing.JButton();
                monsters_delete = new javax.swing.JButton();
                monsters_title = new javax.swing.JLabel();
                monsters_use = new javax.swing.JButton();
                monsters_load = new javax.swing.JButton();
                monsters_progress = new javax.swing.JProgressBar();
                weapons = new javax.swing.JPanel();
                weapons_scroll = new javax.swing.JScrollPane();
                weapons_table = new javax.swing.JTable();
                weapons_add = new javax.swing.JButton();
                weapons_update = new javax.swing.JButton();
                weapons_delete = new javax.swing.JButton();
                weapons_title = new javax.swing.JLabel();
                weapons_use = new javax.swing.JButton();
                weapons_load = new javax.swing.JButton();
                weapons_progress = new javax.swing.JProgressBar();

                dialog_efficiencies.setResizable(false);

                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
                dialog_efficiencies_monsterLabel.setText(bundle.getString("Survive.dialog_efficiencies_monsterLabel.text_1")); // NOI18N

                dialog_efficiencies_monsterInput.setEnabled(false);

                dialog_efficiencies_monsterHelper.setText(bundle.getString("Survive.dialog_efficiencies_monsterHelper.text_1")); // NOI18N

                dialog_efficiencies_weaponLabel.setText(bundle.getString("Survive.dialog_efficiencies_weaponLabel.text_1")); // NOI18N

                dialog_efficiencies_weaponInput.setEnabled(false);

                dialog_efficiencies_weaponHelper.setText(bundle.getString("Survive.dialog_efficiencies_weaponHelper.text_1")); // NOI18N

                dialog_efficiencies_hitRateLabel.setText(bundle.getString("Survive.dialog_efficiencies_hitRateLabel.text_1")); // NOI18N

                dialog_efficiencies_hitRateInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_efficiencies_damageLabel.setText(bundle.getString("Survive.dialog_efficiencies_damageLabel.text_1")); // NOI18N

                dialog_efficiencies_damageInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_efficiencies_efficiencyLabel.setText(bundle.getString("Survive.dialog_efficiencies_efficiencyLabel.text_1")); // NOI18N

                dialog_efficiencies_efficiencyInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_efficiencies_cancel.setText(bundle.getString("Survive.dialog_efficiencies_cancel.text_1")); // NOI18N
                dialog_efficiencies_cancel.setActionCommand(bundle.getString("Survive.dialog_efficiencies_cancel.actionCommand")); // NOI18N
                dialog_efficiencies_cancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsterweapons_cancelActionPerformed(evt);
                        }
                });

                dialog_efficiencies_submit.setText(bundle.getString("Survive.dialog_efficiencies_submit.text_1")); // NOI18N
                dialog_efficiencies_submit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsterweapons_submitActionPerformed(evt);
                        }
                });

                dialog_efficiencies_descriptionLabel1.setText(bundle.getString("Survive.dialog_efficiencies_descriptionLabel1.text")); // NOI18N

                dialog_efficiencies_descriptionInput.setPreferredSize(new java.awt.Dimension(200, 28));

                org.jdesktop.layout.GroupLayout dialog_efficienciesLayout = new org.jdesktop.layout.GroupLayout(dialog_efficiencies.getContentPane());
                dialog_efficiencies.getContentPane().setLayout(dialog_efficienciesLayout);
                dialog_efficienciesLayout.setHorizontalGroup(
                        dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                                .add(11, 11, 11)
                                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(dialog_efficiencies_efficiencyLabel)
                                                        .add(dialog_efficiencies_damageLabel)
                                                        .add(dialog_efficiencies_hitRateLabel)
                                                        .add(dialog_efficiencies_weaponLabel)
                                                        .add(dialog_efficiencies_monsterLabel))
                                                .add(12, 12, 12)
                                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                                                .add(dialog_efficiencies_cancel)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                                .add(dialog_efficiencies_submit)
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(dialog_efficiencies_hitRateInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_efficiencies_efficiencyInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_efficiencies_damageInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                                        .add(org.jdesktop.layout.GroupLayout.LEADING, dialog_efficiencies_weaponInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                                        .add(org.jdesktop.layout.GroupLayout.LEADING, dialog_efficiencies_monsterInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(dialog_efficiencies_monsterHelper, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .add(dialog_efficiencies_weaponHelper, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(dialog_efficiencies_descriptionLabel1)
                                                .add(10, 10, 10)
                                                .add(dialog_efficiencies_descriptionInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                dialog_efficienciesLayout.setVerticalGroup(
                        dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                .add(31, 31, 31)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_monsterLabel)
                                        .add(dialog_efficiencies_monsterInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_efficiencies_monsterHelper))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_weaponLabel)
                                        .add(dialog_efficiencies_weaponInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_efficiencies_weaponHelper))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_hitRateInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_efficiencies_hitRateLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_damageInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_efficiencies_damageLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_efficiencyInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_efficiencies_efficiencyLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_efficiencies_descriptionInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(dialog_efficienciesLayout.createSequentialGroup()
                                                .add(26, 26, 26)
                                                .add(dialog_efficiencies_descriptionLabel1)
                                                .add(0, 64, Short.MAX_VALUE)))
                                .add(18, 18, 18)
                                .add(dialog_efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_efficiencies_cancel)
                                        .add(dialog_efficiencies_submit))
                                .add(23, 23, 23))
                );

                dialog_monsters.setResizable(false);

                dialog_monsters_idLabel.setText(bundle.getString("Survive.dialog_monsters_idLabel.text_1")); // NOI18N

                dialog_monsters_idInput.setEnabled(false);
                dialog_monsters_idInput.setPreferredSize(new java.awt.Dimension(200, 28));
                dialog_monsters_idInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_idInputActionPerformed(evt);
                        }
                });

                dialog_monsters_monsterClassLabel.setText(bundle.getString("Survive.dialog_monsters_monsterClassLabel.text_1")); // NOI18N

                dialog_monsters_nameLabel.setText(bundle.getString("Survive.dialog_monsters_nameLabel.text_1")); // NOI18N

                dialog_monsters_nameInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_monsters_heightLabel.setText(bundle.getString("Survive.dialog_monsters_heightLabel.text_1")); // NOI18N

                dialog_monsters_heightInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_monsters_weightLabel.setText(bundle.getString("Survive.dialog_monsters_weightLabel.text_1")); // NOI18N

                dialog_monsters_weightInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_weightInputActionPerformed(evt);
                        }
                });

                dialog_monsters_cancel.setText(bundle.getString("Survive.dialog_monsters_cancel.text_1")); // NOI18N
                dialog_monsters_cancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_cancelActionPerformed(evt);
                        }
                });

                dialog_monsters_submit.setText(bundle.getString("Survive.dialog_monsters_submit.text_1")); // NOI18N
                dialog_monsters_submit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_submitActionPerformed(evt);
                        }
                });

                dialog_monsters_agilityLabel.setText(bundle.getString("Survive.dialog_monsters_agilityLabel.text")); // NOI18N

                dialog_monsters_agilityInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_agilityInputActionPerformed(evt);
                        }
                });

                dialog_monsters_strengthLabel.setText(bundle.getString("Survive.dialog_monsters_strengthLabel.text")); // NOI18N

                dialog_monsters_strengthInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_strengthInputActionPerformed(evt);
                        }
                });

                dialog_monsters_staminaLabel.setText(bundle.getString("Survive.dialog_monsters_staminaLabel.text")); // NOI18N

                dialog_monsters_staminaInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_staminaInputActionPerformed(evt);
                        }
                });

                dialog_monsters_dangerLevelLabel.setText(bundle.getString("Survive.dialog_monsters_dangerLevelLabel.text")); // NOI18N

                dialog_monsters_dangerLevelInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_dangerLevelInputActionPerformed(evt);
                        }
                });

                dialog_monsters_imagePathLabel.setText(bundle.getString("Survive.dialog_monsters_imagePathLabel.text")); // NOI18N

                dialog_monsters_imagePathInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_imagePathInputActionPerformed(evt);
                        }
                });

                dialog_monsters_descriptionLabel.setText(bundle.getString("Survive.dialog_monsters_descriptionLabel.text")); // NOI18N

                dialog_monsters_descriptionInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_monsters_descriptionInputActionPerformed(evt);
                        }
                });

                dialog_monsters_monsterClassInput.setModel(new javax.swing.DefaultComboBoxModel(MonsterClass.values()));

                org.jdesktop.layout.GroupLayout dialog_monstersLayout = new org.jdesktop.layout.GroupLayout(dialog_monsters.getContentPane());
                dialog_monsters.getContentPane().setLayout(dialog_monstersLayout);
                dialog_monstersLayout.setHorizontalGroup(
                        dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_monstersLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                .add(0, 0, Short.MAX_VALUE)
                                                .add(dialog_monsters_submit)
                                                .add(18, 18, 18)
                                                .add(dialog_monsters_cancel))
                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_monsterClassLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_idLabel)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_nameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_heightLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_weightLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_strengthLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_dangerLevelLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_agilityLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_staminaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_monsters_imagePathLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_descriptionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(dialog_monsters_descriptionInput)
                                                        .add(dialog_monsters_imagePathInput)
                                                        .add(dialog_monsters_dangerLevelInput)
                                                        .add(dialog_monsters_staminaInput)
                                                        .add(dialog_monsters_agilityInput)
                                                        .add(dialog_monsters_nameInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                                        .add(dialog_monsters_heightInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_monsters_weightInput)
                                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                                .add(dialog_monsters_idInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_monsters_strengthInput)
                                                        .add(dialog_monsters_monsterClassInput, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
                );
                dialog_monstersLayout.setVerticalGroup(
                        dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_monstersLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_idLabel)
                                        .add(dialog_monsters_idInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_monsterClassLabel)
                                        .add(dialog_monsters_monsterClassInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_nameLabel)
                                        .add(dialog_monsters_nameInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_heightLabel)
                                        .add(dialog_monsters_heightInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_weightInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_weightLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_agilityInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_agilityLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_strengthInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_strengthLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_staminaInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_staminaLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_dangerLevelInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_dangerLevelLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_monsters_imagePathInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(dialog_monsters_imagePathLabel))
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(dialog_monsters_descriptionInput)
                                                .add(18, 18, 18))
                                        .add(dialog_monstersLayout.createSequentialGroup()
                                                .add(32, 32, 32)
                                                .add(dialog_monsters_descriptionLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 122, Short.MAX_VALUE)))
                                .add(dialog_monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_monsters_cancel)
                                        .add(dialog_monsters_submit))
                                .addContainerGap())
                );

                dialog_weapons.setResizable(false);

                dialog_weapons_idLabel.setText(bundle.getString("Survive.dialog_weapons_idLabel.text_1")); // NOI18N

                dialog_weapons_idInput.setEnabled(false);
                dialog_weapons_idInput.setPreferredSize(new java.awt.Dimension(200, 28));
                dialog_weapons_idInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_weapons_idInputActionPerformed(evt);
                        }
                });

                dialog_weapons_nameLabel.setText(bundle.getString("Survive.dialog_weapons_nameLabel.text_1")); // NOI18N

                dialog_weapons_nameInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_weapons_weaponTypeLabel.setText(bundle.getString("Survive.dialog_weapons_weaponTypeLabel.text_1")); // NOI18N

                dialog_weapons_weaponClassLabel.setText(bundle.getString("Survive.dialog_weapons_weaponClassLabel.text_1")); // NOI18N

                dialog_weapons_submit.setText(bundle.getString("Survive.dialog_weapons_submit.text_1")); // NOI18N
                dialog_weapons_submit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_weapons_submitActionPerformed(evt);
                        }
                });

                dialog_weapons_cancel.setText(bundle.getString("Survive.dialog_weapons_cancel.text_1")); // NOI18N
                dialog_weapons_cancel.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dialog_weapons_cancelActionPerformed(evt);
                        }
                });

                dialog_weapons_rangeLabel.setText(bundle.getString("Survive.dialog_weapons_rangeLabel.text")); // NOI18N

                dialog_weapons_rangeInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_weapons_caliberLabel.setText(bundle.getString("Survive.dialog_weapons_caliberLabel.text")); // NOI18N

                dialog_weapons_caliberInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_weapons_roundsLabel.setText(bundle.getString("Survive.dialog_weapons_roundsLabel.text")); // NOI18N

                dialog_weapons_roundsInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_weapons_descriptionLabel.setText(bundle.getString("Survive.dialog_weapons_descriptionLabel.text")); // NOI18N

                dialog_weapons_descriptionInput.setPreferredSize(new java.awt.Dimension(200, 28));

                dialog_weapons_weaponTypeInput.setModel(new javax.swing.DefaultComboBoxModel(WeaponType.values()));

                dialog_weapons_weaponClassInput.setModel(new javax.swing.DefaultComboBoxModel(WeaponClass.values()));

                org.jdesktop.layout.GroupLayout dialog_weaponsLayout = new org.jdesktop.layout.GroupLayout(dialog_weapons.getContentPane());
                dialog_weapons.getContentPane().setLayout(dialog_weaponsLayout);
                dialog_weaponsLayout.setHorizontalGroup(
                        dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_weaponsLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_weaponsLayout.createSequentialGroup()
                                                .add(dialog_weapons_descriptionLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_weapons_descriptionInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(dialog_weaponsLayout.createSequentialGroup()
                                                .add(dialog_weapons_caliberLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_weapons_caliberInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weaponsLayout.createSequentialGroup()
                                                .add(0, 0, Short.MAX_VALUE)
                                                .add(dialog_weapons_cancel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_weapons_submit))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weaponsLayout.createSequentialGroup()
                                                .add(dialog_weapons_roundsLabel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_weapons_roundsInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                                        .add(dialog_weaponsLayout.createSequentialGroup()
                                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(dialog_weapons_rangeLabel)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weapons_weaponClassLabel)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weapons_weaponTypeLabel)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weapons_nameLabel)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weapons_idLabel))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(dialog_weapons_rangeInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .add(dialog_weapons_nameInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                                        .add(dialog_weaponsLayout.createSequentialGroup()
                                                                .add(dialog_weapons_idInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(0, 0, Short.MAX_VALUE))
                                                        .add(dialog_weapons_weaponTypeInput, 0, 314, Short.MAX_VALUE)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, dialog_weapons_weaponClassInput, 0, 314, Short.MAX_VALUE))))
                                .addContainerGap())
                );
                dialog_weaponsLayout.setVerticalGroup(
                        dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(dialog_weaponsLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_idLabel)
                                        .add(dialog_weapons_idInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_nameLabel)
                                        .add(dialog_weapons_nameInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_weapons_weaponTypeLabel)
                                        .add(dialog_weapons_weaponTypeInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_weaponClassLabel)
                                        .add(dialog_weapons_weaponClassInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_rangeLabel)
                                        .add(dialog_weapons_rangeInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_caliberLabel)
                                        .add(dialog_weapons_caliberInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_roundsLabel)
                                        .add(dialog_weapons_roundsInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(dialog_weaponsLayout.createSequentialGroup()
                                                .add(dialog_weapons_descriptionLabel)
                                                .add(0, 0, Short.MAX_VALUE))
                                        .add(dialog_weapons_descriptionInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .add(18, 18, 18)
                                .add(dialog_weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(dialog_weapons_submit)
                                        .add(dialog_weapons_cancel))
                                .addContainerGap())
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("com/muni/fi/pa165/gui/Bundle"); // NOI18N
                setTitle(bundle1.getString("Survive.title")); // NOI18N

                header.setPreferredSize(new java.awt.Dimension(1085, 40));

                header_title.setFont(header_title.getFont().deriveFont(header_title.getFont().getStyle() | java.awt.Font.BOLD, header_title.getFont().getSize()+12));
                header_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                header_title.setText(bundle.getString("Survive.header_title.text")); // NOI18N

                sample_monster.setText(bundle.getString("Survive.sample_monster.text_1")); // NOI18N
                sample_monster.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                sample_monsterActionPerformed(evt);
                        }
                });

                sample_weapon.setText(bundle.getString("Survive.sample_weapon.text_1")); // NOI18N
                sample_weapon.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                sample_weaponActionPerformed(evt);
                        }
                });

                org.jdesktop.layout.GroupLayout headerLayout = new org.jdesktop.layout.GroupLayout(header);
                header.setLayout(headerLayout);
                headerLayout.setHorizontalGroup(
                        headerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(headerLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(header_title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(sample_monster)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(sample_weapon)
                                .addContainerGap())
                );
                headerLayout.setVerticalGroup(
                        headerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(headerLayout.createSequentialGroup()
                                .add(headerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(sample_monster)
                                        .add(sample_weapon))
                                .add(0, 0, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, headerLayout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(header_title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(26, 26, 26))
                );

                getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

                efficiencies_table.setModel(new EfficiencyTableModel());
                efficiencies_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TableColumn efficiencies_col_monsterid = efficiencies_table.getColumnModel().getColumn(0);
                efficiencies_col_monsterid.setPreferredWidth(100);
                efficiencies_col_monsterid.setMaxWidth(100);
                TableColumn efficiencies_col_monster = efficiencies_table.getColumnModel().getColumn(1);
                efficiencies_col_monster.setPreferredWidth(100);
                efficiencies_col_monster.setMaxWidth(100);
                TableColumn efficiencies_col_weaponid = efficiencies_table.getColumnModel().getColumn(2);
                efficiencies_col_weaponid.setPreferredWidth(100);
                efficiencies_col_weaponid.setMaxWidth(100);
                TableColumn efficiencies_col_weapon = efficiencies_table.getColumnModel().getColumn(3);
                efficiencies_col_weapon.setPreferredWidth(100);
                //efficiencies_col_weapon.setMaxWidth(50);
                TableColumn efficiencies_col_from = efficiencies_table.getColumnModel().getColumn(4);
                efficiencies_col_from.setPreferredWidth(100);
                //efficiencies_col_from.setMaxWidth(50);
                TableColumn efficiencies_col_to = efficiencies_table.getColumnModel().getColumn(5);
                efficiencies_scroll.setViewportView(efficiencies_table);

                efficiencies_add.setText(bundle.getString("Survive.efficiencies_add.text_1")); // NOI18N
                efficiencies_add.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsterweapons_addActionPerformed(evt);
                        }
                });

                efficiencies_update.setText(bundle.getString("Survive.efficiencies_update.text_1")); // NOI18N
                efficiencies_update.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsterweapons_updateActionPerformed(evt);
                        }
                });

                efficiencies_delete.setText(bundle.getString("Survive.efficiencies_delete.text_1")); // NOI18N
                efficiencies_delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsterweapons_deleteActionPerformed(evt);
                        }
                });

                efficiencies_title.setFont(efficiencies_title.getFont().deriveFont(efficiencies_title.getFont().getStyle() | java.awt.Font.BOLD, efficiencies_title.getFont().getSize()+6));
                efficiencies_title.setText(bundle.getString("Survive.efficiencies_title.text_1")); // NOI18N

                efficiencies_load.setText(bundle.getString("Survive.efficiencies_load.text_1")); // NOI18N
                efficiencies_load.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                efficiencies_loadActionPerformed(evt);
                        }
                });

                org.jdesktop.layout.GroupLayout efficienciesLayout = new org.jdesktop.layout.GroupLayout(efficiencies);
                efficiencies.setLayout(efficienciesLayout);
                efficienciesLayout.setHorizontalGroup(
                        efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, efficienciesLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(efficiencies_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1002, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, efficiencies_add, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, efficiencies_update, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, efficiencies_delete, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, efficiencies_load, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, efficiencies_progress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .add(efficiencies_title))
                                .add(0, 0, Short.MAX_VALUE))
                );
                efficienciesLayout.setVerticalGroup(
                        efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(efficienciesLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(efficienciesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(efficienciesLayout.createSequentialGroup()
                                                .add(efficiencies_title)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                .add(efficiencies_add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(efficiencies_update)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(efficiencies_delete)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(efficiencies_load)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(efficiencies_progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(efficiencies_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
                );

                monsters_table.setModel(new MonsterTableModel());
                monsters_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TableColumn monsters_col_id = monsters_table.getColumnModel().getColumn(0);
                monsters_col_id.setMaxWidth(40);
                TableColumn monsters_col_firstname = monsters_table.getColumnModel().getColumn(1);
                TableColumn monsters_col_lastname = monsters_table.getColumnModel().getColumn(2);
                TableColumn monsters_col_birth = monsters_table.getColumnModel().getColumn(3);
                monsters_col_birth.setPreferredWidth(100);
                monsters_col_birth.setMaxWidth(100);
                TableColumn monsters_col_email = monsters_table.getColumnModel().getColumn(4);
                monsters_scroll.setViewportView(monsters_table);

                monsters_add.setText(bundle.getString("Survive.monsters_add.text_1")); // NOI18N
                monsters_add.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsters_addActionPerformed(evt);
                        }
                });

                monsters_update.setText(bundle.getString("Survive.monsters_update.text_1")); // NOI18N
                monsters_update.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsters_updateActionPerformed(evt);
                        }
                });

                monsters_delete.setText(bundle.getString("Survive.monsters_delete.text_1")); // NOI18N
                monsters_delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsters_deleteActionPerformed(evt);
                        }
                });

                monsters_title.setFont(monsters_title.getFont().deriveFont(monsters_title.getFont().getStyle() | java.awt.Font.BOLD, monsters_title.getFont().getSize()+6));
                monsters_title.setText(bundle.getString("Survive.monsters_title.text_1")); // NOI18N

                monsters_use.setText(bundle.getString("Survive.monsters_use.text_1")); // NOI18N
                monsters_use.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsters_useActionPerformed(evt);
                        }
                });

                monsters_load.setText(bundle.getString("Survive.monsters_load.text_1")); // NOI18N
                monsters_load.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monsters_loadActionPerformed(evt);
                        }
                });

                org.jdesktop.layout.GroupLayout monstersLayout = new org.jdesktop.layout.GroupLayout(monsters);
                monsters.setLayout(monstersLayout);
                monstersLayout.setHorizontalGroup(
                        monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monstersLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(monsters_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1004, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_load, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_use, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_delete, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_update, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_add, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(monsters_progress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, monsters_title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(26, 26, 26))
                );
                monstersLayout.setVerticalGroup(
                        monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(monstersLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(monstersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(monstersLayout.createSequentialGroup()
                                                .add(monsters_title)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(monsters_add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(monsters_update)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(monsters_delete)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(monsters_use)
                                                .add(18, 45, Short.MAX_VALUE)
                                                .add(monsters_load)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(monsters_progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(monsters_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
                );

                weapons_table.setModel(new WeaponTableModel());
                weapons_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
                TableColumn weapons_col_id = weapons_table.getColumnModel().getColumn(0);
                weapons_col_id.setMaxWidth(40);
                TableColumn weapons_col_model = weapons_table.getColumnModel().getColumn(1);
                TableColumn weapons_col_plate = weapons_table.getColumnModel().getColumn(2);
                weapons_col_plate.setMaxWidth(120);
                TableColumn weapons_col_fee = weapons_table.getColumnModel().getColumn(3);
                weapons_col_fee.setMaxWidth(100);
                weapons_scroll.setViewportView(weapons_table);

                weapons_add.setText(bundle.getString("Survive.weapons_add.text_1")); // NOI18N
                weapons_add.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weapons_addActionPerformed(evt);
                        }
                });

                weapons_update.setText(bundle.getString("Survive.weapons_update.text_1")); // NOI18N
                weapons_update.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weapons_updateActionPerformed(evt);
                        }
                });

                weapons_delete.setText(bundle.getString("Survive.weapons_delete.text_1")); // NOI18N
                weapons_delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weapons_deleteActionPerformed(evt);
                        }
                });

                weapons_title.setFont(weapons_title.getFont().deriveFont(weapons_title.getFont().getStyle() | java.awt.Font.BOLD, weapons_title.getFont().getSize()+6));
                weapons_title.setText(bundle.getString("Survive.weapons_title.text_1")); // NOI18N

                weapons_use.setText(bundle.getString("Survive.weapons_use.text_1")); // NOI18N
                weapons_use.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weapons_useActionPerformed(evt);
                        }
                });

                weapons_load.setText(bundle.getString("Survive.weapons_load.text_1")); // NOI18N
                weapons_load.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weapons_loadActionPerformed(evt);
                        }
                });

                org.jdesktop.layout.GroupLayout weaponsLayout = new org.jdesktop.layout.GroupLayout(weapons);
                weapons.setLayout(weaponsLayout);
                weaponsLayout.setHorizontalGroup(
                        weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weaponsLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(weapons_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1000, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(27, 27, 27)
                                .add(weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(weapons_progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_add, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_update, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_delete, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_use, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, weapons_load, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                weaponsLayout.setVerticalGroup(
                        weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(weaponsLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(weaponsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(weaponsLayout.createSequentialGroup()
                                                .add(weapons_title)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(weapons_add)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(weapons_update)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(weapons_delete)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(weapons_use)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(weapons_load)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(weapons_progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(weapons_scroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
                );

                org.jdesktop.layout.GroupLayout contentLayout = new org.jdesktop.layout.GroupLayout(content);
                content.setLayout(contentLayout);
                contentLayout.setHorizontalGroup(
                        contentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(contentLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(contentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(weapons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(monsters, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(efficiencies, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                contentLayout.setVerticalGroup(
                        contentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(contentLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(efficiencies, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(monsters, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(weapons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                getContentPane().add(content, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void dialog_weapons_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_weapons_cancelActionPerformed
	dialog_weapons.setVisible(false);
    }//GEN-LAST:event_dialog_weapons_cancelActionPerformed

    private void dialog_weapons_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_weapons_submitActionPerformed
        WeaponDto weapon = new WeaponDto();
          
	weapon.setName(dialog_weapons_nameInput.getText());
        weapon.setDescription(dialog_weapons_descriptionInput.getText());
        
        weapon.setWeaponType((WeaponType) dialog_weapons_weaponTypeInput.getSelectedItem());
        weapon.setWeaponClass((WeaponClass) dialog_weapons_weaponClassInput.getSelectedItem());
        
        try {
            weapon.setRange(Integer.parseInt(dialog_weapons_rangeInput.getText()));
            weapon.setCaliber(Double.parseDouble(dialog_weapons_caliberInput.getText()));
            weapon.setRounds(Integer.parseInt(dialog_weapons_roundsInput.getText()));
            
        } catch(NumberFormatException e) {
            String msg = "Weapon range,caliber or rounds are in wrong format";
            LOGGER.log(Level.INFO, msg);
        }
        
        try {
            /* Weapon ID */
            if (dialog_weapons_idInput.getText().equals("")) { // Add
                LOGGER.log(Level.INFO, "Adding weapon");
                client.weaponManagersave(weapon);
                weaponTableModel.addWeapon(weapon);
            } else { // Update
                LOGGER.log(Level.INFO, "Updating weapon");
                Long weaponId = Long.valueOf(dialog_weapons_idInput.getText());
                weapon.setId(weaponId);
                WeaponDto weaponCached = client.weaponManagerfindById(weaponId);
                client.weaponManagerupdate(weapon);
                weaponTableModel.removeWeapon(weaponCached);
                weaponTableModel.addWeapon(weapon);
            }
            dialog_weapons.setVisible(false);
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
    }//GEN-LAST:event_dialog_weapons_submitActionPerformed

    private void monsterweapons_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterweapons_addActionPerformed
        
        dialog_efficiencies_monsterInput.setText("");
        dialog_efficiencies_monsterHelper.setText(java.util.ResourceBundle.getBundle("Bundle").getString("Survive.dialog_efficiencies_monsterHelper.text_1"));
        dialog_efficiencies_weaponInput.setText("");
        dialog_efficiencies_weaponHelper.setText(java.util.ResourceBundle.getBundle("Bundle").getString("Survive.dialog_efficiencies_weaponHelper.text_1"));
        dialog_efficiencies_hitRateInput.setText("");
        dialog_efficiencies_damageInput.setText("");
        dialog_efficiencies_efficiencyInput.setText("");
        dialog_efficiencies_descriptionInput.setText("");
        dialog_efficiencies.pack();
        dialog_efficiencies.setLocationRelativeTo(null);
        dialog_efficiencies.setVisible(true);
    }//GEN-LAST:event_monsterweapons_addActionPerformed

    private void monsters_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsters_addActionPerformed
        dialog_monsters_idInput.setText("");
        dialog_monsters_nameInput.setText("");
        dialog_monsters_descriptionInput.setText("");
        dialog_monsters_heightInput.setText("");
        dialog_monsters_weightInput.setText("");
        dialog_monsters_agilityInput.setText("");
        dialog_monsters_strengthInput.setText("");
        dialog_monsters_staminaInput.setText("");
        dialog_monsters_dangerLevelInput.setText("");
        dialog_monsters_imagePathInput.setText("");
        dialog_monsters.pack();
        dialog_monsters.setLocationRelativeTo(null);
        dialog_monsters.setVisible(true);
    }//GEN-LAST:event_monsters_addActionPerformed

    private void weapons_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weapons_addActionPerformed
        dialog_weapons_idInput.setText("");
        dialog_weapons_nameInput.setText("");
//        dialog_weapons_weaponClassInput.setText("");
//        dialog_weapons_weaponTypeInput.setText("");
        dialog_weapons_rangeInput.setText("");
        dialog_weapons_caliberInput.setText("");
        dialog_weapons_roundsInput.setText("");
        dialog_weapons_descriptionInput.setText("");
        dialog_weapons.pack();
        dialog_weapons.setLocationRelativeTo(null);
        dialog_weapons.setVisible(true);
    }//GEN-LAST:event_weapons_addActionPerformed

    private void weapons_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weapons_updateActionPerformed
	action = "update";
        
        Long weapon_id = null;
        try {
            weapon_id = (Long) weaponTableModel.getValueAt(weapons_table.getSelectedRow(), 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
        
        WeaponDto weapon = client.weaponManagerfindById(weapon_id);
        
        dialog_weapons_idInput.setText(String.valueOf(weapon.getId()));
        dialog_weapons_nameInput.setText(weapon.getName());
        dialog_weapons_weaponClassInput.setSelectedItem(weapon.getWeaponClass());
        dialog_weapons_weaponTypeInput.setSelectedItem(weapon.getWeaponType());
        dialog_weapons_rangeInput.setText(String.valueOf(weapon.getRange()));
        dialog_weapons_caliberInput.setText(String.valueOf(weapon.getCaliber()));
        dialog_weapons_roundsInput.setText(String.valueOf(weapon.getRounds()));
        dialog_weapons_descriptionInput.setText(weapon.getDescription());          
		
        dialog_weapons.pack();
        dialog_weapons.setLocationRelativeTo(null);
        dialog_weapons.setVisible(true);
    }//GEN-LAST:event_weapons_updateActionPerformed

    private void dialog_weapons_idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_weapons_idInputActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_dialog_weapons_idInputActionPerformed

    private void dialog_monsters_idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_idInputActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_idInputActionPerformed

    private void dialog_monsters_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_submitActionPerformed
        MonsterDto monster = new MonsterDto();
       	monster.setName(dialog_monsters_nameInput.getText());
      	monster.setDescription(dialog_monsters_descriptionInput.getText());
    	monster.setImagePath(dialog_monsters_imagePathInput.getText());
               
       try {
            if (!(dialog_monsters_heightInput.getText()).equals("")) {monster.setHeight(Double.parseDouble(dialog_monsters_heightInput.getText()));}
            if (!(dialog_monsters_agilityInput.getText()).equals("")){ monster.setAgility(Double.parseDouble(dialog_monsters_agilityInput.getText()));}
            if (!(dialog_monsters_strengthInput.getText()).equals("")) {monster.setStrength(Double.parseDouble(dialog_monsters_strengthInput.getText()));}
            if (!(dialog_monsters_weightInput.getText()).equals("")) {monster.setWeight(Double.parseDouble(dialog_monsters_weightInput.getText()));}
            if (!(dialog_monsters_staminaInput.getText()).equals("")) {monster.setStamina(Double.parseDouble(dialog_monsters_staminaInput.getText()));}
            if (!(dialog_monsters_dangerLevelInput.getText()).equals("")) { monster.setDangerLevel(Double.parseDouble(dialog_monsters_dangerLevelInput.getText()));}
   
        } catch(IllegalArgumentException e) {
            String msg = "Monster data wrong format";
            LOGGER.log(Level.SEVERE, msg);
            JOptionPane.showMessageDialog(new JFrame(),msg, "Dialog",JOptionPane.ERROR_MESSAGE);
            
        }
        try {
            /* Monster ID */
            if (dialog_monsters_idInput.getText().equals("")) { // Add
                LOGGER.log(Level.INFO, "Adding monster");
                client.monsterManagersave(monster);
                monsterTableModel.addMonster(monster);
            } else { // Update
                LOGGER.log(Level.INFO, "Updating monster");
                Long monsterId = Long.valueOf(dialog_monsters_idInput.getText());
                monster.setId(monsterId);
                MonsterDto monsterCached = client.monsterManagerfindById(monsterId);
                client.monsterManagerupdate(monster);
                monsterTableModel.removeMonster(monsterCached);
                monsterTableModel.addMonster(monster);
                
            }
            dialog_monsters.setVisible(false);
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
         
    }//GEN-LAST:event_dialog_monsters_submitActionPerformed

    private void dialog_monsters_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_cancelActionPerformed
	dialog_monsters.setVisible(false);
    }//GEN-LAST:event_dialog_monsters_cancelActionPerformed

    private void dialog_monsterweapons_idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsterweapons_idInputActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsterweapons_idInputActionPerformed

    private void dialog_monsterweapons_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsterweapons_submitActionPerformed
	MonsterWeaponDto monsterweapon = new MonsterWeaponDto();
        monsterweapon.setMonster(client.monsterManagerfindById(Long.parseLong(dialog_efficiencies_monsterInput.getText())));
        monsterweapon.setWeapon(client.weaponManagerfindById(Long.parseLong(dialog_efficiencies_weaponInput.getText())));
        monsterweapon.setDescription(dialog_efficiencies_descriptionInput.getText());
        try {
            monsterweapon.setHitRate(Integer.valueOf(dialog_efficiencies_hitRateInput.getText()));
            monsterweapon.setDamage(Integer.valueOf(dialog_efficiencies_damageInput.getText()));
            monsterweapon.setEfficiency(Integer.valueOf(dialog_efficiencies_efficiencyInput.getText()));
        } catch (IllegalArgumentException ex) {
            String msg = "Monster-weapon hit rate, damage or efficiency are in wrong format";
            LOGGER.log(Level.SEVERE, msg);
        }
   
        try {
            /* Monsterweapon ID */
            if (client.monsterweaponManagerfindById(monsterweapon.getMonster().getId(), monsterweapon.getWeapon().getId()).equals(null)) { // Add
                LOGGER.log(Level.INFO, "Adding monster-weapon");
                client.monsterweaponManagersave(monsterweapon);
                monsterweaponTableModel.addMonsterweapon(monsterweapon);
            } else { // Update
                LOGGER.log(Level.INFO, "Updating monster-weapon");
                client.monsterweaponManagerupdate(monsterweapon);
                monsterweaponTableModel.addMonsterweapon(monsterweapon);
            }
            dialog_efficiencies.setVisible(false);
        } catch (Exception ex) {
            String msg = "User request failed";
            LOGGER.log(Level.INFO, msg);
        }
    }//GEN-LAST:event_dialog_monsterweapons_submitActionPerformed

    private void dialog_monsterweapons_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsterweapons_cancelActionPerformed
	dialog_efficiencies.setVisible(false);
    }//GEN-LAST:event_dialog_monsterweapons_cancelActionPerformed

    private void dialog_monsterweapons_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsterweapons_calculateActionPerformed
	        
    }//GEN-LAST:event_dialog_monsterweapons_calculateActionPerformed

    private void dialog_monsters_weightInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_weightInputActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_weightInputActionPerformed

    private void monsterweapons_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterweapons_updateActionPerformed

        Long monsterweapon_monsterid = (Long) monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 0);
        Long monsterweapon_weaponid = (Long) monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 1);
        MonsterWeaponDto monsterweapon = client.monsterweaponManagerfindById(monsterweapon_monsterid, monsterweapon_weaponid);
      
        dialog_efficiencies_monsterInput.setText(String.valueOf(monsterweapon.getMonster().getId()));
        dialog_efficiencies_monsterHelper.setText(String.valueOf(monsterweapon.getMonster().toString()));
        
        dialog_efficiencies_weaponInput.setText(String.valueOf(monsterweapon.getWeapon().getId()));
        dialog_efficiencies_weaponHelper.setText(String.valueOf(monsterweapon.getWeapon().toString()));
        
        dialog_efficiencies_hitRateInput.setText(String.valueOf(monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 2)));
        dialog_efficiencies_damageInput.setText(String.valueOf(monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 3)));
        dialog_efficiencies_efficiencyInput.setText(String.valueOf(monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 4)));
        dialog_efficiencies_descriptionInput.setText(String.valueOf(monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 5)));
        
        dialog_efficiencies.pack();
        dialog_efficiencies.setLocationRelativeTo(null);
        dialog_efficiencies.setVisible(true);
    }//GEN-LAST:event_monsterweapons_updateActionPerformed

    private void monsters_useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsters_useActionPerformed
        Long id = (Long) monsterTableModel.getValueAt(monsters_table.getSelectedRow(), 0);
        MonsterDto c = client.monsterManagerfindById(id); 
        dialog_efficiencies_monsterInput.setText(String.valueOf(id));
        dialog_efficiencies_monsterHelper.setText(String.valueOf(c.toString()));
    }//GEN-LAST:event_monsters_useActionPerformed

    private void weapons_useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weapons_useActionPerformed
        Long id = (Long) weaponTableModel.getValueAt(weapons_table.getSelectedRow(), 0);
        WeaponDto c = client.weaponManagerfindById(id); 
        dialog_efficiencies_weaponInput.setText(String.valueOf(c.getId()));
        dialog_efficiencies_weaponHelper.setText(String.valueOf(c.toString()));
    }//GEN-LAST:event_weapons_useActionPerformed

    private void efficiencies_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterweapons_loadActionPerformed
        if (monsterweaponsSwingWorker != null) {
            throw new IllegalStateException("Operation is already in progress");
        }
        efficiencies_load.setEnabled(false);
        efficiencies_progress.setValue(0);
        monsterweaponTableModel.clear();
        monsterweaponsSwingWorker = new MonsterweaponsSwingWorker();
        monsterweaponsSwingWorker.addPropertyChangeListener(monsterweaponsProgressListener);
        monsterweaponsSwingWorker.execute();
    }//GEN-LAST:event_monsterweapons_loadActionPerformed

    private void monsters_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsters_loadActionPerformed
        if (monstersSwingWorker != null) {
            throw new IllegalStateException("Operation is already in progress");
        }
        monsters_load.setEnabled(false);
        monsters_progress.setValue(0);
        monsterTableModel.clear();
        monstersSwingWorker = new MonstersSwingWorker();
        monstersSwingWorker.addPropertyChangeListener(monstersProgressListener);
        monstersSwingWorker.execute();
    }//GEN-LAST:event_monsters_loadActionPerformed

    private void weapons_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weapons_loadActionPerformed
        if (weaponsSwingWorker != null) {
            throw new IllegalStateException("Operation is already in progress");
        }
        weapons_load.setEnabled(false);
        weapons_progress.setValue(0);
        weaponTableModel.clear();
        weaponsSwingWorker = new WeaponsSwingWorker();
        weaponsSwingWorker.addPropertyChangeListener(weaponsProgressListener);
        weaponsSwingWorker.execute();
    }//GEN-LAST:event_weapons_loadActionPerformed

    private void weapons_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weapons_deleteActionPerformed
        Long weapon_id = null;
        try {
            weapon_id = (Long) weaponTableModel.getValueAt(weapons_table.getSelectedRow(), 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            String msg = "No row selected";
            LOGGER.log(Level.INFO, msg);
        }
        
        WeaponDto weapon = client.weaponManagerfindById(weapon_id);
        try {
            for (MonsterWeaponDto monsterweapon : client.monsterweaponManagerfindByWeaponId(weapon_id)) {
                client.monsterweaponManagerdelete(monsterweapon.getMonster().getId(), weapon_id);
                monsterweaponTableModel.removeMonsterweapon(monsterweapon);
	    }
            client.weaponManagerdelete(weapon);
            weaponTableModel.removeWeapon(weapon);
        } catch (Exception ex) {
            String msg = "Deleting failed";
            LOGGER.log(Level.INFO, msg);
        }
    }//GEN-LAST:event_weapons_deleteActionPerformed

    private void monsters_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsters_updateActionPerformed
        Long monster_id = (Long) monsterTableModel.getValueAt(monsters_table.getSelectedRow(), 0);
        MonsterDto monster = client.monsterManagerfindById(monster_id);
        dialog_monsters_idInput.setText(String.valueOf(monster.getId()));
        
        dialog_monsters_nameInput.setText(String.valueOf(monster.getName()));
        dialog_monsters_monsterClassInput.setSelectedItem(monster.getMonsterClass());
        dialog_monsters_descriptionInput.setText(monster.getDescription());
        dialog_monsters_heightInput.setText(String.valueOf(monster.getHeight()));
        dialog_monsters_weightInput.setText(String.valueOf(monster.getWeight()));
        dialog_monsters_agilityInput.setText(String.valueOf(monster.getAgility()));
        dialog_monsters_strengthInput.setText(String.valueOf(monster.getStrength()));
        dialog_monsters_staminaInput.setText(String.valueOf(monster.getStamina()));
        dialog_monsters_dangerLevelInput.setText(String.valueOf(monster.getDangerLevel()));
        dialog_monsters_imagePathInput.setText(String.valueOf(monster.getImagePath()));
        
        
        dialog_monsters.pack();
        dialog_monsters.setLocationRelativeTo(null);
        dialog_monsters.setVisible(true);
    }//GEN-LAST:event_monsters_updateActionPerformed

    private void monsters_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsters_deleteActionPerformed
        Long monster_id = null;
        try {
            monster_id = (Long) monsterTableModel.getValueAt(monsters_table.getSelectedRow(), 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            String msg = "No row selected";
            LOGGER.log(Level.INFO, msg);
        }
        
        MonsterDto monster = client.monsterManagerfindById(monster_id);
        try {
            for (MonsterWeaponDto monsterweapon : client.monsterweaponManagerfindByMonsterId(monster_id)) {
                client.monsterweaponManagerdelete(monster_id, monsterweapon.getWeapon().getId());
                monsterweaponTableModel.removeMonsterweapon(monsterweapon);
	    }
            client.monsterManagerdelete(monster);
            monsterTableModel.removeMonster(monster);
        } catch (Exception ex) {
            String msg = "Deleting failed";
            LOGGER.log(Level.INFO, msg);
        }
    }//GEN-LAST:event_monsters_deleteActionPerformed

    private void monsterweapons_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterweapons_deleteActionPerformed
        
        try {
            monsterweapon_monsterid = (Long) monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 0);
            monsterweapon_weaponid = (Long) monsterweaponTableModel.getValueAt(efficiencies_table.getSelectedRow(), 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            String msg = "No row selected";
            LOGGER.log(Level.INFO, msg);
        }
        
        MonsterWeaponDto monsterweapon = client.monsterweaponManagerfindById(monsterweapon_monsterid, monsterweapon_weaponid);
        try {
            client.monsterweaponManagerdelete(monsterweapon_monsterid, monsterweapon_weaponid);
            monsterweaponTableModel.removeMonsterweapon(monsterweapon);
        } catch (Exception ex) {
            String msg = "Deleting failed";
            LOGGER.log(Level.INFO, msg);
        }
    }//GEN-LAST:event_monsterweapons_deleteActionPerformed

    private void sample_weaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sample_weaponActionPerformed
        LOGGER.log(Level.INFO, "Adding sample weapon");
        WeaponDto weapon = Sampler.createSampleWeapon();
        client.weaponManagersave(weapon);
        weaponTableModel.addWeapon(weapon);
    }//GEN-LAST:event_sample_weaponActionPerformed

    private void sample_monsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sample_monsterActionPerformed
        LOGGER.log(Level.INFO, "Adding sample monster");
        MonsterDto monster = Sampler.createSampleMonster();
        client.monsterManagersave(monster);
        monsterTableModel.addMonster(monster);
    }//GEN-LAST:event_sample_monsterActionPerformed

    private void dialog_monsters_agilityInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_agilityInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_agilityInputActionPerformed

    private void dialog_monsters_strengthInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_strengthInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_strengthInputActionPerformed

    private void dialog_monsters_staminaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_staminaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_staminaInputActionPerformed

    private void dialog_monsters_dangerLevelInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_dangerLevelInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_dangerLevelInputActionPerformed

    private void dialog_monsters_imagePathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_imagePathInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_imagePathInputActionPerformed

    private void dialog_monsters_descriptionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialog_monsters_descriptionInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dialog_monsters_descriptionInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/*
	 * Set the Nimbus look and feel
	 */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
	 * If Nimbus (introduced in Java SE 6) is not available, stay with the
	 * default look and feel. For details see
	 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Survive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Survive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Survive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Survive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/*
	 * Create and display the form
	 */
	java.awt.EventQueue.invokeLater(new Runnable() {

	    public void run() {
                try {
                    new Survive().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Survive.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }
	});
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel content;
        private javax.swing.JDialog dialog_efficiencies;
        private javax.swing.JButton dialog_efficiencies_cancel;
        private javax.swing.JTextField dialog_efficiencies_damageInput;
        private javax.swing.JLabel dialog_efficiencies_damageLabel;
        private javax.swing.JTextField dialog_efficiencies_descriptionInput;
        private javax.swing.JLabel dialog_efficiencies_descriptionLabel1;
        private javax.swing.JTextField dialog_efficiencies_efficiencyInput;
        private javax.swing.JLabel dialog_efficiencies_efficiencyLabel;
        private javax.swing.JTextField dialog_efficiencies_hitRateInput;
        private javax.swing.JLabel dialog_efficiencies_hitRateLabel;
        private javax.swing.JLabel dialog_efficiencies_monsterHelper;
        private javax.swing.JTextField dialog_efficiencies_monsterInput;
        private javax.swing.JLabel dialog_efficiencies_monsterLabel;
        private javax.swing.JButton dialog_efficiencies_submit;
        private javax.swing.JLabel dialog_efficiencies_weaponHelper;
        private javax.swing.JTextField dialog_efficiencies_weaponInput;
        private javax.swing.JLabel dialog_efficiencies_weaponLabel;
        private javax.swing.JDialog dialog_monsters;
        private javax.swing.JTextField dialog_monsters_agilityInput;
        private javax.swing.JLabel dialog_monsters_agilityLabel;
        private javax.swing.JButton dialog_monsters_cancel;
        private javax.swing.JTextField dialog_monsters_dangerLevelInput;
        private javax.swing.JLabel dialog_monsters_dangerLevelLabel;
        private javax.swing.JTextField dialog_monsters_descriptionInput;
        private javax.swing.JLabel dialog_monsters_descriptionLabel;
        private javax.swing.JTextField dialog_monsters_heightInput;
        private javax.swing.JLabel dialog_monsters_heightLabel;
        private javax.swing.JTextField dialog_monsters_idInput;
        private javax.swing.JLabel dialog_monsters_idLabel;
        private javax.swing.JTextField dialog_monsters_imagePathInput;
        private javax.swing.JLabel dialog_monsters_imagePathLabel;
        private javax.swing.JComboBox dialog_monsters_monsterClassInput;
        private javax.swing.JLabel dialog_monsters_monsterClassLabel;
        private javax.swing.JTextField dialog_monsters_nameInput;
        private javax.swing.JLabel dialog_monsters_nameLabel;
        private javax.swing.JTextField dialog_monsters_staminaInput;
        private javax.swing.JLabel dialog_monsters_staminaLabel;
        private javax.swing.JTextField dialog_monsters_strengthInput;
        private javax.swing.JLabel dialog_monsters_strengthLabel;
        private javax.swing.JButton dialog_monsters_submit;
        private javax.swing.JTextField dialog_monsters_weightInput;
        private javax.swing.JLabel dialog_monsters_weightLabel;
        private javax.swing.JDialog dialog_weapons;
        private javax.swing.JTextField dialog_weapons_caliberInput;
        private javax.swing.JLabel dialog_weapons_caliberLabel;
        private javax.swing.JButton dialog_weapons_cancel;
        private javax.swing.JTextField dialog_weapons_descriptionInput;
        private javax.swing.JLabel dialog_weapons_descriptionLabel;
        private javax.swing.JTextField dialog_weapons_idInput;
        private javax.swing.JLabel dialog_weapons_idLabel;
        private javax.swing.JTextField dialog_weapons_nameInput;
        private javax.swing.JLabel dialog_weapons_nameLabel;
        private javax.swing.JTextField dialog_weapons_rangeInput;
        private javax.swing.JLabel dialog_weapons_rangeLabel;
        private javax.swing.JTextField dialog_weapons_roundsInput;
        private javax.swing.JLabel dialog_weapons_roundsLabel;
        private javax.swing.JButton dialog_weapons_submit;
        private javax.swing.JComboBox dialog_weapons_weaponClassInput;
        private javax.swing.JLabel dialog_weapons_weaponClassLabel;
        private javax.swing.JComboBox dialog_weapons_weaponTypeInput;
        private javax.swing.JLabel dialog_weapons_weaponTypeLabel;
        private javax.swing.JPanel efficiencies;
        private javax.swing.JButton efficiencies_add;
        private javax.swing.JButton efficiencies_delete;
        private javax.swing.JButton efficiencies_load;
        private javax.swing.JProgressBar efficiencies_progress;
        private javax.swing.JScrollPane efficiencies_scroll;
        private javax.swing.JTable efficiencies_table;
        private javax.swing.JLabel efficiencies_title;
        private javax.swing.JButton efficiencies_update;
        private javax.swing.JPanel header;
        private javax.swing.JLabel header_title;
        private javax.swing.JPanel monsters;
        private javax.swing.JButton monsters_add;
        private javax.swing.JButton monsters_delete;
        private javax.swing.JButton monsters_load;
        private javax.swing.JProgressBar monsters_progress;
        private javax.swing.JScrollPane monsters_scroll;
        private javax.swing.JTable monsters_table;
        private javax.swing.JLabel monsters_title;
        private javax.swing.JButton monsters_update;
        private javax.swing.JButton monsters_use;
        private javax.swing.JButton sample_monster;
        private javax.swing.JButton sample_weapon;
        private javax.swing.JPanel weapons;
        private javax.swing.JButton weapons_add;
        private javax.swing.JButton weapons_delete;
        private javax.swing.JButton weapons_load;
        private javax.swing.JProgressBar weapons_progress;
        private javax.swing.JScrollPane weapons_scroll;
        private javax.swing.JTable weapons_table;
        private javax.swing.JLabel weapons_title;
        private javax.swing.JButton weapons_update;
        private javax.swing.JButton weapons_use;
        // End of variables declaration//GEN-END:variables
}

