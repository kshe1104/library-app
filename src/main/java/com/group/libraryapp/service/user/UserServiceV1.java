package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
//    private final UserRepository userRepository;
    private final UserJdbcRepository userRepository;

    public UserServiceV1(UserJdbcRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(UserUpdateRequest request) {
//        String readSql = "SELECT * FROM user WHERE id = ?"; //id기준 유저 존재확인 쿼리
//        boolean isUserNotExist = jdbcTemplate.query(readSql,(rs,rowNum) -> 0,request.getId()).isEmpty();
//        //select 쿼리를 DB에 날려서 데이터가 있는지 확인(boolean으로)

        if(userRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
//        String updateSql = "UPDATE user SET name = ? WHERE id =?";
//        jdbcTemplate.update(updateSql, request.getName(), request.getId());
        userRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if(userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userRepository.deleteUserByName(name);
    }

    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userRepository.getUserResponses();
    }
}
