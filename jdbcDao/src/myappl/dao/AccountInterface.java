package myappl.dao;
import java.util.LinkedList;
import java.util.List;
import myappl.model.Account;

//this is abstract view
public interface AccountInterface {
	public int create(Account acobj);
	LinkedList<Account> retrive();
	int update(int acc);
	int delete(int acc);
	Account search(int an0);
}
