package net.renfei.cloudflare.entity;

import lombok.Data;

/**
 * <p>Title: VerifyToken</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class VerifyToken {
    private String id;
    private String status;
    private String notBefore;
    private String expiresOn;
}
