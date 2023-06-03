package org.dows.sdk.weixin.open.wxytg;

import org.dows.sdk.weixin.open.wxytg.request.*;
import org.dows.sdk.weixin.open.wxytg.response.*;

/**
 * 服务管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface FuWuGuanLiApi {

    /**
     * 创建服务
     * descr: 通过本接口可以创建云应用服务，使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseService.html
     * api: https://api.weixin.qq.com/componenttcb/establishcloudbaserunserver?access_token=ACCESS_TOKEN
     *
     * @param chuangJianFuWuRequest
     */
    ChuangJianFuWuResponse chuangJianFuWu(ChuangJianFuWuRequest chuangJianFuWuRequest);

    /**
     * 创建服务版本
     * descr: 通过本接口可以创建服务版本，使用过程中如遇到问题，可在,发帖交流。,返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/createcloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param chuangJianFuWuBanBenRequest
     */
    ChuangJianFuWuBanBenResponse chuangJianFuWuBanBen(ChuangJianFuWuBanBenRequest chuangJianFuWuBanBenRequest);

    /**
     * 滚动更新服务版本
     * descr: 通过本接口可以滚动更新服务版本，使用过程中如遇到问题，可在,发帖交流。,返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/updateCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/rollupdatecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param gunDongGengXinFuWuBanBenRequest
     */
    GunDongGengXinFuWuBanBenResponse gunDongGengXinFuWuBanBen(GunDongGengXinFuWuBanBenRequest gunDongGengXinFuWuBanBenRequest);

    /**
     * 删除服务版本
     * descr: 通过本接口可以删除服务版本，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/deleteCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/deletecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param shanChuFuWuBanBenRequest
     */
    ShanChuFuWuBanBenResponse shanChuFuWuBanBen(ShanChuFuWuBanBenRequest shanChuFuWuBanBenRequest);

    /**
     * 发布服务
     * descr: 通过本接口可以全量发布版本，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/releaseCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/releasecloudbaserunversion?access_token=ACCESS_TOKEN
     *
     * @param faBuFuWuRequest
     */
    FaBuFuWuResponse faBuFuWu(FaBuFuWuRequest faBuFuWuRequest);
}