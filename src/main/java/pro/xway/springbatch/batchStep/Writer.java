package pro.xway.springbatch.batchStep;

import org.springframework.batch.item.ItemWriter;
import pro.xway.springbatch.dao.ItemRepository;
import pro.xway.springbatch.model.Item;

import java.util.List;

public class Writer implements ItemWriter<Item> {
    private final ItemRepository itemRepository;

    public Writer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void write(List<? extends Item> items) {
        itemRepository.saveAll(items);
    }
}
