import com.alibaba.fastjson.JSON;
import net.renfei.cloudflare.entity.CreateDnsRecord;
import net.renfei.cloudflare.entity.DnsRecords;
import net.renfei.cloudflare.entity.Zone;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>Title: DnsTest</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class DnsTest extends Test {
    public static void main(String[] args) {
//        try {
//            List<Zone> zones = cloudflare.zone.getListZones();
//            AtomicReference<Zone> renfeiZone = new AtomicReference<>();
//            zones.forEach(zone -> {
//                if ("renfei.net".equals(zone.getName())) {
//                    renfeiZone.set(zone);
//                }
//            });
//            System.out.println(JSON.toJSONString(renfeiZone.get()));
//            CreateDnsRecord createDnsRecord = new CreateDnsRecord();
//            createDnsRecord.setType("TXT");
//            createDnsRecord.setName("test");
//            createDnsRecord.setContent("testContent");
//            createDnsRecord.setTtl(120);
//            createDnsRecord.setPriority(10);
//            createDnsRecord.setProxied(false);
//            cloudflare.dnsRecords.createDnsRecord(renfeiZone.get().getId(), createDnsRecord);
//            Map<String, Object> paramMap = new HashMap<>();
//            paramMap.put("match", "all");
//            paramMap.put("page", "1");
//            paramMap.put("per_page", "100");
//            List<DnsRecords> dnsRecords = cloudflare.dnsRecords.getListDnsRecord(renfeiZone.get().getId(), paramMap);
//            AtomicReference<DnsRecords> testDnsRecords = new AtomicReference<>();
//            dnsRecords.forEach(dnsRecords1 -> {
//                System.out.println(JSON.toJSONString(dnsRecords1));
//                if ("test.renfei.net".equals(dnsRecords1.getName())) {
//                    testDnsRecords.set(dnsRecords1);
//                }
//            });
//            cloudflare.dnsRecords.deleteDnsRecord(renfeiZone.get().getId(), testDnsRecords.get().getId());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
