package ru.test.homework.dz17;

import org.springframework.data.domain.Sort;

public class SortDTO {
    private String sortBy;
    private String sortDirection;

    public Sort toSpringSort() {
        if (sortBy == null || sortBy.isEmpty()) {
            return Sort.unsorted();
        }
        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortDirection)) {
            direction = Sort.Direction.DESC;
        }
        return Sort.by(direction, sortBy);
    }
}