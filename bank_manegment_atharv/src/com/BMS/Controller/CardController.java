package com.BMS.Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BMS.Service.CardService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Account;
import com.BMS.pojo.Card;

public class CardController implements CardService{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	Card c = new Card();
	Account a = new Account();
	
	@Override
	public boolean addCard(Card c,String account_number,String pin) throws ClassNotFoundException, SQLException {
	    conn = DBConnection.estamblishConn();
		String insertQuery = "INSERT INTO cards (user_id, account_number, aadharcard_number, card_type, card_number, cvv, expiry_date) SELECT u.user_id, u.account_number, u.aadharcard_number, ? AS card_type, ? AS card_number, ? AS cvv, ? AS expiry_date FROM accounts u WHERE u.pin = ? AND u.account_number = ?";
        ps = conn.prepareStatement(insertQuery);   
        ps.setString(1, c.getCard_type());
        ps.setString(2, c.getCard_number());
        ps.setString(3, c.getCvv());
        ps.setDate(4,(Date) c.getExpiry_date());
        ps.setTimestamp(5, DBConnection.getTime());
        ps.setString(6, pin);
        ps.setString(7,account_number);
        i = ps.executeUpdate();
        if(i>0)
        {
        	return true;
        }
        else
        {
        	return false;
        }
}

}
