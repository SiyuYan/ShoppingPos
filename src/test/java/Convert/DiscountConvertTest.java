package Convert;

import com.thoughtworks.siyuyan.parser.DiscountParser;
import com.thoughtworks.siyuyan.promotions.DiscountPromotion;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DiscountConvertTest {


    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        DiscountParser discountParser = new DiscountParser();
        Map<String, DiscountPromotion> map = discountParser.convert("ITEM000001:75");

        Iterator it = map.entrySet().iterator();
        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();

        assertThat(entry.getKey(), is("ITEM000001"));
        assertThat(map.get(entry.getKey()).getRate(), is(75d));



    }


}
