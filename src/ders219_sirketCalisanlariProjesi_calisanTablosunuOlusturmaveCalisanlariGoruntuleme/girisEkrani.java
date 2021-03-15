package ders219_sirketCalisanlariProjesi_calisanTablosunuOlusturmaveCalisanlariGoruntuleme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class girisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKullaniciAdiAlani;
	private JPasswordField passwordFieldParolaAlani;
	
	calisanislemleri islemler = new calisanislemleri();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisEkrani frame = new girisEkrani();
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
	public girisEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullaniciAdi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKullaniciAdi.setBounds(50, 53, 106, 14);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParola.setBounds(50, 78, 106, 14);
		contentPane.add(lblParola);
		
		textFieldKullaniciAdiAlani = new JTextField();
		textFieldKullaniciAdiAlani.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldKullaniciAdiAlani.setBounds(166, 52, 176, 20);
		contentPane.add(textFieldKullaniciAdiAlani);
		textFieldKullaniciAdiAlani.setColumns(10);
		
		passwordFieldParolaAlani = new JPasswordField();
		passwordFieldParolaAlani.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldParolaAlani.setBounds(166, 77, 176, 20);
		contentPane.add(passwordFieldParolaAlani);
		
		JLabel lblMesajYazisi = new JLabel("");
		lblMesajYazisi.setForeground(Color.RED);
		lblMesajYazisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMesajYazisi.setBounds(50, 116, 292, 27);
		contentPane.add(lblMesajYazisi);
		
		JButton btnGirisYap = new JButton("Giri\u015F Yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMesajYazisi.setText("");
				String kullaniciAdi = textFieldKullaniciAdiAlani.getText();
				String parola = new String(passwordFieldParolaAlani.getPassword());
				
				boolean girisBasarili = islemler.girisYap(kullaniciAdi, parola);
				
				if(girisBasarili){
					//lblMesajYazisi.setText("Giriþ Baþarýlý...");
					calisanEkrani CalisanEkrani = new calisanEkrani(null, true);
					setVisible(false);
					CalisanEkrani.setVisible(true);
					System.exit(0);
				}
				else{
					lblMesajYazisi.setText("Giriþ Baþarýsýz... Lütfen Tekrar Deneyiniz...");
				}
			}
		});
		btnGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGirisYap.setBounds(116, 154, 183, 23);
		contentPane.add(btnGirisYap);
	}
}
