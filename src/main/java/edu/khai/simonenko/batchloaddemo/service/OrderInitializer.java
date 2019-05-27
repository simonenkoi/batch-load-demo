package edu.khai.simonenko.batchloaddemo.service;

import edu.khai.simonenko.batchloaddemo.model.OrderEntity;
import edu.khai.simonenko.batchloaddemo.model.TagEntity;
import edu.khai.simonenko.batchloaddemo.repository.OrderRepository;
import edu.khai.simonenko.batchloaddemo.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class OrderInitializer {

    private final OrderRepository orderRepository;
    private final TagRepository tagRepository;

    @Transactional
    public void initialize() {
        List<OrderEntity> orders = IntStream.rangeClosed(1, 1_000)
                                            .mapToObj(i -> generateOrder())
                                            .collect(Collectors.toList());
        orderRepository.saveAll(orders);
    }

    private OrderEntity generateOrder() {
        List<TagEntity> tags = IntStream.rangeClosed(1, 100)
                                        .mapToObj(i -> generateTag())
                                        .collect(Collectors.toList());
        tagRepository.saveAll(tags);
        return new OrderEntity()
                .setDescription(RandomStringUtils.randomAlphabetic(10))
                .setName(RandomStringUtils.randomAlphabetic(10))
                .setTags(tags);
    }

    private TagEntity generateTag() {
        return new TagEntity().setName(RandomStringUtils.randomAlphabetic(10));
    }

}
