package com.itcast.service.impl;

import com.itcast.dao.UserInfoDao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void addRoleToUser(String userid, String[] roleids) {
        for (String roleid : roleids) {
            Map<String,String> parmtMap = new HashMap<String, String>();
            parmtMap.put("userid",userid);
            parmtMap.put("roleid",roleid);
           userInfoDao.addRoleToUser(parmtMap);
        }
    }

    @Override
    public List<Role> findOtherRole(String userId) {
        return userInfoDao.findOtherRole(userId);
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoDao.findById(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoDao.save(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoDao.findByUsername(username);
        User user = new User(userInfo.getUsername(), userInfo.getPassword()
                , userInfo.getStatus() == 0 ? false : true, true,
                true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

//    public static void main(String[] args) {
//        String en = new BCryptPasswordEncoder().encode("123");
//        System.out.println(en);
//    }
}
