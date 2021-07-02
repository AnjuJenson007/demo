package com.main.project.java.Repository;

import com.main.project.java.Entity.Product;
import com.main.project.java.Entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByUser(User user, Sort sort);
}
