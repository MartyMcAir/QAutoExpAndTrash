package com.dao;

import com.model.User;

import java.util.List;

/**
 * @author Ivan Khalopik
 */
public interface UserDAO {

  List<User> findAll();
}