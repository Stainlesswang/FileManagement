package tcu.lxx.filemanage.service;


import tcu.lxx.filemanage.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 根据用户ID获取用户角色
     *
     * @param userId
     * @return
     */
    public List<Role> getUserRole(Integer userId);
}
