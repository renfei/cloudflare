import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.Cloudflare;
import net.renfei.cloudflare.entity.Zone;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>Title: ZoneTests</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class ZoneTests extends Test {
    public static void main(String[] args) {
//        try {
//            List<Zone> zones = cloudflare.zone.getListZones();
//            System.out.println(JSON.toJSONString(zones));
////            CreateZone createZone = new CreateZone();
////            CreateZone.Account account = new CreateZone.Account();
////            account.setId(zones.get(0).getId());
////            createZone.setAccount(account);
////            createZone.setJumpStart(true);
////            createZone.setType("full");
////            createZone.setName("renfei.net");
////            System.out.println(JSON.toJSONString(cloudflare.zone.createZone(createZone)));
//            System.out.println(JSON.toJSONString(cloudflare.zone.getZoneDetails(zones.get(0).getId())));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
