package jsonplaceholder;

import jsonplaceholder.models.UserData;
import org.testng.Assert;

import java.util.List;

public class Asserts {
    public void verifyIdsAscendingOrder(List<UserData> list) {
        int previousId = 0;
        for (UserData post : list) {
            Assert.assertTrue(post.getId() > previousId);
            previousId = post.getId();
        }
    }
}
