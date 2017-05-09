package tcu.lxx.filemanage.mapper;


import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.Banji;

public interface BanjiMapper {


    @Select("select * from banji where zhuanye=#{id}")
    Banji findBanjiById(String id);
}
