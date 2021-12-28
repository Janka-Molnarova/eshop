package sk.metatim.eshop.persistence.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);

    List<Item> findAllByItemCountLessThanEqual(int min);
}
