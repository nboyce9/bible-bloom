package com.nboyce.bible_bloom.user.repository;

import com.nboyce.bible_bloom.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Integer, User> {

}
