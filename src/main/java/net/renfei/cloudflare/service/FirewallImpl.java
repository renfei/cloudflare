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
import net.renfei.cloudflare.api.Firewall;
import net.renfei.cloudflare.entity.common.Pagination;
import net.renfei.cloudflare.entity.common.Response;
import net.renfei.cloudflare.entity.firewall.FirewallRule;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 防火墙
 *
 * @author renfei
 */
public class FirewallImpl extends BaseService implements Firewall {

    public FirewallImpl(Cloudflare cloudflare) {
        super(cloudflare);
    }

    @Override
    public Response<List<FirewallRule>> findAccessRulesByUser(String notes, String mode, String match, String target, String value, Pagination pagination) {
        String endpoint = "user/firewall/access_rules/rules?";
        if (notes != null) {
            endpoint += "notes=" + notes + "&";
        }
        if (mode != null) {
            endpoint += "mode=" + mode + "&";
        }
        if (match != null) {
            endpoint += "match=" + match + "&";
        }
        if (target != null) {
            endpoint += "configuration.target=" + target + "&";
        }
        if (value != null) {
            endpoint += "configuration.value=" + value + "&";
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
        Response<List<FirewallRule>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<FirewallRule>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> createAccessRuleByUser(FirewallRule firewallRule) {
        String endpoint = "user/firewall/access_rules/rules";
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "POST", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> editAccessRuleByUser(String roleId, FirewallRule firewallRule) {
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        firewallRule.setId(roleId);
        String endpoint = "user/firewall/access_rules/rules/" + roleId;
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "PATCH", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> deleteAccessRuleByUser(String roleId) {
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        String endpoint = "user/firewall/access_rules/rules/" + roleId;
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "DELETE", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<List<FirewallRule>> findAccessRulesByAccount(String accountId, String notes,
                                                                 String mode, String match, String target,
                                                                 String value, Pagination pagination) {
        if (accountId == null || "".equals(accountId)) {
            throw new RuntimeException("accountId cannot be empty.");
        }
        String endpoint = "accounts/" + accountId + "/firewall/access_rules/rules?";
        if (notes != null) {
            endpoint += "notes=" + notes + "&";
        }
        if (mode != null) {
            endpoint += "mode=" + mode + "&";
        }
        if (match != null) {
            endpoint += "match=" + match + "&";
        }
        if (target != null) {
            endpoint += "configuration.target=" + target + "&";
        }
        if (value != null) {
            endpoint += "configuration.value=" + value + "&";
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
        Response<List<FirewallRule>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<FirewallRule>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> createAccessRuleByAccount(String accountId,
                                                            FirewallRule firewallRule) {
        if (accountId == null || "".equals(accountId)) {
            throw new RuntimeException("accountId cannot be empty.");
        }
        String endpoint = "accounts/" + accountId + "/firewall/access_rules/rules";
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "POST", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> accessRuleDetailsByAccount(String accountId, String roleId) {
        if (accountId == null || "".equals(accountId)) {
            throw new RuntimeException("accountId cannot be empty.");
        }
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        String endpoint = "accounts/" + accountId + "/firewall/access_rules/rules/" + roleId;
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> updateAccessRuleByAccount(String accountId, String roleId,
                                                            FirewallRule firewallRule) {
        if (accountId == null || "".equals(accountId)) {
            throw new RuntimeException("accountId cannot be empty.");
        }
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        firewallRule.setId(roleId);
        String endpoint = "accounts/" + accountId + "/firewall/access_rules/rules/" + roleId;
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "PATCH", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> deleteAccessRuleByAccount(String accountId, String roleId) {
        if (accountId == null || "".equals(accountId)) {
            throw new RuntimeException("accountId cannot be empty.");
        }
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        String endpoint = "accounts/" + accountId + "/firewall/access_rules/rules/" + roleId;
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "DELETE", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<List<FirewallRule>> findAccessRuleByZone(String zoneId, String notes, String mode, String match, String target, String value, Pagination pagination) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/firewall/access_rules/rules?";
        if (notes != null) {
            endpoint += "notes=" + notes + "&";
        }
        if (mode != null) {
            endpoint += "mode=" + mode + "&";
        }
        if (match != null) {
            endpoint += "match=" + match + "&";
        }
        if (target != null) {
            endpoint += "configuration.target=" + target + "&";
        }
        if (value != null) {
            endpoint += "configuration.value=" + value + "&";
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
        Response<List<FirewallRule>> response;
        try {
            response = client.request(endpoint, "GET", null,
                    new TypeToken<Response<List<FirewallRule>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> createAccessRuleByZone(String zoneId, FirewallRule firewallRule) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/firewall/access_rules/rules";
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "POST", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<FirewallRule> editAccessRuleByZone(String zoneId, String roleId, FirewallRule firewallRule) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        firewallRule.setId(roleId);
        String endpoint = "zones/" + zoneId + "/firewall/access_rules/rules/" + roleId;
        Response<FirewallRule> response;
        try {
            response = client.request(endpoint, "PATCH", firewallRule,
                    new TypeToken<Response<FirewallRule>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public Response<Map<String, String>> deleteAccessRuleByZone(String zoneId, String roleId) {
        if (zoneId == null || "".equals(zoneId)) {
            throw new RuntimeException("zoneId cannot be empty.");
        }
        if (roleId == null || "".equals(roleId)) {
            throw new RuntimeException("roleId cannot be empty.");
        }
        String endpoint = "zones/" + zoneId + "/firewall/access_rules/rules/" + roleId;
        Response<Map<String, String>> response;
        try {
            response = client.request(endpoint, "DELETE", null,
                    new TypeToken<Response<Map<String, String>>>() {
                    }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
