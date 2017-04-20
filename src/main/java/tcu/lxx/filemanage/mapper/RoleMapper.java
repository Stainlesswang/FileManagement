package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.Role;

import java.util.List;

/**
 * Created by stanwang on 2017/4/10.
 */
public interface RoleMapper {
//    SELECT
//    user_id userId,
//    role_id roleId,
//    role_name roleName,
//    role_type roleType
//    FROM
//            role,
//    `user`
//    WHERE
//            user_id = 1
//    AND user_id = role_id
    @Select("SELECT\n" +
            "\tuser_id userId,\n" +
            "  role_id roleId,\n" +
            "  role_name roleName,\n" +
            "\trole_type roleType\n" +
            "FROM\n" +
            "\trole,\n" +
            "\t`user`\n" +
            "WHERE\n" +
            "\tuser_id = #{userId}\n" +
            "AND user_id = role_id")
    public List<Role> getUserRole(Integer userId);

}
