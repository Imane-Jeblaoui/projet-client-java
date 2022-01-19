package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import ma.connexion.Connexion;
import ma.entities.SmartPhone;
import ma.entities.User;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField nomtextField;
	private JTextField prenomtextField;
	private JTextField emailtextField;
	private JTextField teletextField;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private JTextField Imei_Text;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(107, 20, 718, 532);
		contentPane.add(tabbedPane);

		model = new DefaultTableModel();
		Object[] column = { "id", "nom", "prenom", "email", "telephone", "dateNaissance" };
		Object[] rows = new Object[6];
		model.setColumnIdentifiers(column);
		// Affichage
		List<User> users = Connexion.getrUser().findAll();
		model.setRowCount(0);
		for (User s : users) {
			rows[0] = s.getId();
			rows[1] = s.getNom();
			rows[2] = s.getPrenom();
			rows[3] = s.getEmail();
			rows[4] = s.getTelephone();
			rows[5] = s.getDateNaissance();
			model.addRow(rows);
		}
		
				JPanel panel = new JPanel();
				tabbedPane.addTab("User", null, panel, null);
				panel.setLayout(null);
				
						nomtextField = new JTextField();
						nomtextField.setBounds(136, 10, 165, 20);
						panel.add(nomtextField);
						nomtextField.setColumns(10);
						
								prenomtextField = new JTextField();
								prenomtextField.setBounds(136, 40, 165, 20);
								panel.add(prenomtextField);
								prenomtextField.setColumns(10);
								
										emailtextField = new JTextField();
										emailtextField.setBounds(136, 80, 165, 20);
										panel.add(emailtextField);
										emailtextField.setColumns(10);
										
												teletextField = new JTextField();
												teletextField.setBounds(136, 111, 165, 20);
												panel.add(teletextField);
												teletextField.setColumns(10);
												
														Label label = new Label("nom");
														label.setFont(new Font("Dialog", Font.PLAIN, 12));
														label.setBounds(20, 10, 59, 21);
														panel.add(label);
														
																Label label_1 = new Label("prenom");
																label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
																label_1.setBounds(20, 41, 59, 21);
																panel.add(label_1);
																
																		Label label_2 = new Label("email");
																		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
																		label_2.setBounds(20, 80, 59, 21);
																		panel.add(label_2);
																		
																				Label label_3 = new Label("telephone");
																				label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
																				label_3.setBounds(20, 110, 82, 21);
																				panel.add(label_3);
																				
																						Label label_4 = new Label("dateNaissance");
																						label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
																						label_4.setBounds(20, 148, 102, 33);
																						panel.add(label_4);
																						
																								JCalendar calendar = new JCalendar();
																								calendar.setBounds(136, 153, 213, 152);
																								panel.add(calendar);
																								
																										JScrollPane scrollPane = new JScrollPane();
																										scrollPane.setBounds(20, 315, 657, 165);
																										panel.add(scrollPane);
																										
																												table = new JTable();
																												table.addMouseListener(new MouseAdapter() {
																													@Override
																													public void mouseClicked(MouseEvent e) {
																														int i = table.getSelectedRow();
																														nomtextField.setText(model.getValueAt(i, 1).toString());
																														prenomtextField.setText(model.getValueAt(i, 2).toString());
																														emailtextField.setText(model.getValueAt(i, 3).toString());
																														teletextField.setText(model.getValueAt(i, 4).toString());
																														calendar.setDate((Date) model.getValueAt(i, 5));
																													}
																												});
																												table.setModel(model);
																												scrollPane.setViewportView(table);
																												JButton btn_ajout = new JButton("Ajouter");
																												btn_ajout.setFont(new Font("Tahoma", Font.PLAIN, 12));
																												btn_ajout.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent e) {
																														Connexion.getrUser().create(new User(emailtextField.getText(), nomtextField.getText(),
																																prenomtextField.getText(), teletextField.getText(), calendar.getDate()));
																														// Affichage
																														List<User> users = Connexion.getrUser().findAll();
																														model.setRowCount(0);
																														for (User s : users) {
																															rows[0] = s.getId();
																															rows[1] = s.getNom();
																															rows[2] = s.getPrenom();
																															rows[3] = s.getEmail();
																															rows[4] = s.getTelephone();
																															rows[5] = s.getDateNaissance();
																															model.addRow(rows);
																														}
																														JOptionPane.showMessageDialog(null, "User a ete ajoute");
																													}
																												});
																												
																														btn_ajout.setBounds(415, 24, 107, 33);
																														panel.add(btn_ajout);
																														JButton btn_supprimer = new JButton("Supprimer");
																														btn_supprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
																														btn_supprimer.addActionListener(new ActionListener() {
																															public void actionPerformed(ActionEvent e) {
																																int i = table.getSelectedRow();
																																int id = (int) table.getModel().getValueAt(i, 0);
																																User u = new User();
																																u.setId(id);
																																Connexion.getrUser().delteById(u);
																																model.removeRow(i);
																																JOptionPane.showMessageDialog(null, "User a ete supprimer");
																															}
																														});
																														btn_supprimer.setBounds(415, 111, 107, 33);
																														panel.add(btn_supprimer);
																														
																																JButton btn_modifier = new JButton("Modifier");
																																btn_modifier.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		int i = table.getSelectedRow();
																																		int id = (int) table.getModel().getValueAt(i, 0);

																																		User u = new User();
																																		u.setId(id);
																																		u.setNom(nomtextField.getText());
																																		u.setPrenom(prenomtextField.getText());
																																		u.setEmail(emailtextField.getText());
																																		u.setTelephone(teletextField.getText());
																																		u.setDateNaissance(calendar.getDate());
																																		Connexion.getrUser().update(u);

																																		List<User> users = Connexion.getrUser().findAll();
																																		model.setRowCount(0);
																																		for (User s : users) {
																																			rows[0] = s.getId();
																																			rows[1] = s.getNom();
																																			rows[2] = s.getPrenom();
																																			rows[3] = s.getEmail();
																																			rows[4] = s.getTelephone();
																																			rows[5] = s.getDateNaissance();
																																			model.addRow(rows);
																																		}
																																		JOptionPane.showMessageDialog(null, "User a ete modifier");
																																	}
																																});
																																btn_modifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
																																btn_modifier.setBounds(415, 65, 107, 33);
																																panel.add(btn_modifier);
																																
																																		JButton btn_vider = new JButton("Vider");
																																		btn_vider.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent e) {
																																				emailtextField.setText("");
																																				nomtextField.setText("");
																																				prenomtextField.setText("");
																																				teletextField.setText("");
																																				calendar.setDate(new Date());
																																			}
																																		});
																																		btn_vider.setFont(new Font("Tahoma", Font.PLAIN, 12));
																																		btn_vider.setBounds(415, 161, 107, 33);
																																		panel.add(btn_vider);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Smartphone", null, panel_1, null);
		panel_1.setLayout(null);

		// Affichage
		model2 = new DefaultTableModel();
		Object[] columnSmart = { "id", "imei", "user" };
		Object[] rowSmart = new Object[3];
		model2.setColumnIdentifiers(columnSmart);

		List<SmartPhone> smarts = Connexion.getrSphone().findAll();
		model2.setRowCount(0);
		for (SmartPhone s : smarts) {
			rowSmart[0] = s.getId();
			rowSmart[1] = s.getImei();
			rowSmart[2] = s.getUser();
			model2.addRow(rowSmart);
		}

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				User[] users = new User[Connexion.getrUser().findAll().size()];
				users = Connexion.getrUser().findAll().toArray(users);
				for (User u : users)
					comboBox.addItem(u);
			}
		});
		comboBox.setBounds(100, 163, 176, 29);
		panel_1.add(comboBox);

		Label label_5 = new Label("Imei");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5.setBounds(36, 94, 45, 29);
		panel_1.add(label_5);

		Label label_5_1 = new Label("User");
		label_5_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5_1.setBounds(36, 163, 45, 29);
		panel_1.add(label_5_1);

		Imei_Text = new JTextField();
		Imei_Text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Imei_Text.setColumns(10);
		Imei_Text.setBounds(100, 94, 176, 29);
		panel_1.add(Imei_Text);

		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Imei_Text.setText("");
			}
		});
		btnVider.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVider.setBounds(355, 216, 107, 33);
		panel_1.add(btnVider);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table2.getSelectedRow();
				int id = (int) table2.getModel().getValueAt(i, 0);

				SmartPhone s = new SmartPhone();
				s.setId(id);
				s.setImei(Imei_Text.getText());
				s.setUser((User) comboBox.getSelectedItem());
				Connexion.getrSphone().update(s);

				List<SmartPhone> smt = Connexion.getrSphone().findAll();
				model2.setRowCount(0);
				for (SmartPhone sm : smt) {
					rowSmart[0] = sm.getId();
					rowSmart[1] = sm.getImei();
					rowSmart[2] = sm.getUser();
					model2.addRow(rowSmart);
				}
				JOptionPane.showMessageDialog(null, "Smart a ete modifier");
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModifier.setBounds(355, 161, 107, 33);
		panel_1.add(btnModifier);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});
		scrollPane_1.setBounds(65, 275, 583, 220);
		panel_1.add(scrollPane_1);

		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table2.getSelectedRow();
				Imei_Text.setText(model2.getValueAt(i, 1).toString());
				comboBox.setSelectedItem(model2.getValueAt(i, 2).toString());
			}
		});
		table2.setModel(model2);
		scrollPane_1.setViewportView(table2);
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SmartPhone sm = new SmartPhone();
				sm.setImei(Imei_Text.getText());
				sm.setUser((User) comboBox.getSelectedItem());
				Connexion.getrSphone().create(sm);

				List<SmartPhone> smt = Connexion.getrSphone().findAll();
				model2.setRowCount(0);
				for (SmartPhone s : smt) {
					rowSmart[0] = s.getId();
					rowSmart[1] = s.getImei();
					rowSmart[2] = s.getUser();
					model2.addRow(rowSmart);
				}
				JOptionPane.showMessageDialog(null, "Smart a ete ajoute");
			}
		});
		btnAjouter.setBounds(355, 51, 107, 33);
		panel_1.add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table2.getSelectedRow();
				int id = (int) table2.getModel().getValueAt(i, 0);
				SmartPhone s = new SmartPhone();
				s.setId(id);
				Connexion.getrSphone().delteById(s);
				model2.removeRow(i);
				JOptionPane.showMessageDialog(null, "Smart a ete supprimer");
				
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSupprimer.setBounds(355, 109, 107, 31);
		panel_1.add(btnSupprimer);

	}
}
