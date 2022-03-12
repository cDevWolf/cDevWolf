package com.example.passwordapp.models.dao.Items;
import com.example.passwordapp.models.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface ItemDao extends CrudRepository<Item,Long>{

}
