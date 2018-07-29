package pro.xway.springbatch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.xway.springbatch.dao.ItemRepository;
import pro.xway.springbatch.model.Item;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    public long getSizeData() {
        return itemRepository.count();
    }

    public String convertData() {
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    public List<Item> getUserForReportForOne() {
        Set<String> set = new HashSet<>();
        //todo похорошему сортировать надо на уровне базы
        List<Item> list = itemRepository.findAll()
                .stream()
                .filter(item -> set.add(item.getSsoid()))
                .filter(item -> !item.getSsoid().equals("Unauthorized"))
                .collect(Collectors.toList());

        //TODO Для сортировки по дате
        for (Item item : itemRepository.findAll()) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH");
                Date oldDate = formatter.parse(item.getYmdh());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public List<Item> getUserForReportForTwo() {
        List<Item> list = itemRepository.findAllBySubtypeNotContains("send");
        System.out.println(itemRepository.findAll().size());
        System.out.println(list.size());
        return list;
    }

    public List<Map.Entry<String, Long>> getUserForReportForThree() {
        List<Item> listAllItem = itemRepository.findAll();
        Map<String, Long> collect = listAllItem.stream().collect(Collectors.groupingBy(Item::getFormid, Collectors.counting()));

        List<Map.Entry<String, Long>> listTopForm = collect.entrySet().stream()
                .filter(stringLongEntry -> !stringLongEntry.getKey().isEmpty())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

        return listTopForm.stream().limit(5).collect(Collectors.toList());
    }
}
