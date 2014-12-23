package Convert;

import com.thoughtworks.siyuyan.model.Item;
import com.thoughtworks.siyuyan.parser.ItemParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ItemConvertTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {
        ItemParser itemParser = new ItemParser();
        Item item = itemParser.convert("ITEM000001:40");

        assertThat(item.getBarcode(), is("ITEM000001"));
        assertThat(item.getPrice(), is(40d));
    }


}
