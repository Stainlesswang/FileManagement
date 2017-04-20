package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.UserInfo;

/**
 * Created by stanwang on 2017/4/10.
 */
public interface UserInfoMapper {
    @Select("SELECT user_id userId ,name,phone,password,dept,sex FROM `user` WHERE name=#{name}")
    public UserInfo getUserByName(String name);
}
