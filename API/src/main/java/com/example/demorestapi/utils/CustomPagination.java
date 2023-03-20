package com.example.demorestapi.utils;

import java.util.List;
import java.util.stream.Collectors;

public class CustomPagination {

    public static <T> AppPage<T> getAppPage(List<T> sourceList, int pageNumber, int pageSize){
        if(pageSize <= 0)
            pageSize = 10;
        if (pageNumber <= 0)
            pageNumber = 0;
        if (pageSize > sourceList.size()) {
            pageSize = sourceList.size();
        }
        int skipCount = pageNumber > 0 ? pageNumber * pageSize : 0;
        List<T> pagingList = sourceList.stream()
                .skip(skipCount)
                .limit(pageSize)
                .collect(Collectors.toList());
        return new AppPage<>(pageNumber, pageSize, sourceList.size(), pagingList);
    }


}
