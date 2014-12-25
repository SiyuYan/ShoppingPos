package Parser;

import com.thoughtworks.siyuyan.parser.ReachOffParser;
import com.thoughtworks.siyuyan.promotions.ReachOffPromotion;
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
 * Created by Administrator on 2014/12/25.
 */
public class ReachOffParserTest {

    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        ReachOffParser reachOffParser = new ReachOffParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001:100:5");
        when(reader.ready()).thenReturn(true, false);

        List<Map<String, ReachOffPromotion>> list = reachOffParser.parser(reader);

        Map<String, ReachOffPromotion> promotionMap = list.get(0);
        Iterator<String> iter = promotionMap.keySet().iterator();
        String barcode = iter.next();
        ReachOffPromotion reachOffPromotion = promotionMap.get(barcode);

        assertThat(barcode, is("ITEM000001"));
        assertEquals(reachOffPromotion.getReach(),100d, 0.00001);
        assertEquals(reachOffPromotion.getOff(), 5d, 0.00001);

    }

}
