package com.example.jsp.manager.todao;

import com.example.jsp.pojo.Store;

import java.util.List;

/**
 * @author 橙鼠鼠
 */
public interface StoreManagerToDao {
    Integer save(Store store);

    void delete(Integer id);

    Store select(Integer id);

    List<Store> select();

    void update(Store store);

    Integer getId(Store store);
}
