package net.renfei.cloudflare;

import net.renfei.cloudflare.dns.DnsRecordsApi;
import net.renfei.cloudflare.user.UserApi;
import net.renfei.cloudflare.user.UserApiTokensApi;
import net.renfei.cloudflare.zone.ZoneApi;

/**
 * <p>Title: Cloudflare</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class Cloudflare {
    public UserApi user;
    public UserApiTokensApi userApiTokens;
    public ZoneApi zone;
    public DnsRecordsApi dnsRecords;

    private Cloudflare() {
    }

    public Cloudflare(String apiToken) {
        this.user = new UserApi(apiToken);
        this.userApiTokens = new UserApiTokensApi(apiToken);
        this.zone = new ZoneApi(apiToken);
        this.dnsRecords = new DnsRecordsApi(apiToken);
    }
}
