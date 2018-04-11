package wechat.role;

public class WechatReqMsgRole {
    private String URL = "";
    private String ToUserName = "";
    private String FromUserName = "";
    private String CreateTime = "";
    private String MsgType = "";
    private String MsgId = "";
    private String Event = "";
    private String EventKey = "";
    private String MenuId = "";
    private String Ticket = "";
    private String Status = "";
    private String MsgID = "";
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

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Content == null) ? 0 : Content.hashCode());
        result = prime * result + ((CreateTime == null) ? 0 : CreateTime.hashCode());
        result = prime * result + ((Event == null) ? 0 : Event.hashCode());
        result = prime * result + ((EventKey == null) ? 0 : EventKey.hashCode());
        result = prime * result + ((FromUserName == null) ? 0 : FromUserName.hashCode());
        result = prime * result + ((MenuId == null) ? 0 : MenuId.hashCode());
        result = prime * result + ((MsgID == null) ? 0 : MsgID.hashCode());
        result = prime * result + ((MsgId == null) ? 0 : MsgId.hashCode());
        result = prime * result + ((MsgType == null) ? 0 : MsgType.hashCode());
        result = prime * result + ((Status == null) ? 0 : Status.hashCode());
        result = prime * result + ((Ticket == null) ? 0 : Ticket.hashCode());
        result = prime * result + ((ToUserName == null) ? 0 : ToUserName.hashCode());
        result = prime * result + ((URL == null) ? 0 : URL.hashCode());
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
        WechatReqMsgRole other = (WechatReqMsgRole) obj;
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
        if (Event == null) {
            if (other.Event != null)
                return false;
        } else if (!Event.equals(other.Event))
            return false;
        if (EventKey == null) {
            if (other.EventKey != null)
                return false;
        } else if (!EventKey.equals(other.EventKey))
            return false;
        if (FromUserName == null) {
            if (other.FromUserName != null)
                return false;
        } else if (!FromUserName.equals(other.FromUserName))
            return false;
        if (MenuId == null) {
            if (other.MenuId != null)
                return false;
        } else if (!MenuId.equals(other.MenuId))
            return false;
        if (MsgID == null) {
            if (other.MsgID != null)
                return false;
        } else if (!MsgID.equals(other.MsgID))
            return false;
        if (MsgId == null) {
            if (other.MsgId != null)
                return false;
        } else if (!MsgId.equals(other.MsgId))
            return false;
        if (MsgType == null) {
            if (other.MsgType != null)
                return false;
        } else if (!MsgType.equals(other.MsgType))
            return false;
        if (Status == null) {
            if (other.Status != null)
                return false;
        } else if (!Status.equals(other.Status))
            return false;
        if (Ticket == null) {
            if (other.Ticket != null)
                return false;
        } else if (!Ticket.equals(other.Ticket))
            return false;
        if (ToUserName == null) {
            if (other.ToUserName != null)
                return false;
        } else if (!ToUserName.equals(other.ToUserName))
            return false;
        if (URL == null) {
            if (other.URL != null)
                return false;
        } else if (!URL.equals(other.URL))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WechatMsgRole [URL=" + URL + ", ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
                + MsgType + ", MsgId=" + MsgId + ", Event=" + Event + ", EventKey=" + EventKey + ", MenuId=" + MenuId + ", Ticket=" + Ticket + ", Status="
                + Status + ", MsgID=" + MsgID + ", Content=" + Content + "]";
    }

}
