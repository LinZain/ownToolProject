package wechat.role;

public class WechatRespMsgRole {
    private String ToUserName = "";
    private String FromUserName = "";
    private String CreateTime = "";
    private String MsgType = "";
    private String Content = "";

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Content == null) ? 0 : Content.hashCode());
        result = prime * result + ((CreateTime == null) ? 0 : CreateTime.hashCode());
        result = prime * result + ((FromUserName == null) ? 0 : FromUserName.hashCode());
        result = prime * result + ((MsgType == null) ? 0 : MsgType.hashCode());
        result = prime * result + ((ToUserName == null) ? 0 : ToUserName.hashCode());
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
        WechatRespMsgRole other = (WechatRespMsgRole) obj;
        if (Content == null) {
            if (other.Content != null)
                return false;
        } else if (!Content.equals(other.Content))
            return false;
        if (CreateTime == null) {
            if (other.CreateTime != null)
                return false;
        } else if (!CreateTime.equals(other.CreateTime))
            return false;
        if (FromUserName == null) {
            if (other.FromUserName != null)
                return false;
        } else if (!FromUserName.equals(other.FromUserName))
            return false;
        if (MsgType == null) {
            if (other.MsgType != null)
                return false;
        } else if (!MsgType.equals(other.MsgType))
            return false;
        if (ToUserName == null) {
            if (other.ToUserName != null)
                return false;
        } else if (!ToUserName.equals(other.ToUserName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WechatRespMsgRole [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType=" + MsgType
                + ", Content=" + Content + "]";
    }

}
