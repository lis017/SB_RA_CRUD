package com.project.blog.dao;   //dao가 crud 하는놈

import com.project.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository //이 클래스를 bean(객체)로 등록함.
public class UserRepository {

    public static List<User> users; //users엔 null이 있음

    static {
        users = new ArrayList<>();  //이 코드를 통해 List틀이 만들어지고, 그 후 내용물 추가 가능
        users.add(new User(100,"kim" ));
        users.add(new User(200,"lee" ));
        users.add(new User(300,"choi" ));
        users.add(new User(400,"park" ));
        users.add(new User(500,"kwon" ));
        users.add(new User(600,"hong" ));
        System.out.println(users);  //이거 없어도 출력 잘만 됨 //잘 되는지 콘솔에서 보는 확인용
    }

    public Map<String, String> getMessage() {
        return null;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUserByUserId(Integer userid) {
        return users.stream()
                .filter(x -> x.getUserid().equals(userid))
                .findFirst()
                .orElse(new User(0, "Not Available"));
    }

    public User registUser(User user) {
        users.add(user);
        return user;
    }

    //Update
    public void modifyUser(User user) {
        users.stream()
                .filter(item->item.getUserid().equals(user.getUserid()))
                .findAny()
                .orElse(new User(0, "no user"))
                .setUsername(user.getUsername());
    }

    //Delete
    public void removeUser(Integer userid) {
        users.removeIf(user -> user.getUserid().equals(userid));
    }
}
