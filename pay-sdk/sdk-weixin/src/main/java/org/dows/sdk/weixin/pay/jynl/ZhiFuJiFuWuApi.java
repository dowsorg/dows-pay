package org.dows.sdk.weixin.pay.jynl;

import org.dows.sdk.weixin.pay.jynl.request.FuWuRenYuanChaXunRequest;
import org.dows.sdk.weixin.pay.jynl.request.FuWuRenYuanFenPeiRequest;
import org.dows.sdk.weixin.pay.jynl.request.FuWuRenYuanXinXiGengXinRequest;
import org.dows.sdk.weixin.pay.jynl.request.FuWuRenYuanZhuCeRequest;
import org.dows.sdk.weixin.pay.jynl.response.FuWuRenYuanChaXunResponse;
import org.dows.sdk.weixin.pay.jynl.response.FuWuRenYuanFenPeiResponse;
import org.dows.sdk.weixin.pay.jynl.response.FuWuRenYuanXinXiGengXinResponse;
import org.dows.sdk.weixin.pay.jynl.response.FuWuRenYuanZhuCeResponse;

/**
 * 支付即服务
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface ZhiFuJiFuWuApi {

    /**
     * 服务人员注册
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_4_1.shtml
     * api:
     *
     * @param fuWuRenYuanZhuCeRequest
     */
    FuWuRenYuanZhuCeResponse fuWuRenYuanZhuCe(FuWuRenYuanZhuCeRequest fuWuRenYuanZhuCeRequest);

    /**
     * 服务人员分配
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_4_2.shtml
     * api:
     *
     * @param fuWuRenYuanFenPeiRequest
     */
    FuWuRenYuanFenPeiResponse fuWuRenYuanFenPei(FuWuRenYuanFenPeiRequest fuWuRenYuanFenPeiRequest);

    /**
     * 服务人员查询
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_4_3.shtml
     * api:
     *
     * @param fuWuRenYuanChaXunRequest
     */
    FuWuRenYuanChaXunResponse fuWuRenYuanChaXun(FuWuRenYuanChaXunRequest fuWuRenYuanChaXunRequest);

    /**
     * 服务人员信息更新
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_4_4.shtml
     * api:
     *
     * @param fuWuRenYuanXinXiGengXinRequest
     */
    FuWuRenYuanXinXiGengXinResponse fuWuRenYuanXinXiGengXin(FuWuRenYuanXinXiGengXinRequest fuWuRenYuanXinXiGengXinRequest);
}