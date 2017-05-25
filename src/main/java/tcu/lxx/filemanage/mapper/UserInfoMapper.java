package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.entity.UserInfo;

public interface UserInfoMapper {
    @Select("SELECT user_id userId ,name,phone,password,dept,sex FROM `user` WHERE name=#{name}")
    public UserInfo getUserByName(String name);
    @Insert("INSERT INTO user \n" +
            "(name,phone,password,dept,sex)\n" +
            "VALUES\n" +
            "(#{name},#{phone},#{password},#{dept},#{sex})")
    public int addUser(UserInfo userInfo);

}


