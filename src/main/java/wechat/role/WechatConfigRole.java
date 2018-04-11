package wechat.role;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WechatConfigRole{
    @Value("wechat.appID")
    private String appID;
    
    @Value("wechat.appSecret")
    private String appSecret;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((appID == null) ? 0 : appID.hashCode());
        result = prime * result + ((appSecret == null) ? 0 : appSecret.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WechatConfigRole other = (WechatConfigRole) obj;
        if (appID == null) {
            if (other.appID != null)
                return false;
        } else if (!appID.equals(other.appID))
            return false;
        if (appSecret == null) {
            if (other.appSecret != null)
                return false;
        } else if (!appSecret.equals(other.appSecret))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WechatConfigRole [appID=" + appID + ", appSecret=" + appSecret + "]";
    }

}
