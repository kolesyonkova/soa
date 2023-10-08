package com.soa.filter;

import com.soa.dto.FilterQueryDto;
import com.soa.exception.NotValidParamsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterService {
    public static void isValidRequestParams(FilterQueryDto dto) {
        if (dto.getId() != null) {
            dto.getId().forEach(id -> checkNumberIsPositive("Id", id));
        }
        if (dto.getMinimalPoint() != null) {
            dto.getMinimalPoint().forEach(point -> checkNumberIsPositive("MinimalPoint", point));
        }
        if (dto.getName() != null) {
            dto.getName().forEach(FilterService::checkValidName);
        }

        if (dto.getSort() != null) {
            checkSortParams(dto.getSort());
        }

        if (dto.getLimit() != null) {
            checkNumberIsPositive("Limit", dto.getLimit());
        }
        if (dto.getOffset() != null) {
            checkNumberIsPositive("Offset", dto.getOffset());
        }
    }

    public static void checkValidName(String name) {
        checkEmpty(name);
        if (name.length() <= 0) {
            throw new NotValidParamsException("Длина имени должна быть больше 0");
        }
    }

    public static void checkSortParams(String sort) {
        checkEmpty(sort);
        if (!(sort.equals("asc") || sort.equals("desc"))) {
            throw new NotValidParamsException("Неверный параметр сортировки");
        }
    }

    public static void checkNumberIsPositive(String nameOfField, Integer number) {
        if (number <= 0) {
            throw new NotValidParamsException(nameOfField + " должен быть больше 0");
        }
    }

    public static void checkEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new NotValidParamsException("Поля не должны быть пустыми");
        }
    }
}
