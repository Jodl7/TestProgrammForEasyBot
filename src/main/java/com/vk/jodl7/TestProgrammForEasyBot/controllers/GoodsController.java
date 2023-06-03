package com.vk.jodl7.TestProgrammForEasyBot.controllers;

import com.vk.jodl7.TestProgrammForEasyBot.DTO.GoodsDTO;
import com.vk.jodl7.TestProgrammForEasyBot.models.Goods;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        System.out.println("working " + id);
        return "showById";
    }

    @GetMapping()
    public List<GoodsDTO> findByProductType() {
        return Goods;
    }

    @PostMapping("/new")
    public String save(@RequestBody @Valid GoodsDTO goodsDTO,
                       BindingResult bindingResult) {
        System.out.println(goodsDTO);
        return "new created";
    }

    @PatchMapping("/update")
    public String update(@RequestBody GoodsDTO goodsDTO) {
        System.out.println(goodsDTO);
        return "updute";
    }

    private Goods convertToGoods (GoodsDTO goodsDTO) {
        return modelMapper.map(goodsDTO, Goods.class);
    }

}