package wechat.service;

public interface WechatQRCodeService {
    public String createQRCode(String msg);
    public String showQRCode(String msg);
}
