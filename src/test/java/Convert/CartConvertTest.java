package Convert;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.parser.CartParser;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class CartConvertTest {

    CartParser cartParser;
    @Before
    public void setUp() throws Exception {
        cartParser = new CartParser();
    }
    @Test
    public void should_parse_correctly_when_give_the_shopping_cart_data_with_amount() throws Exception {
        CartParser cartParser = new CartParser();
        Cart item = cartParser.convert("ITEM000001-3");
        assertThat(item.getItem().getBarcode(), is("ITEM000001"));
        assertThat(item.getNumber(), is(3));
    }
    @Test
    public void should_parse_correctly_when_give_the_shopping_cart_data_without_amount() throws Exception {
        Cart item = cartParser.convert("ITEM000005");
        assertThat(item.getItem().getBarcode(), is("ITEM000005"));
        assertThat(item.getNumber(), is(1));
    }


}
