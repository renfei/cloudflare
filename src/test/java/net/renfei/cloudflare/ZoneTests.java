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
import net.renfei.cloudflare.entity.zone.CreateZoneAo;
import net.renfei.cloudflare.entity.zone.DnsRecord;
import net.renfei.cloudflare.entity.zone.Zone;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @author renfei
 */
public class ZoneTests extends Tests {
    @Test
    public void zoneTest() {
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(20);
        pagination.setDirection(DirectionEnum.DESC);

        System.out.println("Testing cloudflare.zone().findZoneList()...");
        Response<List<Zone>> zoneListResponse = cloudflare.zone().findZoneList(
                "all",
                CLOUDFLARE_EXAMPLE_DOMAIN,
                null,
                CLOUDFLARE_ACCOUNT_ID,
                "status",
                "active",
                pagination
        );
        assert zoneListResponse.getSuccess() : pauseAndPrint(zoneListResponse);
        pauseAndPrint(zoneListResponse);

        System.out.println("Testing cloudflare.zone().createZone()...");
        CreateZoneAo createZoneAo = new CreateZoneAo();
        CreateZoneAo.Account account = new CreateZoneAo.Account();
        account.setId(CLOUDFLARE_ACCOUNT_ID);
        createZoneAo.setAccount(account);
        createZoneAo.setName("test-" + CLOUDFLARE_EXAMPLE_DOMAIN);
        createZoneAo.setJump_start(false);
        createZoneAo.setType("full");
        Response<Zone> createZoneResponse = cloudflare.zone().createZone(createZoneAo);
        assert createZoneResponse.getSuccess() : pauseAndPrint(createZoneResponse);
        pauseAndPrint(createZoneResponse);

        System.out.println("Testing cloudflare.zone().findZone()...");
        Response<Zone> zoneResponse = cloudflare.zone().findZone(createZoneResponse.getResult().getId());
        assert zoneResponse.getSuccess() : pauseAndPrint(zoneResponse);
        pauseAndPrint(zoneResponse);

        System.out.println("Testing cloudflare.zone().editZone()...");
        // {"code":1085,"message":"Only one property can be updated at a time"}
        Zone zone = new Zone();
        zone.setPaused(true);
        zoneResponse = cloudflare.zone().editZone(createZoneResponse.getResult().getId(), zone);
        assert zoneResponse.getSuccess() : pauseAndPrint(zoneResponse);
        pauseAndPrint(zoneResponse);

        System.out.println("Testing cloudflare.zone().deleteZone()...");
        Response<Map<String, String>> mapResponse = cloudflare.zone().deleteZone(createZoneResponse.getResult().getId());
        assert mapResponse.getSuccess() : pauseAndPrint(mapResponse);
        pauseAndPrint(mapResponse);

        // {"code":1224,"message":"You may only perform this action once per hour."}
        System.out.println("Testing cloudflare.zone().checkZoneActivation()...");
        mapResponse = cloudflare.zone().checkZoneActivation(CLOUDFLARE_EXAMPLE_ZONE_ID);
        pauseAndPrint(mapResponse);

        System.out.println("Testing cloudflare.zone().purgeAllFiles()...");
        mapResponse = cloudflare.zone().purgeAllFiles(CLOUDFLARE_EXAMPLE_ZONE_ID);
        assert mapResponse.getSuccess() : pauseAndPrint(mapResponse);
        pauseAndPrint(mapResponse);
    }

    @Test
    public void dnsTest() {
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(20);
        pagination.setDirection(DirectionEnum.DESC);

        System.out.println("Testing cloudflare.zone().createDnsRecord()...");
        DnsRecord dnsRecord = new DnsRecord();
        dnsRecord.setName("unit-test." + CLOUDFLARE_EXAMPLE_DOMAIN);
        dnsRecord.setType("A");
        dnsRecord.setContent("127.0.0.1");
        dnsRecord.setTtl(6000);
        dnsRecord.setProxiable(false);
        Response<DnsRecord> dnsRecordResponse = cloudflare.zone().createDnsRecord(CLOUDFLARE_EXAMPLE_ZONE_ID, dnsRecord);
        pauseAndPrint(dnsRecordResponse);

        System.out.println("Testing cloudflare.zone().findDnsRecordList()...");
        Response<List<DnsRecord>> dnsRecordListResponse = cloudflare.zone().findDnsRecordList(
                CLOUDFLARE_EXAMPLE_ZONE_ID,
                "all",
                "local." + CLOUDFLARE_EXAMPLE_DOMAIN,
                "type",
                "127.0.0.1",
                "A",
                false,
                pagination
        );
        pauseAndPrint(dnsRecordListResponse);
        DnsRecord dnsRecord1=dnsRecordListResponse.getResult().get(0);

        System.out.println("Testing cloudflare.zone().findDnsRecord()...");
        dnsRecordResponse = cloudflare.zone().findDnsRecord(
                CLOUDFLARE_EXAMPLE_ZONE_ID, dnsRecord1.getId());
        pauseAndPrint(dnsRecordResponse);

        System.out.println("Testing cloudflare.zone().updateDnsRecord()...");
        dnsRecordResponse = cloudflare.zone().updateDnsRecord(
                CLOUDFLARE_EXAMPLE_ZONE_ID, dnsRecord1.getId(), dnsRecordResponse.getResult());
        pauseAndPrint(dnsRecordResponse);

        System.out.println("Testing cloudflare.zone().patchDnsRecord()...");
        dnsRecordResponse = cloudflare.zone().patchDnsRecord(
                CLOUDFLARE_EXAMPLE_ZONE_ID, dnsRecord1.getId(), dnsRecord1);
        pauseAndPrint(dnsRecordResponse);

        System.out.println("Testing cloudflare.zone().deleteDnsRecord()...");
        Response<Map<String, String>> mapResponse = cloudflare.zone().deleteDnsRecord(
                CLOUDFLARE_EXAMPLE_ZONE_ID, dnsRecord1.getId());
        pauseAndPrint(mapResponse);

        System.out.println("Testing cloudflare.zone().scanDnsRecord()...");
        Response<Map<String, Integer>> scanMapResponse = cloudflare.zone().scanDnsRecord(CLOUDFLARE_EXAMPLE_ZONE_ID);
        pauseAndPrint(scanMapResponse);
    }
}
