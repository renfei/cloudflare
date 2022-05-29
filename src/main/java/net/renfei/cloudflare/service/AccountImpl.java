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
import net.renfei.cloudflare.api.Account;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author renfei
 */
public class AccountImpl extends BaseService implements Account {

    public AccountImpl(Cloudflare cloudflare) {
        super(cloudflare);
    }

    @Override
    public Response<List<net.renfei.cloudflare.entity.account.Account>> getAccounts(String name, Pagination pagination) {
        String endpoint = "accounts?";
        if (name != null) {
            endpoint += "name=" + name + "&";
        }
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
        Response<List<net.renfei.cloudflare.entity.account.Account>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<net.renfei.cloudflare.entity.account.Account>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<net.renfei.cloudflare.entity.account.Account> getAccountDetails(String id) {
        Response<net.renfei.cloudflare.entity.account.Account> response;
        try {

            response = client.request("accounts/" + id, "GET", null,
                    new TypeToken<Response<net.renfei.cloudflare.entity.account.Account>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<net.renfei.cloudflare.entity.account.Account> updateAccount(String id, net.renfei.cloudflare.entity.account.Account account) {
        account.setId(id);
        Response<net.renfei.cloudflare.entity.account.Account> response;
        try {
            response = client.request("accounts/" + id, "PUT", account,
                    new TypeToken<Response<net.renfei.cloudflare.entity.account.Account>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
