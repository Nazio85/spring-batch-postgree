package pro.xway.springbatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pro.xway.springbatch.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository <Item, Long> {
    List<Item> findAllBySubtypeNotContains(String type);
}