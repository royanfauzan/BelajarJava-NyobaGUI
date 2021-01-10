package guiNyoba;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;


//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NyobaJFrame extends JFrame {
	private JTextField textFieldNIK;
	private JTextField textFieldNamaKaryawan;
	private JTextField textFieldAlamat;
	private JTextField textFieldEmail;
	private JTextField textFieldNoTelp;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox comboBoxJabatan;
	public NyobaJFrame() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA KARYAWAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(122, 11, 109, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NIK");
		lblNewLabel_1.setBounds(51, 46, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nama Karyawan");
		lblNewLabel_2.setBounds(51, 71, 85, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Jabatan");
		lblNewLabel_2_1.setBounds(51, 99, 85, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Alamat");
		lblNewLabel_2_2.setBounds(51, 126, 85, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("E-mail");
		lblNewLabel_2_3.setBounds(51, 155, 85, 14);
		getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("No Telpon");
		lblNewLabel_2_4.setBounds(51, 183, 85, 14);
		getContentPane().add(lblNewLabel_2_4);
		
		textFieldNIK = new JTextField();
		textFieldNIK.setBounds(160, 43, 133, 14);
		getContentPane().add(textFieldNIK);
		textFieldNIK.setColumns(10);
		
		textFieldNamaKaryawan = new JTextField();
		textFieldNamaKaryawan.setColumns(10);
		textFieldNamaKaryawan.setBounds(160, 71, 168, 14);
		getContentPane().add(textFieldNamaKaryawan);
		
		textFieldAlamat = new JTextField();
		textFieldAlamat.setColumns(10);
		textFieldAlamat.setBounds(160, 126, 133, 14);
		getContentPane().add(textFieldAlamat);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(160, 152, 133, 14);
		getContentPane().add(textFieldEmail);
		
		textFieldNoTelp = new JTextField();
		textFieldNoTelp.setColumns(10);
		textFieldNoTelp.setBounds(160, 180, 133, 14);
		getContentPane().add(textFieldNoTelp);
		

		
		JButton btnNewButtonTambah = new JButton("Tambah Data");
		btnNewButtonTambah.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButtonTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tambah_karyawan();	
				bersih();
			}
		});
		btnNewButtonTambah.setBounds(8, 208, 89, 23);
		getContentPane().add(btnNewButtonTambah);
		
		JButton btnNewButton_1 = new JButton("Simpan");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ubahData();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(97, 208, 63, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hapus");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hapusData();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2.setBounds(277, 208, 59, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Keluar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_3.setBounds(337, 208, 76, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("Edit");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2_1.setBounds(160, 208, 59, 23);
		getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Batal");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bersih();
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2_2.setBounds(219, 208, 59, 23);
		getContentPane().add(btnNewButton_2_2);
		
		comboBoxJabatan = new JComboBox();
		comboBoxJabatan.setModel(new DefaultComboBoxModel(new String[] {"IT Engineer", "Kang poto"}));
		comboBoxJabatan.setBounds(159, 95, 148, 23);
		getContentPane().add(comboBoxJabatan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				if (i==-1) {
					JOptionPane.showMessageDialog(null, "Pilih satu baris");
					return;
				}
				String NIK = (String)model.getValueAt(i, 0);
				String nama = (String)model.getValueAt(i, 1);
				String Jabatan = (String)model.getValueAt(i, 2);
				String alamat = (String)model.getValueAt(i, 3);
				String email = (String)model.getValueAt(i, 4);
				String no_telp = (String)model.getValueAt(i, 5);
				
				textFieldNIK.setText(NIK);
				textFieldNIK.disable();
				textFieldNamaKaryawan.setText(nama);
				comboBoxJabatan.setSelectedItem(Jabatan);
				textFieldAlamat.setText(alamat);
				textFieldEmail.setText(email);
				textFieldNoTelp.setText(no_telp);
			}
		});
		scrollPane.setBounds(441, 49, 400, 200);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
			
		model = new DefaultTableModel();
		model.addColumn("NIK");
		model.addColumn("Nama Karyawan");
		model.addColumn("Jabatan");
		model.addColumn("Alamat ");
		model.addColumn("Email ");
		model.addColumn("No.Telpon");
		table.setModel(model);
		
		
		loadData();
	}
	public static void main(String[] args) {
		NyobaJFrame ui = new NyobaJFrame();
		ui.setSize(900,400);
		ui.setVisible(true);
		
	}
	public void loadData() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		try {
			Connection c = Koneksi.getKoneksi();
			Statement s = c.createStatement();
			
			String sql = "SELECT * FROM test_gui";
			ResultSet r = s.executeQuery(sql);
			while (r.next()) {
				Object [] o = new Object[6] ;
				o[0]=r.getString("NIK");
				o[1]=r.getString("nama_karyawan");
				o[2]=r.getString("jabatan");
				o[3]=r.getString("alamat");
				o[4]=r.getString("email");
				o[5]=r.getString("nomer_telpon");
				model.addRow(o);
			}
			s.close();
			r.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Load Data gagal"+e);
		}
	}
	public void tambah_karyawan() {
		String NIM = textFieldNIK.getText();
		String Nama = textFieldNamaKaryawan.getText();
		String Jabatan = comboBoxJabatan.getSelectedItem().toString();
		String Alamat = textFieldAlamat.getText();
		String Email = textFieldEmail.getText();
		String nomer_telpon = textFieldNoTelp.getText();
		try {
			Connection c = Koneksi.getKoneksi () ;
			String sql = "INSERT INTO test_gui VALUES (?,?,?,?,?,?)";
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, NIM);
			p.setString (2, Nama);
			p.setString (3, Jabatan);
			p.setString(4, Alamat);
			p.setString(5, Email);
			p.setString(6, nomer_telpon);
			p.executeUpdate ();
			p.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e) ;
		}finally {
			loadData () ;
		}
	}
	public void ubahData() {
		String NIM = textFieldNIK.getText();
		String Nama = textFieldNamaKaryawan.getText();
		String Jabatan = comboBoxJabatan.getSelectedItem().toString();
		String Alamat = textFieldAlamat.getText();
		String Email = textFieldEmail.getText();
		String nomer_telpon = textFieldNoTelp.getText();
		try {
			Connection c = Koneksi.getKoneksi () ;
			String sql = "UPDATE test_gui SET nama_karyawan=?,jabatan=?,alamat=?,email=?,nomer_telpon=? WHERE nik=?";
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString (1, Nama);
			p.setString (2, Jabatan);
			p.setString(3, Alamat);
			p.setString(4, Email);
			p.setString(5, nomer_telpon);
			p.setString(6, NIM);
			p.executeUpdate ();
			p.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e) ;
		}finally {
			loadData () ;
			bersih();
		}
	}
	public void hapusData() {
		int i = table.getSelectedRow();
		if (i==-1) {
			JOptionPane.showMessageDialog(null, "Pilih satu baris");
			return;
		}
		String NIM = textFieldNIK.getText();

		try {
			Connection c = Koneksi.getKoneksi () ;
			String sql = "DELETE FROM test_gui WHERE nik=?";
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString (1, NIM);
			p.executeUpdate ();
			p.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e) ;
		}finally {
			loadData () ;
			bersih();
		}
	}
	public void bersih() {
		textFieldNIK.setText("");
		textFieldNIK.enable();
		textFieldNamaKaryawan.setText("");
		comboBoxJabatan.setSelectedItem("IT Engineer");
		textFieldAlamat.setText("");
		textFieldEmail.setText("");
		textFieldNoTelp.setText("");
	}
	
}
