package com.ashit.autowork.autoworkgeneralashit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashit.autowork.autoworkgeneralashit.entity.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {

}
