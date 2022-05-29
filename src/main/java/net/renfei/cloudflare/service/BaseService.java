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

import net.renfei.cloudflare.Cloudflare;

/**
 * BaseService
 *
 * @author renfei
 */
public abstract class BaseService {
    protected final Cloudflare cloudflare;
    protected final RestFulClient client;

    protected BaseService(Cloudflare cloudflare) {
        this.cloudflare = cloudflare;
        switch (cloudflare.getAUTH_TYPE_ENUM()) {
            case API_KEY:
                client = new RestFulClient(cloudflare.getAPI_KEY());
                break;
            case API_TOKEN:
                client = new RestFulClient(cloudflare.getAPI_TOKEN());
                break;
            case USER_SERVICE_KEY:
                client = new RestFulClient(cloudflare.getUSER_SERVICE_KEY());
                break;
            default:
                throw new RuntimeException("Auth Type Error.");
        }
    }
}
