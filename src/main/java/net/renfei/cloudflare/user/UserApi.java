package net.renfei.cloudflare.user;

import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.CloudflareException;
import net.renfei.cloudflare.CloudflareInterface;
import net.renfei.cloudflare.entity.EditUser;
import net.renfei.cloudflare.entity.UserDetail;
import net.renfei.sdk.http.HttpRequest;
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

    public UserDetail editUser(EditUser editUser) throws IOException, CloudflareException {
        HttpRequest request = getRequest("user");
        request.json(JSON.toJSONString(editUser));
        return getResult(HttpUtils.patch(request), UserDetail.class);
    }
}
