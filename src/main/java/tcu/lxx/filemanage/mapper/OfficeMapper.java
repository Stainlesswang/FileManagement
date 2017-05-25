package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.entity.Office;

import java.util.List;

public interface OfficeMapper {
    @Insert("INSERT INTO office (office_id,office,pid)\n" +
            "VALUES(#{office_id},#{office},#{pid})")
    public int addOffice(Office office);

    @Delete("delete from office where office_id=#{officeid}")
    public int deleteById(String officeid);

    @Update("update office set office_id=#{office_id},office=#{office},pid=#{pid}" +
            " where office_id=#{office_id}")
    public int update(Office office);


    @Select("select * from office")
    List<Office> findOfficeAll();
}
