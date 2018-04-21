import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GraLiczbowa extends JFrame implements ActionListener {


	private JLabel labelIntro1;
	private JLabel labelIntro2;
	private JLabel labelIntro3;
	private JLabel labelPodaj;
	private JLabel labelOdpowiedz1;
	private JLabel labelOdpowiedz2;
	private JLabel labelOdpowiedz3;	
	private JLabel labelOdpowiedz4;	
	private JTextField textLiczba;
	private JButton buttonSprawdz;
	private JButton buttonWyjdz;
	private JButton buttonJeszczeRaz;
	private int typ;
	private int liczba = (int)(Math.random()*100+1);
	private int licznik = 5;
	
	public GraLiczbowa() {
		
		setSize(410,600);
		setTitle("ZGADNIJ JAKA TO LICZBA");
		setLayout(null);
		setResizable(false);
		
		labelIntro1 = new JLabel("Wylosowana zostala liczba od 1 do 100");
		labelIntro1.setBounds(40, 40, 400, 20);
		labelIntro1.setForeground(Color.DARK_GRAY);
		labelIntro1.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelIntro1);
		
		labelIntro2 = new JLabel("Zgadnij jaka to liczba");
		labelIntro2.setBounds(40, 70, 400, 20);
		labelIntro2.setForeground(Color.DARK_GRAY);
		labelIntro2.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelIntro2);
		
		labelIntro3 = new JLabel("Masz 6 prob. Powodzenia!");
		labelIntro3.setBounds(40, 100, 400, 20);
		labelIntro3.setForeground(Color.DARK_GRAY);
		labelIntro3.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelIntro3);
		
		labelPodaj = new JLabel("CZY TA LICZBA TO:");
		labelPodaj.setBounds(80, 160, 400, 20);
		labelPodaj.setForeground(Color.BLUE);
		labelPodaj.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelPodaj);
		
		textLiczba = new JTextField("");
		textLiczba.setBounds(240, 160, 80, 20);
		textLiczba.setToolTipText("JAKA TO LICZBA??");
		add(textLiczba);
		textLiczba.addActionListener(this);
		
		buttonSprawdz = new JButton("SPRAWDZ");
		buttonSprawdz.setBounds(145, 300, 100, 30);
		add(buttonSprawdz);
		buttonSprawdz.addActionListener(this);
		
		labelOdpowiedz1 = new JLabel("");
		labelOdpowiedz1.setBounds(40, 400, 400, 20);
		labelOdpowiedz1.setForeground(Color.DARK_GRAY);
		labelOdpowiedz1.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelOdpowiedz1);
		
		labelOdpowiedz2 = new JLabel("");
		labelOdpowiedz2.setBounds(40, 430, 400, 20);
		labelOdpowiedz2.setForeground(Color.DARK_GRAY);
		labelOdpowiedz2.setFont(new Font("Arial", Font.BOLD, 15));
		add(labelOdpowiedz2);
		
		labelOdpowiedz3 = new JLabel("");
		labelOdpowiedz3.setBounds(40, 460, 400, 20);
		labelOdpowiedz3.setForeground(Color.MAGENTA);
		labelOdpowiedz3.setFont(new Font("Arial", Font.BOLD, 20));
		add(labelOdpowiedz3);
		
		labelOdpowiedz4 = new JLabel("");
		labelOdpowiedz4.setBounds(40, 460, 400, 20);
		labelOdpowiedz4.setForeground(Color.BLACK);
		labelOdpowiedz4.setFont(new Font("Arial", Font.BOLD, 20));
		add(labelOdpowiedz4);
		
		buttonWyjdz = new JButton("WYJŒCIE");
		buttonWyjdz.setBounds(40, 300, 150, 30);
		add(buttonWyjdz);
		buttonWyjdz.addActionListener(this);
		buttonWyjdz.setVisible(false);
	
		buttonJeszczeRaz= new JButton("ZAGRAJ PONOWNIE");
		buttonJeszczeRaz.setBounds(210, 300, 150, 30);
		add(buttonJeszczeRaz);
		buttonJeszczeRaz.addActionListener(this);
		buttonJeszczeRaz.setVisible(false);
	}
	
 


	public static void main (String [] args) {
		
		GraLiczbowa gra = new GraLiczbowa();
		gra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gra.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		Object zrodlo = event.getSource();
		
		if (zrodlo==buttonSprawdz || zrodlo==textLiczba) {
			
			typ = Integer.parseInt(textLiczba.getText());
			
			
				if (licznik!=0) {
				
					if (typ<liczba) {
				
					labelOdpowiedz1.setText("Liczba jest wieksza, niz " + typ);		
					labelOdpowiedz2.setText("Pozostalo(y) " + (licznik) + " prob(y).");
					textLiczba.setText("");
					licznik--;
					
					} else if (typ>liczba) {
					labelOdpowiedz1.setText("Liczba jest mniejsza, niz " + typ);
					labelOdpowiedz2.setText("Pozostalo(y) " + (licznik) + " prob(y).");
					textLiczba.setText("");
					licznik--;
					
					} else if (typ==liczba) {
					
					labelOdpowiedz3.setText("Brawo, zgadles! Liczba to: " + liczba);					
					labelOdpowiedz1.setVisible(false);
					labelOdpowiedz2.setVisible(false);
					buttonSprawdz.setVisible(false);
					buttonWyjdz.setVisible(true);
					} 
					
				}	else  if (licznik==0) {	
					
					if (typ==liczba) {
						
						labelOdpowiedz3.setText("Brawo, zgadles! Liczba to: " + liczba);					
						labelOdpowiedz1.setVisible(false);
						labelOdpowiedz2.setVisible(false);
						buttonSprawdz.setVisible(false);
						buttonWyjdz.setVisible(true);
						buttonJeszczeRaz.setVisible(true);

						} else {
			
						labelOdpowiedz2.setVisible(false);
						labelOdpowiedz1.setText("Niestety nie udalo Ci sie. To byla liczba: " + liczba);
						buttonSprawdz.setVisible(false);
						buttonWyjdz.setVisible(true);
						buttonJeszczeRaz.setVisible(true);
						}
					}
						
		}	else if (zrodlo==buttonWyjdz)	{
			
			dispose();
			
		} 	else if (zrodlo==buttonJeszczeRaz) {
			
			liczba = (int)(Math.random()*100+1);
			licznik=5;
			labelOdpowiedz1.setText("");
			labelOdpowiedz1.setVisible(true);
			labelOdpowiedz2.setText("");
			labelOdpowiedz2.setVisible(true);
			textLiczba.setText("");
			labelOdpowiedz3.setText("");
			
		}
		
	}	
	
}
