package images;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class images {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/images","root","atharv@2411");
		Statement st = con.createStatement();
		PreparedStatement ps = con.prepareStatement("insert into images values(?,?)");
		
		
		JFileChooser jf = new JFileChooser();
		//JFileChooser is a simple and successful method for inciting the client to pick a file or a directory.
		jf.showOpenDialog(null);//help to open diglog box 
		File file = jf.getSelectedFile();
		FileInputStream fin= new FileInputStream(file);
		
		ps.setInt(1,1);
		ps.setBinaryStream(2, fin,fin.available());
		JOptionPane.showMessageDialog(null, "image successfully in");
		
		ps.executeUpdate();
	}
}
