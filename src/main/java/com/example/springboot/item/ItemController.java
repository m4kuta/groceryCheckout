package com.example.springboot.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public Item addNewItem(@RequestBody Item item) {
        return itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long itemId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) Integer stock,
                           @RequestParam(required = false) Double price) {
        itemService.updateItem(itemId, name, description, stock, price);
    }
}
