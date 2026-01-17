package com.mall.management.service;

import com.mall.management.entity.MallAdmin;
import java.util.List;

public interface MallAdminService {
    MallAdmin addMallAdmin(MallAdmin mallAdmin);

    MallAdmin updateMallAdmin(MallAdmin mallAdmin);

    MallAdmin searchMallAdmin(Integer id);

    List<MallAdmin> getAllMallAdmins();

    boolean deleteMallAdmin(Integer id);
}
