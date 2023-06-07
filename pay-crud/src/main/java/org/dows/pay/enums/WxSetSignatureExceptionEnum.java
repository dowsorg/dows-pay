package org.dows.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author longhui.shi
 * @Date 2023/6/7 15:45
 * @PackageName:org.dows.pay
 * @ClassName: WxSetNickNameExceptionEnum
 * @Description: TODO 設置简介和头像错误码
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum WxSetSignatureExceptionEnum {
    /**
     * 异常枚举类
     */
    system_error("-1", "系统繁忙，此时请开发者稍候再试"),
    invalid_credential_access_token_isinvalid_or_not_latest("40001", "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口"),
    ok("0", "ok"),
    invalid_args("40097", "参数错误"),
    modify_signature_quota_limit_exceed("53200", "本月功能介绍修改次数已用完"),
    signature_in_black_list_can_notuse("53201", "功能介绍内容命中黑名单关键字"),

    invalid_media_id("40007", "不合法的媒体文件 id"),
    media_id_missing("41006", "缺少 media_id 参数"),
    media_data_no_exist("46001", "不存在媒体数据，media_id 不存在"),
    data_format_error("47001", "解析 JSON/XML 内容错误;post 数据中参数缺失;检查修正后重试"),
    invalid_image_size("40009", "图片尺寸太大"),
    modify_avatar_quota_limit_exceed("53202", "本月头像修改次数已用完");

    /**
     * 编码
     */
    private String code;

    /**
     * message
     */
    private String message;

    public static WxSetSignatureExceptionEnum getMessageByCode(String code) {
        WxSetSignatureExceptionEnum[] values = WxSetSignatureExceptionEnum.values();
        for (WxSetSignatureExceptionEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
