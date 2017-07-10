package com.example.demo.Dao;

import com.example.demo.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xy on 2017/7/10.
 */
@Transactional
public interface AdminDao extends JpaRepository<Admin,Long>{
}
