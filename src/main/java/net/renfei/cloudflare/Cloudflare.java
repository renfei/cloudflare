package net.renfei.cloudflare;

import lombok.Data;
import net.renfei.cloudflare.user.UserApi;
import net.renfei.cloudflare.zone.ZoneApi;

/**
 * <p>Title: Cloudflare</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class Cloudflare {
    private UserApi user;
    private ZoneApi zone;

    private Cloudflare() {
    }

    public Cloudflare(String apiToken) {
        user = new UserApi(apiToken);
        zone = new ZoneApi(apiToken);
    }
}
