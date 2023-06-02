package com.vk.jodl7.TestProgrammForEasyBot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute();
        return "/showById";
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute();
        return "/showAll";
    }

    @PostMapping("/new")
    public String save();
    return"/new";

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute();
        return "goods/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("") @Valid,
                         BindingResult bindingResult,
                         @PathVariable("id") int id);)

    {
        if (bindingResult.hasErrors()) {
            return "goods/edit";
        }
        return "redirect:/goods";

    }


}
