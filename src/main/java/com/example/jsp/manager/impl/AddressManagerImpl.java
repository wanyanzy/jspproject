package com.example.jsp.manager.impl;

import com.example.jsp.dao.AddressDao;
import com.example.jsp.manager.todao.AddressManagerToDao;
import com.example.jsp.manager.toservice.AddressManager;
import com.example.jsp.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 橙鼠鼠
 */
@Service
public class AddressManagerImpl implements AddressManagerToDao, AddressManager {
    private AddressDao addressDao;

    @Override
    public List<Address> select() {
        return addressDao.selectAll();
    }

    @Override
    public Address select(int id) {
        return addressDao.selectById(id);
    }

    @Override
    /**@apiNote :会在数据库寻找是否有相同的数据,如果有则返回那个数据的id,反之则返回新插入数据的id
     * */
    public int insert(Address address) {
        Integer id = addressDao.getId(address);
        return Objects.requireNonNullElseGet(id, () -> addressDao.save(address));
    }

    @Override
    public void destroy(Address address) {
        addressDao.delete(address.getId());
    }

    @Override
    public void destroy(int id) {
        addressDao.delete(id);
    }

    @Override
    public int restore(Address address) {
        Integer id = addressDao.getId(address);
        if (id == null) {
            addressDao.update(address);
            return 0;
        }
        return id.intValue();
    }

    @Override
    public int save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public void delete(int id) {
        addressDao.delete(id);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);
    }

    @Override
    public List<Address> selectByGuestId(int id) {
        return addressDao.selectByGuestId(id);
    }

    @Override
    public void dropByGuestId(int id) {
        addressDao.dropByGuestId(id);
    }

    @Override
    public boolean isNotExist(int id) {
        return addressDao.selectById(id) == null;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
