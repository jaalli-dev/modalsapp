package com.example.modals2.controllers;

import com.example.modals2.model.Filter;
import com.example.modals2.model.SalesItem;
import com.example.modals2.repository.FilterRepository;
import com.example.modals2.repository.SalesItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class SalesItemController {

    private SalesItemRepository repository;

    private FilterRepository filterRepository;

    public SalesItemController(SalesItemRepository repository, FilterRepository filterRepository) {
        this.repository = repository;
        this.filterRepository = filterRepository;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("api/items")
    public List<SalesItem> getItems() {
        return repository.findAll();
    }

    @GetMapping("api/filters")
    public List<Filter> getFilters() {
        return filterRepository.findAll();
    }

    @GetMapping("api/items/{id}")
    public SalesItem getItemById(@PathVariable Long id) {
        var item = repository.findById(id);
        return item.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("api/filters/{id}")
    public Filter getFilterById(@PathVariable long id) {
        var filter = filterRepository.findById(id);
        return filter.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("api/items-by-filter/{id}")
    public List<SalesItem> getItemsByFilter(@PathVariable long id) {
        Filter filter = getFilterById(id); // get filter from filters database

        return repository.findAllByFilter(filter);
    }

    @PostMapping("api/items-by-filters")
    public List<SalesItem> getItemsByFilters(@Valid @RequestBody long[] ids) {
        List<Filter> filters = filterRepository.findAllByIds(ids);
        return repository.findAllByFilters(filters);
    }

    @PostMapping("api/filters")
    public Filter saveFilter(@Valid @RequestBody Filter filter) {
        filterRepository.save(filter);
        return filter;
    }

    @PostMapping("api/items")
    public SalesItem saveItem(@Valid @RequestBody SalesItem item) {
        System.out.println(item);
        repository.save(item);
        return item;
    }

    @PutMapping("api/items")
    public SalesItem updateItem(@Valid @RequestBody SalesItem item) {
        repository.save(item);
        return item;
    }

    @PutMapping("api/filters")
    public Filter updateFilter(@Valid @RequestBody Filter filter) {
        filterRepository.save(filter);

        return filterRepository.getById(filter.getId());
    }

    @DeleteMapping("api/items/delete/{id}")
    public void deleteItem(@PathVariable long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("api/filters/delete/{id}")
    public void deleteFilter(@PathVariable long id) {
        filterRepository.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<Void> handle(ResponseStatusException e) {
        return new ResponseEntity<>(null, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Void> handle(Exception e) {
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(MethodArgumentNotValidException e) {}

}
