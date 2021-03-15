package ders224_sirketCalisanlariProjesi_jarDosyasiHalineGetirme;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class calisanEkrani extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private final JTable tableCalisan = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	
	DefaultTableModel model;
	calisanislemleri islemler = new calisanislemleri();
	private final JTextField textFieldAramaCubugu = new JTextField();
	private final JLabel lblAd = new JLabel("Ad : ");
	private final JLabel lblSoyad = new JLabel("Soyad :");
	private final JLabel lblDepartman = new JLabel("Departman :");
	private final JLabel lblMaas = new JLabel("Maa\u015F :");
	private final JTextField textFieldAdAlani = new JTextField();
	private final JTextField textFieldSoyadAlani = new JTextField();
	private final JTextField textFieldDepartmanAlani = new JTextField();
	private final JTextField textFieldMaasAlani = new JTextField();
	private final JLabel lblMesajYazisi = new JLabel("");
	private final JButton btnCalisanGuncelle = new JButton("\u00C7al\u0131\u015Fan G\u00FCncelle");
	private final JButton btnCalisanSil = new JButton("\u00C7al\u0131\u015Fan Sil");
	
	public void dinamikAra(String ara){
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		tableCalisan.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(ara));
	}

	public void calisanGoruntule(){
		model.setRowCount(0);
			/*çalýþan tablosu her seferinde boþalacak ve calisanGoruntule() metodu çaðýrýldýnda tekrar
			  doldurulacak.*/
		ArrayList<calisan> calisanlar = new ArrayList<calisan>();
		
		calisanlar = islemler.calisanlariGetir();
		
		if(calisanlar != null){
			for(calisan Calisan : calisanlar){
				Object[] eklenecek = {Calisan.getId(),Calisan.getAd(),Calisan.getSoyad(),
						Calisan.getDepartman(),Calisan.getMaas()};
				model.addRow(eklenecek);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			calisanEkrani dialog = new calisanEkrani(new javax.swing.JFrame(), true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public calisanEkrani(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		textFieldAdAlani.setBounds(111, 47, 197, 20);
		textFieldAdAlani.setColumns(10);
		textFieldAramaCubugu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String ara = textFieldAramaCubugu.getText();
				dinamikAra(ara);
			}
		});
		textFieldAramaCubugu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAramaCubugu.setBounds(10, 11, 459, 28);
		textFieldAramaCubugu.setColumns(10);
		setBounds(100, 100, 495, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		scrollPane.setBounds(10, 174, 459, 119);
		
		contentPanel.add(scrollPane);
		tableCalisan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow = tableCalisan.getSelectedRow();
				textFieldAdAlani.setText(model.getValueAt(selectedRow, 1).toString());
				textFieldSoyadAlani.setText(model.getValueAt(selectedRow, 2).toString());
				textFieldDepartmanAlani.setText(model.getValueAt(selectedRow, 3).toString());
				textFieldMaasAlani.setText(model.getValueAt(selectedRow, 4).toString());
			}
		});
		scrollPane.setViewportView(tableCalisan);
		tableCalisan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ad", "Soyad", "Departman", "Maa\u015F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		contentPanel.add(textFieldAramaCubugu);
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAd.setBounds(20, 47, 81, 17);
		
		contentPanel.add(lblAd);
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoyad.setBounds(20, 72, 81, 17);
		
		contentPanel.add(lblSoyad);
		lblDepartman.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartman.setBounds(20, 97, 81, 17);
		
		contentPanel.add(lblDepartman);
		lblMaas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaas.setBounds(20, 122, 81, 17);
		
		contentPanel.add(lblMaas);
		
		contentPanel.add(textFieldAdAlani);
		textFieldSoyadAlani.setColumns(10);
		textFieldSoyadAlani.setBounds(111, 72, 197, 20);
		
		contentPanel.add(textFieldSoyadAlani);
		textFieldDepartmanAlani.setColumns(10);
		textFieldDepartmanAlani.setBounds(111, 97, 197, 20);
		
		contentPanel.add(textFieldDepartmanAlani);
		textFieldMaasAlani.setColumns(10);
		textFieldMaasAlani.setBounds(111, 122, 197, 20);
		
		contentPanel.add(textFieldMaasAlani);
		lblMesajYazisi.setForeground(Color.RED);
		lblMesajYazisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMesajYazisi.setBounds(10, 150, 459, 20);
		
		contentPanel.add(lblMesajYazisi);
		
		JButton btnYeniCalisanEkle = new JButton("\u00C7al\u0131\u015Fan Ekle");
		btnYeniCalisanEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMesajYazisi.setText("");
				
				String ad = textFieldAdAlani.getText();
				String soyad = textFieldSoyadAlani.getText();
				String departman = textFieldDepartmanAlani.getText();
				String maas = textFieldMaasAlani.getText();
				
				islemler.calisanEkle(ad, soyad, departman, maas);
				calisanGoruntule();
				
				lblMesajYazisi.setText("Yeni çalýþan baþarýlý bir þekilde eklendi...");
			}
		});
		btnYeniCalisanEkle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnYeniCalisanEkle.setBounds(312, 46, 157, 23);
		contentPanel.add(btnYeniCalisanEkle);
		btnCalisanGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ad = textFieldAdAlani.getText();
				String soyad = textFieldSoyadAlani.getText();
				String departman = textFieldDepartmanAlani.getText();
				String maas = textFieldMaasAlani.getText();
				
				int selectedRow = tableCalisan.getSelectedRow();
				
				if(selectedRow == -1){
					//ya çalýþan tablosu boþ ya da herhangi bir veriye týklanmaýþ.
					if(model.getRowCount() == 0){
						//tablo boþ.
						lblMesajYazisi.setText("Çalýþanlar tablosu þu anda boþ...");
					}
					else{
						lblMesajYazisi.setText("Lütfen güncellenecek bir çalýþan seçiniz...");
					}
				}
				else{
					int id = (int)model.getValueAt(selectedRow, 0);
					
					islemler.calisanGuncelle(id, ad, soyad, departman, maas);
					
					calisanGoruntule();
					
					lblMesajYazisi.setText("Çalýþan baþarýlý bir þekilde güncellendi...");
				}
			}
		});
		btnCalisanGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalisanGuncelle.setBounds(312, 71, 157, 23);
		
		contentPanel.add(btnCalisanGuncelle);
		btnCalisanSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMesajYazisi.setText("");
				
				int selectedRow = tableCalisan.getSelectedRow();
				
				if(selectedRow == -1){
					//ya tablo boþ ya da herhangi bir veri seçilmemiþ.
					if(model.getRowCount() == 0){
						//tablo boþ.
						lblMesajYazisi.setText("Çalýþan tablosu þu anda boþ...");
					}
					else{
						lblMesajYazisi.setText("Lütfen silinecek bir çalýþan seçiniz...");
					}
				}
				else{
					int id = (int)model.getValueAt(selectedRow, 0);
					islemler.calisanSil(id);
					calisanGoruntule();
					lblMesajYazisi.setText("Çalýþan baþarý ile silindi...");
				}
			}
		});
		btnCalisanSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalisanSil.setBounds(312, 96, 157, 23);
		
		contentPanel.add(btnCalisanSil);
		tableCalisan.getColumnModel().getColumn(0).setResizable(false);
		tableCalisan.getColumnModel().getColumn(1).setResizable(false);
		tableCalisan.getColumnModel().getColumn(2).setResizable(false);
		tableCalisan.getColumnModel().getColumn(3).setResizable(false);
		tableCalisan.getColumnModel().getColumn(4).setResizable(false);
		
		model = (DefaultTableModel) tableCalisan.getModel();
		calisanGoruntule();
	}
}
