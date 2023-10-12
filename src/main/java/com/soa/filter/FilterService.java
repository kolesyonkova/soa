package com.soa.filter;

import com.soa.dto.FilterQueryDto;
import com.soa.exception.NotValidParamsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FilterService {
    public static List<String> sortingFields = List.of("id", "name", "x", "y", "difficulty", "minimalPoint", "disciplineName", "selfStudyHours");

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

        if (dto.getSortAsc() == null) {
            dto.setSortAsc(true);
        }

        if (dto.getLimit() != null) {
            checkNumberIsPositive("Limit", dto.getLimit());
        }
        if (dto.getOffset() != null) {
            checkNumberIsNatural("Offset", dto.getOffset());
        }
        if (dto.getSort() != null) {
            checkSortingFields(dto.getSort());
        } else {
            dto.setSort(List.of());
        }
    }

    public static void checkValidName(String name) {
        checkEmpty(name);
        if (name.isEmpty()) {
            throw new NotValidParamsException("Длина имени должна быть больше 0");
        }
    }

    public static void checkNumberIsPositive(String nameOfField, Integer number) {
        if (number <= 0) {
            throw new NotValidParamsException(nameOfField + " должен быть больше 0");
        }
    }

    public static void checkNumberIsNatural(String nameOfField, Integer number) {
        if (number < 0) {
            throw new NotValidParamsException(nameOfField + " должен быть натуральным числом");
        }
    }

    public static void checkEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new NotValidParamsException("Поля не должны быть пустыми");
        }
    }

    public static void checkSortingFields(List<String> fields) {
        for (String field : fields) {
            if (!sortingFields.contains(field))
                throw new NotValidParamsException("Поля не должны быть пустыми");
        }
    }
}
