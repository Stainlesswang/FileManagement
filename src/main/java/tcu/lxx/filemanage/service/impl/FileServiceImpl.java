package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.mapper.FileMapper;
import tcu.lxx.filemanage.service.FileService;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;
//查询所有file记录
    @Override
    public List<File> getAllFileVo() {
        return fileMapper.getAllFileVo();
    }

    @Override
    public int addFile(File file) {
        return fileMapper.addFile(file);

    }

    @Override
    public int deleteFileById(int fileid) {
        return fileMapper.deleteById(fileid);

    }

    @Override
    public File selctById(int fileid) {
        return fileMapper.selctById(fileid);
    }

    @Override
    public int update(File file) {

        return fileMapper.update(file);
    }


}
