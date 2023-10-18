package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author longhui.shi
 * @Date 2023/6/27 11:13
 * @PackageName:org.dows.app.api.mini.request
 * @ClassName: uboInfoListRequest
 * @Description: TODO 最终受益人信息列表(UBO)
 * @Version 1.0
 */
@Data
public class uboInfoListRequest {

    @ApiModelProperty("受益所有人证件类型 IDENTIFICATION_TYPE_IDCARD：中国大陆居民-身份证\n" +
            "IDENTIFICATION_TYPE_OVERSEA_PASSPORT：其他国家或地区居民-护照\n" +
            "IDENTIFICATION_TYPE_HONGKONG_PASSPORT：中国香港居民-来往内地通行证\n" +
            "IDENTIFICATION_TYPE_MACAO_PASSPORT：中国澳门居民-来往内地通行证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_PASSPORT：中国台湾居民-来往大陆通行证\n" +
            "IDENTIFICATION_TYPE_FOREIGN_RESIDENT：外国人居留证\n" +
            "IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT：港澳居民证\n" +
            "IDENTIFICATION_TYPE_TAIWAN_RESIDENT：台湾居民证\n" +
            "默认：IDENTIFICATION_TYPE_IDCARD")
    private String beneficiaryIdType;
    @ApiModelProperty("受益所有人身份证正面")//不同类型的证件照片存储字段
    private String beneficiaryIdPictureFront;
    @ApiModelProperty("受益所有人身份证反面")
    private String beneficiaryIdPictureBack;
    @ApiModelProperty("受益所有人姓名")
    private String beneficiaryName;
    @ApiModelProperty("受益所有人证件号")//枚举？身份证
    private String beneficiaryNo;
    @ApiModelProperty("收益人地址")
    private String beneficiaryAddress;
    @ApiModelProperty("受益所有人证件有效期-开始")
    private String beneficiaryIdValidityPeriodBegin;
    @ApiModelProperty("受益所有人证件有效期-结束")
    private String beneficiaryIdValidityPeriodEnd;
}
