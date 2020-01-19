package com.am.training.demo.util.mapper;

import com.am.training.demo.dto.DataRowDTO;
import com.am.training.demo.entity.DataItem;

/**
 * PersonMapper is a class that converts Person into PersonDTO and vice versa, and List<Person> into List<PersonDTO> and vice versa
 */
public class DataItemMapper {

    /**
     * Constructor of the class
     */
    private DataItemMapper() {

    }

    public static DataRowDTO ConvertToDto(DataItem dataRow) {

        return new DataRowDTO(dataRow.getRedner(), dataRow.getThema(), dataRow.getDatum(), dataRow.getWoerter());
    }

    public static DataItem ConvertToDataRow(DataRowDTO dataRowDTO) {
        return new DataItem(null, dataRowDTO.getRedner(), dataRowDTO.getThema(), dataRowDTO.getDatum(), dataRowDTO.getWoerter());
    }


}
