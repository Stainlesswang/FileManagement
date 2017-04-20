package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Role;
import tcu.lxx.filemanage.entity.UserInfo;
import tcu.lxx.filemanage.mapper.UserInfoMapper;
import tcu.lxx.filemanage.service.RoleService;
import tcu.lxx.filemanage.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanwang on 2017/4/10.
 */
@Service
public class UserInfoService implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    private RoleService roleService;
    public UserInfo getUserByName(String name){
       UserInfo userInfo= userInfoMapper.getUserByName(name);
        return userInfo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo= userInfoMapper.getUserByName(s);
        if (userInfo == null) {
            throw new UsernameNotFoundException(s);
        }

        //根据用户获取用户角色
        List<Role> roles = roleService.getUserRole(userInfo.getUserId());
        //定义权限集合
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        //添加权限到集合中
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleType()));
        }

        //加密密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        User user = new User(userInfo.getName(),bCryptPasswordEncoder.encode(userInfo.getPassword()),true,true,true, true, grantedAuthorities);
        return user;
    }
}
