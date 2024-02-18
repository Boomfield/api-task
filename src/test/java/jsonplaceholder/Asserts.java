package jsonplaceholder;

import jsonplaceholder.models.UserData;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Asserts {
    private SoftAssert softAssert;

    public Asserts() {
        this.softAssert = new SoftAssert();
    }

    public void verifyIdsAscendingOrder(List<UserData> list) {
        int previousId = 0;
        for (UserData post : list) {
            softAssert.assertTrue(post.getId() > previousId);
            previousId = post.getId();
        }
    }
}
