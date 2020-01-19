package com.am.training.demo.repository;

import com.am.training.demo.entity.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataItemRepository extends JpaRepository<DataItem, Integer> {


}
