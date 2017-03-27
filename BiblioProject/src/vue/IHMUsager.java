package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;
import controller.Usagercontroller;
import dao.DBinteraction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;

public class IHMUsager {

	JFrame frame;
	private JTextField NomField;
	private JTextField PrenomField;
	Usagercontroller control = new Usagercontroller();
	
	
	private JTable UsagerTable;
	private JTextField RechercheField;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMUsager window = new IHMUsager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refreshTable(){
		
		    control.lister();
			UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
	}
	
	public void vider(){
		
		NomField.setText("");
		PrenomField.setText("");
		textField.setText("");
		textField_1.setText("");
		}


	/**
	 * Create the application.
	 */
	public IHMUsager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel AjouterPanel = new JPanel();
		AjouterPanel.setBounds(10, 11, 304, 447);
		frame.getContentPane().add(AjouterPanel);
		AjouterPanel.setLayout(null);
		
		JLabel lblAjouterUsager = new JLabel("AJOUTER USAGER");
		lblAjouterUsager.setBounds(93, 21, 136, 19);
		AjouterPanel.add(lblAjouterUsager);
		lblAjouterUsager.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(25, 79, 48, 25);
		AjouterPanel.add(lblNom);
		
		NomField = new JTextField();
		NomField.setBounds(103, 81, 120, 25);
		AjouterPanel.add(NomField);
		NomField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(10, 130, 78, 31);
		AjouterPanel.add(lblPrenom);
		
		PrenomField = new JTextField();
		PrenomField.setBounds(103, 135, 117, 25);
		AjouterPanel.add(PrenomField);
		PrenomField.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control.addUsager( NomField.getText(), PrenomField.getText(),textField.getText(),textField_1.getText());		
			}
			
		});
		btnAjouter.setBounds(25, 378, 89, 31);
		AjouterPanel.add(btnAjouter);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifier.setBounds(169, 378, 97, 31);
		AjouterPanel.add(btnModifier);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(103, 189, 144, 75);
		AjouterPanel.add(textField);
		
		JLabel lblAdreesse = new JLabel("Adreesse : ");
		lblAdreesse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdreesse.setBounds(10, 189, 78, 31);
		AjouterPanel.add(lblAdreesse);
		
		textField_1 = new JTextField();
		textField_1.setText("(+212)");
		textField_1.setColumns(10);
		textField_1.setBounds(103, 275, 144, 25);
		AjouterPanel.add(textField_1);
		
		JLabel lblTel = new JLabel("Tel  :");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTel.setBounds(25, 273, 48, 25);
		AjouterPanel.add(lblTel);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int row = UsagerTable.getSelectedRow();
				String idr=(UsagerTable.getModel().getValueAt(row, 0)).toString();
				control.UpdateUsager( NomField.getText(),PrenomField.getText(),textField.getText(),textField_1.getText(), Integer.parseInt(idr));
				refreshTable();
				vider();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(379, 11, 408, 447);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblListerUsagers = new JLabel("LISTER USAGERS");
		lblListerUsagers.setBounds(83, 11, 152, 27);
		lblListerUsagers.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblListerUsagers);
		
		
		
		JButton btnLister = new JButton("LISTER");
		btnLister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLister.setBounds(67, 358, 111, 23);
		
		btnLister.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent e) {
				
			    control.lister();
				UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				
			}
		});
		panel.add(btnLister);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 52, 331, 295);
		panel.add(scrollPane);
		
		UsagerTable = new JTable();
		scrollPane.setViewportView(UsagerTable);
		
		JButton btnRechercher = new JButton("RECHERCHER");
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.searchUsager(RechercheField.getText());
				UsagerTable.setModel(DbUtils.resultSetToTableModel(DBinteraction.rs));
				
			}
		});
		btnRechercher.setBounds(67, 392, 111, 29);
		panel.add(btnRechercher);
		
		RechercheField = new JTextField();
		RechercheField.setBounds(232, 401, 86, 20);
		panel.add(RechercheField);
		RechercheField.setColumns(10);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimer.setBounds(229, 358, 104, 27);
		panel.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = UsagerTable.getSelectedRow();
				String idr=(UsagerTable.getModel().getValueAt(row, 0)).toString();
				control.deleteUsager(Integer.parseInt(idr));
				refreshTable();
				vider();
				
			}
		});
		
		UsagerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					try {
						int row = UsagerTable.getSelectedRow();
						String ID_=(UsagerTable.getModel().getValueAt(row, 0)).toString();
						String query="select * from usager where ID='"+Integer.parseInt(ID_)+"'";
						PreparedStatement pst=DBinteraction.con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						while(rs.next())
						{
							
							NomField.setText(rs.getString("Nom"));
							PrenomField.setText(rs.getString("Prenom"));
							textField.setText(rs.getString("adresse"));
							textField_1.setText(rs.getString("tel"));
							
							
						}
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
