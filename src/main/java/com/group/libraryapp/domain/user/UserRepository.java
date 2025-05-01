package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name); //알아서 쿼리문을 작성해줌

//    User findALlByAgeBetween(int startAge, int endAge);
}
