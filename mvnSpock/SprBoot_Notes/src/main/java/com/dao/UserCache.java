package com.dao;

import com.model.User;

/**
 * @author Ivan Khalopik
 */
public interface UserCache {

  User getUser(String name);

  void invalidate();
}
