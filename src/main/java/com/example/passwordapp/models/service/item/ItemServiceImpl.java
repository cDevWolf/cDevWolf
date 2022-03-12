package com.example.passwordapp.models.service.item;

import com.example.passwordapp.models.dao.Items.ItemDao;
import com.example.passwordapp.models.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAllItems() {
        return (List<Item>)itemDao.findAll();
    }
}
