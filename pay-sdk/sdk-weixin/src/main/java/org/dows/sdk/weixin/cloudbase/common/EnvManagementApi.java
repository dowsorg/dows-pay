package org.dows.sdk.weixin.cloudbase.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
*
* @author 
* @date 
*/
public interface EnvManagementApi{
    /**
     * 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在发帖交流
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);
    /**
     * 通过本接口可以创建云环境。使用过程中如遇到问题，可在发帖交流。请注意，旧版调整至当前接口，请开发者逐步进行接口切换。
     * @param createEnvRequest
     */
    CreateEnvResponse createEnv(CreateEnvRequest createEnvRequest);
    /**
     * 通过本接口可以获取已有的云环境信息。使用过程中如遇到问题，可在发帖交流。
     * @param getEnvInfoRequest
     */
    GetEnvInfoResponse getEnvInfo(GetEnvInfoRequest getEnvInfoRequest);
    /**
     * 通过本接口可以环境共享。使用过程中如遇到问题，可在发帖交流。
     * @param shareEnvRequest
     */
    ShareEnvResponse shareEnv(ShareEnvRequest shareEnvRequest);

}
