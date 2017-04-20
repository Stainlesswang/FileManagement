package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.mapper.FileMapper;
import tcu.lxx.filemanage.service.FileService;

import java.util.List;

/**
 * Created by stanwang on 2017/4/15.
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;
    @Override
    public List<File> getAllFile() {
       return fileMapper.getAllFile();
    }

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
}
