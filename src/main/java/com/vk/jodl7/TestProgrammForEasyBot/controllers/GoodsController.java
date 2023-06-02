package com.vk.jodl7.TestProgrammForEasyBot.controllers;

import com.vk.jodl7.TestProgrammForEasyBot.DTO.EmptyObject;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/{id}")
    public String showById(@PathVariable Long id) {
        System.out.println("working " + id);
        return "showById";
    }

    @GetMapping()
    public String showAll() {
        return "/showAll";
    }

    @PostMapping("/new")
    public String save(@RequestBody EmptyObject empty) {
        System.out.println(empty);
        return "new created";
    }

    @PatchMapping("/update")
    public String update(@RequestBody EmptyObject empty) {
        System.out.println(empty);
        return "updute";
    }
}