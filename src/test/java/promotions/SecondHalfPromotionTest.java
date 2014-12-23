package promotions;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.promotions.SecondHalfPromotion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Administrator on 2014/12/7.
 */
public class SecondHalfPromotionTest {
    @Test
    public void should_SecondHalf_when_item_is_SeconHalf_and_numbers_is_bigger_than_two() throws Exception

    {
        SecondHalfPromotion secondHalfPromotion = new SecondHalfPromotion("Item0000000001");
        Cart item = secondHalfPromotion.calculate(new Cart("Item0000000001", 50, 5));
        assertEquals(item.getTotal(), new Double(50 + 25 + 50 + 25 + 50));
    }

    @Test
    public void should_not_SecondHalf_when_item_is_SeconHalf_and_numbers_is_less_than_two() throws Exception {

        SecondHalfPromotion secondHalfPromotion2 = new SecondHalfPromotion("Item0000000002");
        Cart item2 = secondHalfPromotion2.calculate(new Cart("Item0000000002", 50, 1));
        assertEquals(item2.getTotal(), new Double(50));


    }




}

