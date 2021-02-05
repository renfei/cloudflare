import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.Cloudflare;
import net.renfei.cloudflare.entity.Zone;

import java.io.IOException;
import java.util.List;

/**
 * <p>Title: ZoneTests</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class ZoneTests {
    public static void main(String[] args) {
//        Cloudflare cloudflare = new Cloudflare(TOKEN);
//        try {
//            List<Zone> zones = cloudflare.getZone().getListZones();
//            System.out.println(JSON.toJSONString(zones));
////            CreateZone createZone = new CreateZone();
////            CreateZone.Account account = new CreateZone.Account();
////            account.setId(zones.get(0).getId());
////            createZone.setAccount(account);
////            createZone.setJumpStart(true);
////            createZone.setType("full");
////            createZone.setName("renfei.net");
////            System.out.println(JSON.toJSONString(cloudflare.getZone().createZone(createZone)));
//            System.out.println(JSON.toJSONString(cloudflare.getZone().getZoneDetails(zones.get(0).getId())));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
