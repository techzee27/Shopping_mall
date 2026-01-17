package com.mall.management.service;

import com.mall.management.entity.Item;
import com.mall.management.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item searchItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
