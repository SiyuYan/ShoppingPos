package Convert;

import com.thoughtworks.siyuyan.parser.SecondHalfParser;
import com.thoughtworks.siyuyan.promotions.SecondHalfPromotion;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class SecondConvertTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {
        SecondHalfParser secondHalfParser = new SecondHalfParser();
        Map<String, SecondHalfPromotion> map = secondHalfParser.convert("ITEM000001");
        Iterator it = map.entrySet().iterator();

        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
        assertThat(entry.getKey(), is("ITEM000001"));

    }
}
