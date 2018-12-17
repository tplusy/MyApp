package top.plusy.myapp.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WangHui
 * Date: 2018/12/17.
 */
public class SimpleData <T> {
    int dataType;
    public List<T> dataList;

    public SimpleData(int type) {
        this.dataType = type;
        dataList = new ArrayList<>();
    }
}
