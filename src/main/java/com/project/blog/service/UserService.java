package com.project.blog.service;
import com.project.blog.dao.UserRepository;
import com.project.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//, Service 계층은 Repository(Data Access) 계층에서 데이터를 가져와서 /비즈니스 로직을 수행하고,
// 그 결과를 Controller 계층에 전달합니다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getMessage() {
        Map<String, String> map = userRepository.getMessage();
        return map;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserByUserId(Integer userid) {
        return userRepository.getUserByUserId(userid);
    }

    public User registUser(User user) {
        return userRepository.registUser(user);
    }

    //Update
    public void modifyUser(User user) {
        userRepository.modifyUser(user);
    }

    //Delete
    public void removeUser(Integer userid) {
        userRepository.removeUser(userid);
    }

}
