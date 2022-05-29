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
package net.renfei.cloudflare;

import net.renfei.cloudflare.entity.account.Account;
import net.renfei.cloudflare.entity.common.DirectionEnum;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author renfei
 */
public class AccountTests extends Tests {
    @Test
    public void test() {
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(20);
        pagination.setDirection(DirectionEnum.DESC);

        System.out.println("Testing cloudflare.account().getAccounts()...");
        Response<List<Account>> accountList = cloudflare.account().getAccounts(null, pagination);
        assert accountList.getSuccess() : pauseAndPrint(accountList);
        pauseAndPrint(accountList);

        System.out.println("Testing cloudflare.account().getAccountDetails()...");
        Response<Account> account = cloudflare.account().getAccountDetails(accountList.getResult().get(0).getId());
        assert account.getSuccess() : pauseAndPrint(account);
        pauseAndPrint(account);

        System.out.println("Testing cloudflare.account().updateAccount()...");
        // "code":1001,"message":"The use_account_custom_ns_by_default setting is not available to your account"
        account.getResult().getSettings().setUse_account_custom_ns_by_default(null);
        account = cloudflare.account().updateAccount(account.getResult().getId(), account.getResult());
        assert account.getSuccess() : pauseAndPrint(account);
        pauseAndPrint(account);
    }
}
