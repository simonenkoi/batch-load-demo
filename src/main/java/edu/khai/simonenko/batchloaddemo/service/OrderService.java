package edu.khai.simonenko.batchloaddemo.service;

import edu.khai.simonenko.batchloaddemo.model.OrderEntity;
import edu.khai.simonenko.batchloaddemo.model.TagEntity;
import edu.khai.simonenko.batchloaddemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<String> loadTags() {
        return orderRepository.findAll()
                              .stream()
                              .map(OrderEntity::getTags)
                              .flatMap(Collection::stream)
                              .map(TagEntity::getName)
                              .collect(Collectors.toList());
    }

}
