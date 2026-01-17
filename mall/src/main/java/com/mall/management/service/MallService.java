package com.mall.management.service;

import com.mall.management.entity.Mall;
import java.util.List;

public interface MallService {
    Mall addMall(Mall mall);

    Mall updateMall(Mall mall);

    Mall searchMall(Long id);

    List<Mall> getAllMalls();

    boolean deleteMall(Long id);
}
