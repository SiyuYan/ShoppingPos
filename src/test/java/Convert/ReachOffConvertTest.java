package Convert;

import com.thoughtworks.siyuyan.parser.ReachOffParser;
import com.thoughtworks.siyuyan.promotions.ReachOffPromotion;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ReachOffConvertTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {
        ReachOffParser reachOffParser = new ReachOffParser();
        Map<String, ReachOffPromotion> map = reachOffParser.convert("ITEM000001:100:5");
        Iterator it = map.entrySet().iterator();

        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
        assertThat(entry.getKey(), is("ITEM000001"));
        assertThat(map.get(entry.getKey()).getReach(), is(100d));
        assertThat(map.get(entry.getKey()).getOff(), is(5d));
    }
}
