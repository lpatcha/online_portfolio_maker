package com.portfolio.dao;

import com.portfolio.entity.ActiveUsers;
import com.portfolio.entity.User;

public interface ActiveUser {
   boolean createUpdateActiveUser(ActiveUsers activeUser);
   ActiveUsers findActiveUserByUser(User user);
   void deleteActiveUserById(User user);
   
}
