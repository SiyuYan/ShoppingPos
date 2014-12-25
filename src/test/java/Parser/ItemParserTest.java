package Parser;

import com.thoughtworks.siyuyan.model.Item;
import com.thoughtworks.siyuyan.parser.ItemParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2014/12/25.
 */
public class ItemParserTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        ItemParser itemParser = new ItemParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001:40");
        when(reader.ready()).thenReturn(true, false);

        List<Item> list = itemParser.parser(reader);

        Item item = list.get(0);

        assertThat(item.getBarcode(), is("ITEM000001"));
        assertEquals(item.getPrice(), 40d, 0.00001);

    }

}
