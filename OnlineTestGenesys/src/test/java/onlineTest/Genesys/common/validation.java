package onlineTest.Genesys.common;

import onlineTest.Genesys.Utils.APIUtils;
import org.junit.Assert;

public class validation {

    public void validateStatusCode(Integer statusCode){
        Assert.assertEquals(statusCode.intValue(), APIUtils.response.getStatusCode());
    }
}
