package com.vk.jodl7.controllers;

import com.vk.jodl7.dto.GoodsDTO;
import com.vk.jodl7.exceptions.NotFoundException;
import com.vk.jodl7.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/{id}")
    public ResponseEntity<GoodsDTO> findById(@PathVariable Long id) throws NotFoundException {
        GoodsDTO goodsDTO = goodsService.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(goodsDTO);
    }

    @GetMapping
    public List<GoodsDTO> findByProductType(@RequestParam(value = "type") String productType) {
        return goodsService.findByProductType(productType);
    }

    @PostMapping("/create")
    public ResponseEntity<String> save(@RequestBody @Valid List<GoodsDTO> goodsDTO) throws NotFoundException {
        goodsService.saveAll(goodsDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Product saved");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid GoodsDTO goodsDTO) throws NotFoundException {
        goodsService.update(goodsDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Product updated");
    }
}