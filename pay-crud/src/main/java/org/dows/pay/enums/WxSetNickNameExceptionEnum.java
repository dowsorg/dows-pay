package org.dows.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author longhui.shi
 * @Date 2023/6/7 15:45
 * @PackageName:org.dows.pay
 * @ClassName: WxSetNickNameExceptionEnum
 * @Description: TODO 設置昵稱错误码
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum WxSetNickNameExceptionEnum {
    /**
     * 异常枚举类
     */
    not_fast_register("91001", "不是复用公众号快速创建的小程序以及不是通过快速注册企业小程序接口注册的小程序"),
    has_published("91002", "小程序发布后不可改名"),
    invalid_change_stat("91003", "改名状态不合法"),
    invalid_nickname("91004", "昵称不合法"),
    invalid_nickname_15("91005", "昵称15天主体保护"),
    nickname_used("91007", "昵称已被占用"),
    invalid_nickname_7("91008", "昵称命中7天侵权保护期"),
    nickname_need_proof("91009", "需要提交材料"),
    other_exception_91010("91010", "其他错误"),
    query_nick_null("91011", "查不到昵称修改审核单信息"),
    other_exception_1012("91012", "其他错误"),
    nick_size_max("91013", "占用名字过多"),
    diff_master_plus("91014", "+号规则 同一类型关联名主体不一致"),
    diff_master("91015", "原始名不同类型主体不一致"),
    name_more_owner("91016", "名称占用者 ≥2"),
    other_diff_master_plus("91017", "+号规则 不同类型关联名主体不一致");
    /**
     * 编码
     */
    private String code;

    /**
     * message
     */
    private String message;

    public static WxSetNickNameExceptionEnum getMessageByCode(String code) {
        WxSetNickNameExceptionEnum[] values = WxSetNickNameExceptionEnum.values();
        for (WxSetNickNameExceptionEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
