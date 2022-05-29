/*
 *   Copyright 2022 RenFei(i@renfei.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.renfei.cloudflare.service;

import com.google.gson.reflect.TypeToken;
import net.renfei.cloudflare.Cloudflare;
import net.renfei.cloudflare.api.User;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;
import net.renfei.cloudflare.entity.user.UserDetail;
import net.renfei.cloudflare.entity.user.UserToken;

import java.io.IOException;
import java.util.List;

/**
 * @author renfei
 */
public class UserImpl extends BaseService implements User {

    public UserImpl(Cloudflare cloudflare) {
        super(cloudflare);
    }

    @Override
    public Response<UserDetail> findUserDetail() {
        Response<UserDetail> userDetailResponse;
        try {
            userDetailResponse = client.request("user", "GET", null,
                    new TypeToken<Response<UserDetail>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userDetailResponse;
    }

    @Override
    public Response<UserDetail> editUserDetail(UserDetail userDetail) {
        Response<UserDetail> userDetailResponse;
        try {
            userDetailResponse = client.request("user", "PATCH", userDetail,
                    new TypeToken<Response<UserDetail>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userDetailResponse;
    }

    @Override
    public Response<List<UserToken>> findUserTokens(Pagination pagination) {
        String endpoint = "user/tokens?";
        if (pagination != null) {
            if (pagination.getPage() != null) {
                endpoint += "page=" + pagination.getPage() + "&";
            }
            if (pagination.getPerPage() != null) {
                endpoint += "per_page=" + pagination.getPerPage() + "&";
            }
            if (pagination.getDirection() != null) {
                endpoint += "direction=" + pagination.getDirection().toString().toLowerCase() + "&";
            }
        }
        Response<List<UserToken>> userDetailResponse;
        try {
            userDetailResponse = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<UserToken>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userDetailResponse;
    }
}
