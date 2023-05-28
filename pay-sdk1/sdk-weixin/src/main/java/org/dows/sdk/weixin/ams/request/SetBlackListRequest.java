package org.dows.sdk.weixin.ams.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
@Data
public class SetBlackListRequest{
    @Schema(title = "1：设置屏蔽 2：删除屏蔽")
    private Integer op;
    @Schema(title = "为json序列化格式，包含屏蔽类型type及标识ID。其中，type枚举值：1：公众号，id代表公众号微信号 2：IOS应用，id代表IOS应用APPID 3：安卓应用，id代表安卓应用的应用宝包名 4：小程序/小游戏，id代表原始ID。注：屏蔽数量有上限，超过将超时报错。公众号，最多可屏蔽20个，iOS应用，最多可屏蔽10个，安卓应用，最多可屏蔽10个，小程序/小游戏，最多可屏蔽20个")
    private String list;
}

