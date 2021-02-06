package net.renfei.cloudflare;

import net.renfei.cloudflare.dns.DnsRecordsApi;
import net.renfei.cloudflare.user.UserApi;
import net.renfei.cloudflare.zone.ZoneApi;

/**
 * <p>Title: Cloudflare</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class Cloudflare {
    public UserApi user;
    public ZoneApi zone;
    public DnsRecordsApi dnsRecords;

    private Cloudflare() {
    }

    public Cloudflare(String apiToken) {
        user = new UserApi(apiToken);
        zone = new ZoneApi(apiToken);
        dnsRecords = new DnsRecordsApi(apiToken);
    }
}
