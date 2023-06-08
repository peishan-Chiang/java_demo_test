package com.example.java_demo_test.vo;

public class BankUpdateRequest {
         private String Account;
         private String oldPassword;
         private String newPassword;
         
		public String getAccount() {
			return Account;
		}
		public void setAccount(String account) {
			Account = account;
		}
		public String getOldPassword() {
			return oldPassword;
		}
		public void setOldPassword(String oldPassword) {
			this.oldPassword = oldPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
         
}
