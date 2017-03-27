package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import vue.IHMUsager;

import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Gestion Usager");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				IHMUsager usager=new IHMUsager();
				usager.frame.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnGestionOeuvre = new JMenu("Gestion Oeuvre");
		mnGestionOeuvre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				IHMOeuvre oeuvre = new IHMOeuvre();
				oeuvre.setVisible(true);
			}
		});
		menuBar.add(mnGestionOeuvre);
		
		JMenu mnGestionExemplaire = new JMenu("Gestion Exemplaire");
		mnGestionExemplaire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				IHMExemplaire exemp = new IHMExemplaire();
				exemp.setVisible(true);
			}
		});
		menuBar.add(mnGestionExemplaire);
	}
}
