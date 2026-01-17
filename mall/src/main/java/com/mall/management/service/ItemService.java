package com.mall.management.service;

import com.mall.management.entity.Item;
import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    Item updateItem(Item item);

    Item searchItem(Long id);

    List<Item> getAllItems();

    boolean deleteItem(Long id);
}
