package Parser;

import com.thoughtworks.siyuyan.parser.DiscountParser;
import com.thoughtworks.siyuyan.promotions.DiscountPromotion;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Created by Administrator on 2014/12/17.
 */
public class DiscountParserTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        DiscountParser discountParser = new DiscountParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001:75");
        when(reader.ready()).thenReturn(true, false);

        List<Map<String, DiscountPromotion>> list = discountParser.parser(reader);


        Map<String, DiscountPromotion> promotionMap = list.get(0);
        Iterator<String> iter = promotionMap.keySet().iterator();
        String barcode = iter.next();
        DiscountPromotion discountPromotion = promotionMap.get(barcode);

        assertThat(barcode, is("ITEM000001"));
        assertEquals(discountPromotion.getRate(), 75d, 0.00001);

    }

}
