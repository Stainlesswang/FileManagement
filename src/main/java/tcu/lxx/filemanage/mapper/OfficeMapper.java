package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.Office;

import java.util.List;

public interface OfficeMapper {

    @Select("select * from office")
    List<Office> findOfficeAll();
}
