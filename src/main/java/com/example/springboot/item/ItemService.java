package com.example.springboot.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item addNewItem(Item item) {
        Optional<Item> optionalItem = itemRepository.findItemByName(item.getName());
        if (optionalItem.isPresent()) {
            throw new IllegalStateException("Item already exists");
        }
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException("Item with id " + itemId + " does not exists");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId, String name, String description, Integer stock, Double price) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id " + itemId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(item.getName(), name)) {
            Optional<Item> optionalItem = itemRepository.findItemByName(item.getName());
            if (optionalItem.isPresent()) {
                throw new IllegalStateException("Item already exists");
            }
            item.setName(name);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(item.getDescription(), description)) {
            item.setDescription(description);
        }

        if (stock != null &&
                !Objects.equals(item.getStock(), stock)) {
            item.setStock(stock);
        }

        if (price != null &&
                !Objects.equals(item.getPrice(), price)) {
            item.setPrice(price);
        }
    }
}
