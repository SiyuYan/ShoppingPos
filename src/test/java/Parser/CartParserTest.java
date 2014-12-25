package Parser;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.parser.CartParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2014/12/25.
 */
public class CartParserTest {
    @Test
    public void should_parse_when_give_the_one_data() throws Exception {


        CartParser cartParser = new CartParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001");
        when(reader.ready()).thenReturn(true, false);

        List<Cart> list = cartParser.parser(reader);


        Cart cart = list.get(0);


        assertThat(cart.getItem().getBarcode(), is("ITEM000001"));
        assertThat(cart.getNumber(), is(1));
    }
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        CartParser cartParser = new CartParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000003-2");
        when(reader.ready()).thenReturn(true, false);

        List<Cart> list = cartParser.parser(reader);
        Cart cart = list.get(0);

        assertThat(cart.getItem().getBarcode(), is("ITEM000003"));
        assertThat(cart.getNumber(), is(2));
    }
}
