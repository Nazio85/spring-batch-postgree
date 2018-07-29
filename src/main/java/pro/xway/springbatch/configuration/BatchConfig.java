package pro.xway.springbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import pro.xway.springbatch.batchStep.Listener;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import pro.xway.springbatch.batchStep.Reader;
import pro.xway.springbatch.batchStep.Writer;
//import pro.xway.springbatch.dao.ItemRepository;
import pro.xway.springbatch.dao.ItemRepository;
import pro.xway.springbatch.model.Item;



@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    private ItemRepository itemRepository;

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(50);
        return taskExecutor;
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<Item, Item>chunk(1000)
                .reader(Reader.reader("test_case.csv"))
                .writer(new Writer(itemRepository))
                .taskExecutor(taskExecutor())
                .build();
    }


    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
