package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.*;
import tcu.lxx.filemanage.entity.Zhuanye;

public interface ZhuanyeMapper {


    @Select("select * from zhuanye where xueyuan=#{id}")
    @Results(
            id = "zhaunye",
            value = {
                    @Result(column = "id", property = "id"),

                    @Result(column = "name", property = "name"),
                    @Result(column = "id", property = "sub", many =
                    @Many(select = "tcu.lxx.filemanage.mapper.BanjiMapper.findBanjiById")),

            }
    )
    Zhuanye findAll(String id);

    @Select("SELECT * FROM Zhuanye WHERE xueyuan = #{id}")
    Zhuanye findManyToOne(String id);

}
