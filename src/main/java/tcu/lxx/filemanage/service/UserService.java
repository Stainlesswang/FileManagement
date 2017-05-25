package tcu.lxx.filemanage.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import tcu.lxx.filemanage.entity.UserInfo;

public interface UserService extends UserDetailsService {

    /**
     * 根据用户名获取用户
     *
     * @param userName
     * @return
     */
    //只是声明
    public UserInfo getUserByName(String userName);
    public int addUser(UserInfo userInfo);

}
