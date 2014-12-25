package com.thoughtworks.siyuyan.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.thoughtworks.siyuyan.parser.CartParser;
import com.thoughtworks.siyuyan.util.Parser;

/**
 * Created by Administrator on 2014/12/18.
 */
public class CartParserModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(Parser.class).to(CartParser.class);
    }
}
