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
package net.renfei.cloudflare.api;

import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;

import java.util.List;

/**
 * Account
 *
 * @author renfei
 */
public interface Account {
    Response<List<net.renfei.cloudflare.entity.account.Account>> getAccounts(String name, Pagination pagination);

    Response<net.renfei.cloudflare.entity.account.Account> getAccountDetails(String id);

    Response<net.renfei.cloudflare.entity.account.Account> updateAccount(String id, net.renfei.cloudflare.entity.account.Account account);
}
