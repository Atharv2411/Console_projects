package com.BMS.Service;

import java.sql.SQLException;

import com.BMS.pojo.Card;

public interface CardService {
	boolean addCard(Card c,String account_number,String pin) throws ClassNotFoundException, SQLException;
}
