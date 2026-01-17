package com.mall.management.controller;

import com.mall.management.entity.Mall;
import com.mall.management.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mall")
public class MallController {

    @Autowired
    private MallService mallService;

    @PostMapping
    public Mall addMall(@RequestBody Mall mall) {
        return mallService.addMall(mall);
    }

    @PutMapping
    public Mall updateMall(@RequestBody Mall mall) {
        return mallService.updateMall(mall);
    }

    @GetMapping("/{id}")
    public Mall searchMall(@PathVariable Long id) {
        return mallService.searchMall(id);
    }

    @GetMapping
    public List<Mall> getAllMalls() {
        return mallService.getAllMalls();
    }

    @DeleteMapping("/{id}")
    public String deleteMall(@PathVariable Long id) {
        boolean isDeleted = mallService.deleteMall(id);
        if (isDeleted) {
            return "Mall deleted successfully";
        } else {
            return "Mall not found";
        }
    }
}
