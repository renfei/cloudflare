package net.renfei.cloudflare.user;

import net.renfei.cloudflare.CloudflareException;
import net.renfei.cloudflare.CloudflareInterface;
import net.renfei.cloudflare.entity.UserDetail;
import net.renfei.sdk.utils.HttpUtils;

import java.io.IOException;

/**
 * <p>Title: UserApi</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class UserApi extends CloudflareInterface {
    private UserApi() {
    }

    public UserApi(String apiToken) {
        API_TOKEN = apiToken;
    }

    public UserDetail getUserDetails() throws IOException, CloudflareException {
        return getResult(HttpUtils.get(getRequest("user")), UserDetail.class);
    }
}
