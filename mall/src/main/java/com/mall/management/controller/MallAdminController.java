package com.mall.management.controller;

import com.mall.management.entity.MallAdmin;
import com.mall.management.service.MallAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mallAdmin")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    @PostMapping
    public MallAdmin addMallAdmin(@RequestBody MallAdmin mallAdmin) {
        return mallAdminService.addMallAdmin(mallAdmin);
    }

    @PutMapping
    public MallAdmin updateMallAdmin(@RequestBody MallAdmin mallAdmin) {
        return mallAdminService.updateMallAdmin(mallAdmin);
    }

    @GetMapping("/{id}")
    public MallAdmin searchMallAdmin(@PathVariable Integer id) {
        return mallAdminService.searchMallAdmin(id);
    }

    @GetMapping
    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminService.getAllMallAdmins();
    }

    @DeleteMapping("/{id}")
    public String deleteMallAdmin(@PathVariable Integer id) {
        boolean isDeleted = mallAdminService.deleteMallAdmin(id);
        if (isDeleted) {
            return "MallAdmin deleted successfully";
        } else {
            return "MallAdmin not found";
        }
    }
}
