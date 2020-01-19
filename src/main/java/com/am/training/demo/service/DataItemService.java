package com.am.training.demo.service;

import com.am.training.demo.entity.DataItem;
import com.am.training.demo.exception.DataItemNotFoundException;
import com.am.training.demo.exception.EmptyListException;

import java.time.LocalDate;
import java.util.List;

public interface DataItemService {

    DataItem find(Integer id) throws DataItemNotFoundException;

    DataItem save(DataItem dataRow);

    List<DataItem> findDataItems();



    void save(List<DataItem> dataRows);

    String getMostTalksPerYear(LocalDate start, LocalDate end);

    String getTheTalkerByTopic(String topic);

    String getTheMinimalWordsPerTalk();

}
