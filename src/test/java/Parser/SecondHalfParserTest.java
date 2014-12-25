package Parser;

import com.thoughtworks.siyuyan.parser.SecondHalfParser;
import com.thoughtworks.siyuyan.promotions.SecondHalfPromotion;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2014/12/25.
 */
public class SecondHalfParserTest {

    @Test
    public void should_parse_when_give_the_item_data() throws Exception {


        SecondHalfParser secondHalfParser = new SecondHalfParser();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001");
        when(reader.ready()).thenReturn(true, false);

        List<Map<String, SecondHalfPromotion>> list = secondHalfParser.parser(reader);


        Map<String, SecondHalfPromotion> promotionMap = list.get(0);
        assertThat(promotionMap.keySet().iterator().next(), is("ITEM000001"));


    }

}
