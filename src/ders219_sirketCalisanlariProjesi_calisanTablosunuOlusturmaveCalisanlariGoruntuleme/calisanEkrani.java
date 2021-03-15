package ders219_sirketCalisanlariProjesi_calisanTablosunuOlusturmaveCalisanlariGoruntuleme;

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

public class calisanEkrani extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private final JTable tableCalisan = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	
	DefaultTableModel model;
	calisanislemleri islemler = new calisanislemleri();
	private JTextField textFieldAramaCubugu;

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
		setBounds(100, 100, 495, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		scrollPane.setBounds(10, 174, 459, 119);
		
		contentPanel.add(scrollPane);
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
		
		tableCalisan.getColumnModel().getColumn(0).setResizable(false);
		tableCalisan.getColumnModel().getColumn(1).setResizable(false);
		tableCalisan.getColumnModel().getColumn(2).setResizable(false);
		tableCalisan.getColumnModel().getColumn(3).setResizable(false);
		tableCalisan.getColumnModel().getColumn(4).setResizable(false);
		
		model = (DefaultTableModel) tableCalisan.getModel();
		calisanGoruntule();
	}
}
