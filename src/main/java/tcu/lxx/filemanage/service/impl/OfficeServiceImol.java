package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.mapper.OfficeMapper;
import tcu.lxx.filemanage.service.OfficeService;

import java.util.List;

@Service
public class OfficeServiceImol implements OfficeService {
    @Autowired
    OfficeMapper officeMapper;

    @Override
    public int addOffice(Office office) {
        return officeMapper.addOffice(office);
    }

    @Override
    public int deleteById(String officeid) {
        return officeMapper.deleteById(officeid);
    }

    @Override
    public int update(Office office) {
        return officeMapper.update(office);
    }

    @Override
    public List<Office> findOfficeAll() {
        return officeMapper.findOfficeAll();
    }
}
