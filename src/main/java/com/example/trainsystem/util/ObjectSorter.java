package com.example.trainsystem.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectSorter<T> {

    public void sort(List<T> list, Comparator<T> comparator) {
        Collections.sort(list, comparator);
    }

}
