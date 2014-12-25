package com.thoughtworks.siyuyan.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/23.
 */
public abstract class Parser<V> {

    public List<V> parse(String path) throws IOException {
        BufferedReader bufferedReader = getBufferedReader(path);
        return parser(bufferedReader);
    }

    public List<V> parser(BufferedReader bufferedReader) throws IOException {
        List<V> valueList = new ArrayList<V>();
        while (bufferedReader.ready()) {
            valueList.add(convert(bufferedReader.readLine()));
        }
        return valueList;
    }


    public BufferedReader getBufferedReader(String path) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(path)));
    }


    public abstract V convert(String line);

}
