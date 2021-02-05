package net.renfei.cloudflare;

/**
 * <p>Title: CloudflareException</p>
 * <p>Description: </p>
 *
 * @author RenFei
 */
public class CloudflareException extends RuntimeException {
    private String code;
    private String status;

    public CloudflareException(String code, String status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
