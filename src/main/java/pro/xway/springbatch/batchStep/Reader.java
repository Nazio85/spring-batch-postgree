package pro.xway.springbatch.batchStep;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import pro.xway.springbatch.model.Item;

public class Reader {
    public static FlatFileItemReader<Item> reader(String path) {
        FlatFileItemReader<Item> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<Item>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("ssoid", "date", "grp", "type",
                        "subtype", "url", "orgid", "formid", "code", "ltpa",
                        "sudirresponse", "ymdh");
                setDelimiter(";");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Item>() {{
                setTargetType(Item.class);
            }});
        }});
        return reader;
    }

}
