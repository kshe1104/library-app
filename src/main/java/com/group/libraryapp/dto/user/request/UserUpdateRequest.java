package com.group.libraryapp.dto.user.request;

import com.group.libraryapp.domain.user.User;

public class UserUpdateRequest {
    private String name;
    private Integer age;
    private long id;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}
