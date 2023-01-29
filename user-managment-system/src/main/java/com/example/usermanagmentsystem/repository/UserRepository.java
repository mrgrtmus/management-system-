package com.example.usermanagmentsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.usermanagmentsystem.model.User;
@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

}
