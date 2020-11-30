/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import java.util.List;

/**
 *
 * @author huyNQph11019
 */
public interface DAOhelper<T, V> { // là type và value

    public int insert(T e);

    public int update(T e);

    public int delete(V id);

    public List<T> selectall();

    public T selectbyID(V id);

    public List<T> selectbysomething(V id);

    public List<T> selectbySQL(String sql, Object... args);
}
