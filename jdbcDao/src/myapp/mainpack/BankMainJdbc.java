package myapp.mainpack;

import myappl.controller.AccountController;
import myappl.model.Account;

public class BankMainJdbc {

	public static void main(String[] args) {
		AccountController ac=new AccountController();
		int acc=ac.search();
		ac.savesearch(acc);
	}
}
