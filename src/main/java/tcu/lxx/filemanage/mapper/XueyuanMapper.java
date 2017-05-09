package tcu.lxx.filemanage.mapper;


import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.Xueyuan;

import java.util.List;

public interface XueyuanMapper {
    //查询一个学院所包含的所有专业，班级
    @Select("SELECT * FROM xueyuan ")
    @Results(
            id = "zhuanye",
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "id", property = "sub",
                            many = @Many(select = "tcu.lxx.filemanage.mapper.ZhuanyeMapper.findAll"))
            }
    )
    List<Xueyuan> findOneToMany();


    @Select("SELECT * FROM xueyuan WHERE id = #{id}")
    Xueyuan findById(String id);


}
