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

import net.renfei.cloudflare.entity.common.DirectionEnum;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;
import net.renfei.cloudflare.entity.user.UserDetail;
import net.renfei.cloudflare.entity.user.UserToken;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author renfei
 */
public class UserTests extends Tests {
    @Test
    public void test() {
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(20);
        pagination.setDirection(DirectionEnum.DESC);

        System.out.println("Testing cloudflare.user().findUserDetail()...");
        Response<UserDetail> userDetailResponse = cloudflare.user().findUserDetail();
        assert userDetailResponse.getSuccess() : pauseAndPrint(userDetailResponse);
        pauseAndPrint(userDetailResponse);

        System.out.println("Testing cloudflare.user().editUserDetail()...");
        userDetailResponse = cloudflare.user().editUserDetail(userDetailResponse.getResult());
        assert userDetailResponse.getSuccess() : pauseAndPrint(userDetailResponse);
        pauseAndPrint(userDetailResponse);

        System.out.println("Testing cloudflare.user().findUserTokens()...");
        Response<List<UserToken>> userDetailListResponse = cloudflare.user().findUserTokens(pagination);
        assert userDetailListResponse.getSuccess() : pauseAndPrint(userDetailListResponse);
        pauseAndPrint(userDetailListResponse);
    }
}
