package com.mall.management.service;

import com.mall.management.entity.Mall;
import com.mall.management.repository.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class MallServiceImpl implements MallService {

    @Autowired
    private MallRepository mallRepository;

    @Override
    public Mall addMall(Mall mall) {
        return mallRepository.save(mall);
    }

    @Override
    public Mall updateMall(Mall mall) {
        return mallRepository.save(mall);
    }

    @Override
    public Mall searchMall(Long id) {
        return mallRepository.findById(id).orElse(null);
    }

    @Override
    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    @Override
    public boolean deleteMall(Long id) {
        if (mallRepository.existsById(id)) {
            mallRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
