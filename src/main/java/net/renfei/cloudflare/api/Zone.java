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
import net.renfei.cloudflare.entity.zone.CreateZoneAo;
import net.renfei.cloudflare.entity.zone.DnsRecord;

import java.util.List;
import java.util.Map;

/**
 * A Zone is a domain name along with its subdomains and other identities
 *
 * @author renfei
 */
public interface Zone {
    /**
     * List, search, sort, and filter your zones
     *
     * @param match
     * @param name
     * @param accountName
     * @param accountId
     * @param order
     * @param status
     * @param pagination
     * @return
     */
    Response<List<net.renfei.cloudflare.entity.zone.Zone>> findZoneList(String match, String name, String accountName,
                                                                        String accountId, String order, String status,
                                                                        Pagination pagination);

    Response<net.renfei.cloudflare.entity.zone.Zone> createZone(CreateZoneAo createZoneAo);

    Response<net.renfei.cloudflare.entity.zone.Zone> findZone(String zoneId);

    /**
     * Only one zone property can be changed at a time
     *
     * @param zoneId
     * @param zone
     * @return
     */
    Response<net.renfei.cloudflare.entity.zone.Zone> editZone(String zoneId, net.renfei.cloudflare.entity.zone.Zone zone);

    /**
     * Delete an existing zone.
     *
     * @param zoneId
     * @return
     */
    Response<Map<String, String>> deleteZone(String zoneId);

    /**
     * Initiate another zone activation check
     *
     * @param zoneId
     * @return
     */
    Response<Map<String, String>> checkZoneActivation(String zoneId);

    /**
     * Remove ALL files from Cloudflare's cache
     *
     * @param zoneId
     * @return
     */
    Response<Map<String, String>> purgeAllFiles(String zoneId);

    /**
     * List, search, sort, and filter a zones' DNS records.
     *
     * @param zoneId
     * @param match
     * @param name
     * @param order
     * @param content
     * @param type
     * @param proxied
     * @param pagination
     * @return
     */
    Response<List<DnsRecord>> findDnsRecordList(String zoneId, String match, String name, String order,
                                                String content, String type, Boolean proxied, Pagination pagination);

    Response<DnsRecord> createDnsRecord(String zoneId, DnsRecord dnsRecord);

    Response<DnsRecord> findDnsRecord(String zoneId, String dnsRecordId);

    Response<DnsRecord> updateDnsRecord(String zoneId, String dnsRecordId, DnsRecord dnsRecord);

    Response<DnsRecord> patchDnsRecord(String zoneId, String dnsRecordId, DnsRecord dnsRecord);

    Response<Map<String, String>> deleteDnsRecord(String zoneId, String dnsRecordId);

    /**
     * Scan for common DNS records on your domain and automatically add them to your zone. Useful if you haven't updated your nameservers yet.
     *
     * @param zoneId
     * @return
     */
    Response<Map<String, Integer>> scanDnsRecord(String zoneId);
}
