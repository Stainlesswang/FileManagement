package tcu.lxx.filemanage.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.Type;

import java.util.List;

public interface TypeMapper {
    @Insert("INSERT INTO type (type_id,type)\n" +
            "VALUES(#{type_id},#{type})")
    public int addType(Type type);

    @Delete("delete from type where type_id=#{typeid}")
    public int deleteById(String typeid);

    @Update("update type set type_id=#{type_id},type=#{type}" +
            " where type_id=#{type_id}")
    public int update(Type type);


    @Select("select * from type")
    List<Type> findTypeAll();
}
