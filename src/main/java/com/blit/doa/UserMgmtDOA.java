package com.blit.doa;

import com.blit.model.User;

public interface UserMgmtDOA {

	 User getbyUserName(String Username);

	User registerUser(User user);

}
