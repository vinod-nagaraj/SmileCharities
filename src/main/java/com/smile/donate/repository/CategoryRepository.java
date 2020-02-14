package com.smile.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smile.donate.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
