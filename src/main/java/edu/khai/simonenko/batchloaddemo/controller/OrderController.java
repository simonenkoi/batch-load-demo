package edu.khai.simonenko.batchloaddemo.controller;

import edu.khai.simonenko.batchloaddemo.service.OrderInitializer;
import edu.khai.simonenko.batchloaddemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderInitializer orderInitializer;

    @GetMapping("tags")
    public List<String> loadTags() {
        return orderService.loadTags();
    }

    @GetMapping("init")
    public void init() {
        orderInitializer.initialize();
    }
}
