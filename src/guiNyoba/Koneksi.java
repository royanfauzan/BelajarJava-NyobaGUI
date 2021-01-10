package guiNyoba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.util.logging.Level;

public class Koneksi {
	private static Connection koneksi;
	public static Connection getKoneksi() {
		if(koneksi==null) {
			try {
				String url = "jdbc:mysql://Localhost/pbo";
				String user = "root";
				String pass = "";
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				koneksi = DriverManager.getConnection(url,user,pass);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		return koneksi;
	}
	public void closeConn() {
		try {
			koneksi.close();
		}catch(Exception e) {
			Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null,e);
		}
	}

}
