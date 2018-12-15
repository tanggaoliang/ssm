package com.how2java.util;

import com.how2java.service.impl.CategoryServiceImpl;

public class Page {
    int start = 0;
    int count = 5;
    int last = 0;
//    int total = new CategoryServiceImpl().total();

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start <= 0) {
            start = 0;
        }
//        if (start >= total) {
//            start = calculateLast(total);
//        }
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void calculateLast(int total) {
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }
}
