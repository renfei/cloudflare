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
import net.renfei.cloudflare.entity.firewall.FirewallRule;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @author renfei
 */
public class FirewallTests extends Tests {
    @Test
    public void test() {
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(20);
        pagination.setDirection(DirectionEnum.DESC);

        // User-level Firewall Access Rule
        System.out.println("Testing cloudflare.firewall().createAccessRuleByUser()...");
        FirewallRule firewallRule = new FirewallRule();
        FirewallRule.Configuration configuration = new FirewallRule.Configuration();
        configuration.setTarget("ip");
        configuration.setValue("198.51.100.4");
        firewallRule.setMode("managed_challenge");
        firewallRule.setConfiguration(configuration);
        firewallRule.setNotes("");
        Response<FirewallRule> firewallRuleResponse = cloudflare.firewall().createAccessRuleByUser(firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().findAccessRulesByUser()...");
        Response<List<FirewallRule>> firewallRuleList = cloudflare.firewall().findAccessRulesByUser(
                "",
                "managed_challenge",
                "all",
                "ip",
                "198.51.100.4",
                pagination
        );
        assert firewallRuleList.getSuccess() : pauseAndPrint(firewallRuleList);
        pauseAndPrint(firewallRuleList);

        System.out.println("Testing cloudflare.firewall().editAccessRuleByUser()...");
        firewallRuleResponse = cloudflare.firewall().editAccessRuleByUser(firewallRuleResponse.getResult().getId(), firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().deleteAccessRuleByUser()...");
        Response<Map<String, String>> mapResponse = cloudflare.firewall().deleteAccessRuleByUser(firewallRuleResponse.getResult().getId());
        assert mapResponse.getSuccess() : pauseAndPrint(mapResponse);
        pauseAndPrint(mapResponse);

        // Account-level Firewall access rule
        System.out.println("Testing cloudflare.firewall().createAccessRuleByAccount()...");
        firewallRuleResponse = cloudflare.firewall().createAccessRuleByAccount(CLOUDFLARE_ACCOUNT_ID, firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().findAccessRulesByAccount()...");
        firewallRuleList = cloudflare.firewall().findAccessRulesByAccount(
                CLOUDFLARE_ACCOUNT_ID,
                "",
                "managed_challenge",
                "all",
                "ip",
                "198.51.100.4",
                pagination
        );
        assert firewallRuleList.getSuccess() : pauseAndPrint(firewallRuleList);
        pauseAndPrint(firewallRuleList);

        System.out.println("Testing cloudflare.firewall().updateAccessRuleByAccount()...");
        firewallRuleResponse = cloudflare.firewall().updateAccessRuleByAccount(
                CLOUDFLARE_ACCOUNT_ID, firewallRuleResponse.getResult().getId(), firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().accessRuleDetailsByAccount()...");
        firewallRuleResponse = cloudflare.firewall().accessRuleDetailsByAccount(
                CLOUDFLARE_ACCOUNT_ID, firewallRuleResponse.getResult().getId());
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().deleteAccessRuleByAccount()...");
        mapResponse = cloudflare.firewall().deleteAccessRuleByAccount(
                CLOUDFLARE_ACCOUNT_ID, firewallRuleResponse.getResult().getId());
        assert mapResponse.getSuccess() : pauseAndPrint(mapResponse);
        pauseAndPrint(mapResponse);

        // Firewall Access Rule for a Zone
        System.out.println("Testing cloudflare.firewall().createAccessRuleByZone()...");
        firewallRuleResponse = cloudflare.firewall().createAccessRuleByZone(CLOUDFLARE_EXAMPLE_ZONE_ID, firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().findAccessRuleByZone()...");
        firewallRuleList = cloudflare.firewall().findAccessRuleByZone(
                CLOUDFLARE_EXAMPLE_ZONE_ID,
                "",
                "managed_challenge",
                "all",
                "ip",
                "198.51.100.4",
                pagination
        );
        assert firewallRuleList.getSuccess() : pauseAndPrint(firewallRuleList);
        pauseAndPrint(firewallRuleList);

        System.out.println("Testing cloudflare.firewall().editAccessRuleByZone()...");
        firewallRuleResponse = cloudflare.firewall().editAccessRuleByZone(
                CLOUDFLARE_EXAMPLE_ZONE_ID, firewallRuleResponse.getResult().getId(), firewallRule);
        assert firewallRuleResponse.getSuccess() : pauseAndPrint(firewallRuleResponse);
        pauseAndPrint(firewallRuleResponse);

        System.out.println("Testing cloudflare.firewall().deleteAccessRuleByZone()...");
        mapResponse = cloudflare.firewall().deleteAccessRuleByZone(
                CLOUDFLARE_EXAMPLE_ZONE_ID, firewallRuleResponse.getResult().getId());
        assert mapResponse.getSuccess() : pauseAndPrint(mapResponse);
        pauseAndPrint(mapResponse);
    }
}
