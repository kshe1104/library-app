package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    //JdbcTemplate는 Repository 생성할 때 주입받아야함
    //service에 따로 넘겨줄 필요가 없어야한다.

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) { //생성자주입
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id) {
        String Sql = "SELECT * FROM user WHERE id = ?"; //id기준 유저 존재확인 쿼리
        return jdbcTemplate.query(Sql, (rs, rowNum) -> 0, id).isEmpty();
        //select 쿼리를 DB에 날려서 데이터가 있는지 확인(boolean으로)
    }

    public boolean isUserNotExist(String name) {
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

//    public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id) {
//        String Sql = "SELECT * FROM user WHERE name = ?";
//        return jdbcTemplate.query(Sql, (rs, rowNum) -> 0, id).isEmpty();
//    }


    public void updateUserName(String name, long id) {
        String Sql = "UPDATE user SET name = ? WHERE id =?";
        jdbcTemplate.update(Sql, name, id);
    }

    public void deleteUserByName(String name) {
        String Sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(Sql, name);
    }

    public void saveUser(String name, Integer age) {
        String sql = "INSERT INTO user(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql, name, age);
    }

    public List<UserResponse> getUserResponses(){
                String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new UserResponse(rs.getLong("id"), rs.getString("name"), rs.getInt("age")));
    }
}
