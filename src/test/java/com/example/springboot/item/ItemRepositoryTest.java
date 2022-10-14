package com.example.springboot.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void itemExistsByName() {
        String itemName = "Peanut Butter";
        Item item = new Item(1000L, itemName, "Smooth", 100, 5.99);

        itemRepository.save(item);

        boolean found = itemRepository.itemExistsByName(itemName);

        assertThat(found).isEqualTo(true);
    }

    @Test
    void findItemByName() {
        String itemName = "Peanut Butter";
        Item item = new Item(1000L, itemName, "Smooth", 100, 5.99);

        itemRepository.save(item);

        Optional<Item> found = itemRepository.findItemByName(itemName);

        assertThat(found.get().getName()).isEqualTo(item.getName());
    }
}