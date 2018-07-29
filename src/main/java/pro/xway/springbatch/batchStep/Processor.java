package pro.xway.springbatch.batchStep;

import org.springframework.batch.item.ItemProcessor;
import pro.xway.springbatch.model.Item;

public class Processor implements ItemProcessor<Item, Item> {

    @Override
    public Item process(Item item) {
        return item;
    }
}
