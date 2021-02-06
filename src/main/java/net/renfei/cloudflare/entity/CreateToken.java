package net.renfei.cloudflare.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: CreateToken</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
@Data
public class CreateToken {
    private String name;
    private String notBefore;
    private String expiresOn;
    private List<UserApiTokens.Policy> policies;
    private UserApiTokens.Condition condition;
}
