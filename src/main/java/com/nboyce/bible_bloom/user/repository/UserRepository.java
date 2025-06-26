package com.nboyce.bible_bloom.user.repository;

import com.nboyce.bible_bloom.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Integer, User> {

}
