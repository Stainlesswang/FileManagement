package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.File;

import java.util.List;

/**
 * Created by stanwang on 2017/4/14.
 * 每一个方法代表
 */
public interface FileMapper {

    @Select("select * from file")
    public List<File> getAllFile();

    @Insert("INSERT INTO file (type_id,jidu_id,xueyuan_id,office_id,zhuanye_id,course_id,banji_id)\n" +
        "VALUES(#{type_id},#{jidu_id},#{xueyuan_id},#{office_id},#{zhuanye_id},#{course_id},#{banji_id})")
    public int  addFile(File file);
    @Select("select file_id,type_id type,jidu_id jidu,xueyuan_id xueyuan,office_id office,zhuanye_id zhuanye,course_id course," +
            "banji_id banji from file")
    public List<File> getAllFileVo();
    @Delete("delete from file where file_id=#{fileid}")
    public int deleteById(int fileid);
}
