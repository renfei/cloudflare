package net.renfei.cloudflare.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: UpdateToken</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class UpdateToken {
    private String id;
    private String name;
    private String notBefore;
    private String expiresOn;
    private String status;
    private String issuedOn;
    private String modifiedOn;
    private List<UserApiTokens.Policy> policies;
    private UserApiTokens.Condition condition;
}
