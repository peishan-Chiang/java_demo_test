package com.example.java_demo_test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

@Service
public class BankServiceimpl implements BankService {

	@Autowired
	private BankDao bankDao;

	int balance = 0;

	// 過去Bank bank版本
	@Override
	public void getAmount(Bank bank) {
		System.out.println("帳號" + bank.getAccount());
		System.out.println("額度" + bank.getAmount());

	}

	// bankRequest版本
	@Override
	public BankResponse getAmount(BankRequest bankRequest) {

		Bank bank = new Bank("AAA", "A123", 1000);// 因為沒有資料庫，所以造假資料。
		// if 作資料比對
		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPassword())) {
			// BankResponse response = new BankResponse(bank.getAccount(),
			// bank.getAmount());
			// return response;

			return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功");
		}

		return new BankResponse(bankRequest.getAccount(), null, "帳號或密碼錯誤");
		// BankResponse response = new BankResponse();
		// return response
	}

//過去bank版本
	@Override
	public void deposit(Bank bank, int depositAmount) {
		String account = bank.getAccount();
		if (account != null && !account.isBlank()) {
			// 方法一，不得為空或是null
		}

		if (!StringUtils.hasText(account)) {
			// 方法二，帳號不得為空或null
		}

		String bankName = bank.getAccount();
		int bankMoney = bank.getAmount();
		if (bankName == null || (bankName.isBlank())) {
			System.out.println("帳號不完全，請重新輸入資料");
			return;
		} else if (depositAmount <= 0) {
			System.out.println("存入金額小於零，不執行存款業務");
			return;
		}
		System.out.println("帳號" + bank.getAccount());
		System.out.println("存前額度" + bank.getAmount());

		if (bankName != null || !(bankName.isEmpty())) {
			System.out.println("---資料處理中---");
			System.out.println("帳號:" + bank.getAccount());
			System.out.println("存入金額:" + depositAmount);
			balance = bank.getAmount() + depositAmount;

		}
		System.out.println("---存款業務完成---");
		System.out.println("帳號" + bank.getAccount());
		System.out.println("存後額度" + balance);

		bank.setAmount(balance);
	}

	// BankResponse版本
//	@Override
//	public BankResponse deposit(BankRequest bankRequest) {
//
//		int newbalance;
//		Bank bank = new Bank("AAA", "A123", 1000);// 因為沒有資料庫，所以造假資料。
//		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPassword())) {
//
//			if (bankRequest.getMoneyRange() > 0) {
//				newbalance = bank.getAmount() + bankRequest.getMoneyRange();
//				bank.setAmount(newbalance);
//				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(), newbalance, "成功存款");
//
//			}
//			return new BankResponse(bankRequest.getAccount(), "金額小於零");
//		}
//		return new BankResponse(bankRequest.getAccount(), "帳號或密碼錯誤");
//	}

	// BankResponse版本，作boolean優化

	public BankResponse depositBoolean(BankRequest bankRequest) {
		Bank bank = new Bank("AAA", "A123", 1000);// 因為沒有資料庫，所以造假資料。
		int newbalance;
//			boolean checkresult=checkAccountAndPwd(bankRequest , bank);//宣告一個變數叫出boolean的方法

		if (checkAccountAndPwd(bankRequest, bank)) {
//				if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPassword())) {
			if (bankRequest.getMoneyRange() > 0) {
				newbalance = bank.getAmount() + bankRequest.getMoneyRange();
				bank.setAmount(newbalance);
				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(), newbalance, "成功存款");

			}
			return new BankResponse(bankRequest.getAccount(), "金額小於零");
		}
		return new BankResponse(bankRequest.getAccount(), "帳號或密碼錯誤");
	}

	// 因為提款跟存款判斷都一樣，所以用boolean 方法，解決if過長
	private boolean checkAccountAndPwd(BankRequest bankRequest, Bank bank) {
		boolean result = bankRequest.getAccount().equals(bank.getAccount())
				&& bankRequest.getPwd().equals(bank.getPassword());
		return result;
	}

	@Override
	public void withdraw(Bank bank, int withdrawAmount) {

		String bankName = bank.getAccount();
		int bankMoney = bank.getAmount();
		if (bankName == null || (bankName.isBlank())) {
			System.out.println("帳號不完全，請重新輸入資料");
			return;
		}
		if (withdrawAmount <= 0) {
			System.out.println("提出金額小於零，不執行提款業務");
			return;
		}

		System.out.println("帳號" + bank.getAccount());
		System.out.println("提前額度" + bank.getAmount());

		if (bankName != null || !(bankName.isEmpty())) {
			if (bank.getAmount() >= withdrawAmount) {
				System.out.println("---資料處理中---");
				balance = bank.getAmount() - withdrawAmount;
				System.out.println("提出:" + withdrawAmount);
				System.out.println("---提款業務完成---");
				System.out.println("帳號" + bank.getAccount());
				System.out.println("堤後額度" + balance);
				bank.setAmount(balance);
			} else {
				System.out.println("Warnning: 金額超過此帳號餘額，或是提款小於零，無法提取");
				System.out.println("額度" + (bank.getAmount()));

			}

		}
	}

	// BankResponse版本
//	@Override
//	public BankResponse withdraw(BankRequest bankRequest) {
//		int newbalance;
//		Bank bank = new Bank("AAA", "A123", 1000);// 因為沒有資料庫，所以造假資料。
//		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPassword())) {
//
//			if (bank.getAmount() > bankRequest.getMoneyRange() && bankRequest.getMoneyRange() > 0) {
//
//				newbalance = bank.getAmount() - bankRequest.getMoneyRange();
//				bank.setAmount(newbalance);
//				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(), newbalance, "成功扣款");
//
//			}
//			return new BankResponse(bankRequest.getAccount(), "金額小於零或是金額超過此帳號餘額");
//
//		}
//		return new BankResponse(bankRequest.getAccount(), "帳號或密碼錯誤");
//
//	}

	// 【存款】:配合 直接提款跟存款統一的方法
	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		return depositorwithdraw(bankRequest, false);

	}

	// 【提款】:配合 直接提款跟存款統一的方法
	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		return depositorwithdraw(bankRequest, true);

	}

	// 直接提款跟存款統一的方法
	private BankResponse depositorwithdraw(BankRequest bankRequest, boolean isWithdraw) {
		int newbalance;
		Bank bank = new Bank("AAA", "A123", 1000);// 因為沒有資料庫，所以造假資料。
		// 判定帳密是否合理
		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPassword())) {
			// 判定USER是否key0
			if (bankRequest.getMoneyRange() <= 0) {
				return new BankResponse(bankRequest.getAccount(), "金額小於零，金額錯誤");
			}
			// 判定是否為withdraw業務
			if (isWithdraw) {// 針對【提款】有多一個判斷條件，isWithdraw(提款)==true;!isWithdraw==false;

				// 提款時，要多判斷提款金額不能大於餘額
				if (bank.getAmount() > bankRequest.getMoneyRange()) {
					return new BankResponse(bankRequest.getAccount(), "金額超過此帳號餘額");
				}
//				//等同於上面，邏輯。
//				if (isWithdraw && bank.getAmount() > bankRequest.getMoneyRange()) {
//					return new BankResponse(bankRequest.getAccount(), "金額超過此帳號餘額");
//				}
//				newbalance = bank.getAmount() - bankRequest.getMoneyRange();
				bank.setAmount(bank.getAmount() - bankRequest.getMoneyRange());
				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(), bank.getAmount(),
						"成功扣款");

			} else {// 存款
//				newbalance = bank.getAmount() + bankRequest.getMoneyRange();
				bank.setAmount(bank.getAmount() + bankRequest.getMoneyRange());
				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(), bank.getAmount(),
						"成功存款");
			}
			// 下面這一行，因為要根據存提款有不同字串顯示，所以等於上面兩個return
//			return new BankResponse(bankRequest.getAccount(), bankRequest.getMoneyRange(),
//			bank.getAmount(), "成功存款");

		}
		return new BankResponse(bankRequest.getAccount(), "帳號或密碼錯誤");
	}

	@Override
	public BankResponse addAccount(BankRequest bankRequest) {

		String reqAccount = bankRequest.getAccount();

		if (!StringUtils.hasText(reqAccount) || !StringUtils.hasText(bankRequest.getPwd())) {
			return new BankResponse(reqAccount, "帳號或密碼不得為空");
		}

//		// 檢查帳號是否已經存在
		if (bankDao.existsById(reqAccount)) {
			return new BankResponse(reqAccount, "帳號已存在");

		}

		Bank bank = new Bank(reqAccount, bankRequest.getPwd());
		Bank result = bankDao.save(bank);
		if (StringUtils.hasText(result.getAccount())) {
			return new BankResponse(result.getAccount(), "新增帳號成功");
		}

		return new BankResponse(result.getAccount(), "新增帳號失敗");

	}

	@Override
	public BankResponse updatePassword(BankUpdateRequest bankUpdateRequest) {
		String reqAccount = bankUpdateRequest.getAccount();
		String reqNewPwd = bankUpdateRequest.getNewPassword();
		String reqOldPwd = bankUpdateRequest.getOldPassword();
		if (!StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqNewPwd) 
				|| !StringUtils.hasText(reqOldPwd)) {
			return new BankResponse(reqAccount, "帳號或密碼不得為空");
		}
		Optional<Bank> op = bankDao.findById(reqAccount);
		if (!op.isPresent()) {// 判斷optional中的Bank物件是否存在(包含判斷是否為null)
			return new BankResponse(reqAccount, "帳號不存在");
		}
		// 將optional的Bank取出:前提是Bank物件存在(不能是null)
		Bank bank = op.get();

		// 帳號存在，接著比對該帳號的舊密碼(是否輸入正確)
		if (!reqOldPwd.equals(bank.getPassword())) {
			return new BankResponse(reqAccount, "密碼錯誤");
		}
		// 如果正確密碼(為本人)，修改密碼(設定新密碼回bank)
		bank.setPassword(reqNewPwd);
		// 將新密碼的bank，存回資料庫
		bankDao.save(bank);

		// 回傳新密碼成功
		return new BankResponse(reqAccount, "修改密碼成功");

	}
}
