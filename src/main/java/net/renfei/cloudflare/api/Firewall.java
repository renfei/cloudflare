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
import net.renfei.cloudflare.entity.firewall.FirewallRule;

import java.util.List;
import java.util.Map;

/**
 * 防火墙
 *
 * @author renfei
 */
public interface Firewall {
    Response<List<FirewallRule>> findAccessRulesByUser(String notes, String mode, String match,
                                                       String target, String value, Pagination pagination);

    Response<FirewallRule> createAccessRuleByUser(FirewallRule firewallRule);

    Response<FirewallRule> editAccessRuleByUser(String roleId, FirewallRule firewallRule);

    Response<Map<String, String>> deleteAccessRuleByUser(String roleId);

    Response<List<FirewallRule>> findAccessRulesByAccount(String accountId, String notes,
                                                          String mode, String match, String target,
                                                          String value, Pagination pagination);

    Response<FirewallRule> createAccessRuleByAccount(String accountId,
                                                     FirewallRule firewallRule);

    Response<FirewallRule> accessRuleDetailsByAccount(String accountId, String roleId);

    Response<FirewallRule> updateAccessRuleByAccount(String accountId, String roleId,
                                                     FirewallRule firewallRule);

    Response<Map<String, String>> deleteAccessRuleByAccount(String accountId, String roleId);

    Response<List<FirewallRule>> findAccessRuleByZone(String zoneId, String notes, String mode, String match,
                                                      String target, String value, Pagination pagination);

    Response<FirewallRule> createAccessRuleByZone(String zoneId, FirewallRule firewallRule);

    Response<FirewallRule> editAccessRuleByZone(String zoneId, String roleId, FirewallRule firewallRule);

    Response<Map<String, String>> deleteAccessRuleByZone(String zoneId, String roleId);
}
