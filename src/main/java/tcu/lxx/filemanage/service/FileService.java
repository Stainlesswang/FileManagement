package tcu.lxx.filemanage.service;

import tcu.lxx.filemanage.entity.File;

import java.util.List;

public interface FileService {

//查询所有file里边的集合
    public List<File> getAllFileVo();

    public int addFile(File file);

    public int deleteFileById(int fileid);
    public File selctById(int fileid);
    public int update(File file);

}
