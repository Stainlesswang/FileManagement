package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Role;
import tcu.lxx.filemanage.mapper.RoleMapper;
import tcu.lxx.filemanage.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getUserRole(Integer userId) {
        List<Role> roles = roleMapper.getUserRole(userId);
        return roles;
    }
}
