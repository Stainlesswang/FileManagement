package tcu.lxx.filemanage.service;

import tcu.lxx.filemanage.entity.Office;

import java.util.List;

public interface OfficeService {
    public int addOffice(Office office);
    public int deleteById(String officeid);
    public int update(Office office);
    List<Office> findOfficeAll();
}
