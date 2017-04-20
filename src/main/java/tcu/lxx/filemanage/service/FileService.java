package tcu.lxx.filemanage.service;

import tcu.lxx.filemanage.entity.File;

import java.util.List;

/**
 * Created by stanwang on 2017/4/15.
 */
public interface FileService {
    public List<File> getAllFile();
    public List<File> getAllFileVo();
    public int addFile(File file);
    public int deleteFileById(int fileid);

}
