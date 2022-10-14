package com.example.springboot.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.name = ?1")
    Optional<Item> findItemByName(String name);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Item i " +
            "WHERE i.name = ?1")
    Boolean itemExistsByName(String name);
}
