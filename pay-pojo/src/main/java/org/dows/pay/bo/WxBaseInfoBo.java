package org.dows.pay.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.WeixinApiField;

import java.util.List;


@Data
public class WxBaseInfoBo implements ChannelBizModel {

   /**
     * 昵称.
     */
    @WeixinApiField(name = "nick_name")
    private String nickName;

    /**
     * 身份证照片 mediaid. 个人号必填
     */
    @WeixinApiField(name = "id_card")
    private String idCard;

    /**
     * 组织机构代码证或营业执照 mediaid，组织号必填.
     */
    @WeixinApiField(name = "license")
    private String license;

    /**
     * 其他证明材料 mediaid.
     */
    @WeixinApiField(name = "naming_other_stuff_1")
    private String namingOtherStuff1;

    /**
     * 其他证明材料 mediaid.
     */
    @WeixinApiField(name = "naming_other_stuff_2")
    private String namingOtherStuff2;

    /**
     * 申请id
     */
    @WeixinApiField(name = "audit_id")
    private String auditId;

    /**
     * 小程序介绍
     */
    @WeixinApiField(name = "signature")
    private String signature;

    /**
     * 小程序头像
     */
    @WeixinApiField(name = "head_img_media_id")
    private String headImgMediaId;

    /**
     * x1 .
     */
    @WeixinApiField(name = "x1")
    private float x1;

    /**
     * y1 .
     */
    @WeixinApiField(name = "y1")
    private float y1;

    /**
     * x2
     */
    @WeixinApiField(name = "x2")
    private float x2;

    /**
     * y2
     */
    @WeixinApiField(name = "y2")
    private float y2;
}
