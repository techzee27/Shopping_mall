package com.mall.management.service;

import com.mall.management.entity.MallAdmin;
import com.mall.management.repository.MallAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class MallAdminServiceImpl implements MallAdminService {

    @Autowired
    private MallAdminRepository mallAdminRepository;

    @Override
    public MallAdmin addMallAdmin(MallAdmin mallAdmin) {
        return mallAdminRepository.save(mallAdmin);
    }

    @Override
    public MallAdmin updateMallAdmin(MallAdmin mallAdmin) {
        return mallAdminRepository.save(mallAdmin);
    }

    @Override
    public MallAdmin searchMallAdmin(Integer id) {
        return mallAdminRepository.findById(id).orElse(null);
    }

    @Override
    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminRepository.findAll();
    }

    @Override
    public boolean deleteMallAdmin(Integer id) {
        if (mallAdminRepository.existsById(id)) {
            mallAdminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
