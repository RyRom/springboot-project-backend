package com.practice.controllers;

import java.util.List;
import java.util.Optional;

import com.practice.domain.Drink;
import com.practice.repositories.DrinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {
    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping
    public List<Drink> list() {
        return drinkRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Drink> get(@PathVariable Long id) {
        return drinkRepository.findById(id);
    }

    @PostMapping
    public Drink create(@RequestBody final Drink drink) {
        return drinkRepository.saveAndFlush(drink);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        drinkRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Drink update(@PathVariable Long id, @RequestBody Drink drink) {
        // Because this is a PUT, we expect all attributes to be passed in. A PATCH
        // would only need what is being updated.
    }
}