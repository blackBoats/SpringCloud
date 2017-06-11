package com.fk.microservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fk.microservice.user.vo.IUserVO;

@Repository
public interface UserDao extends JpaRepository<IUserVO, Long>{

}
