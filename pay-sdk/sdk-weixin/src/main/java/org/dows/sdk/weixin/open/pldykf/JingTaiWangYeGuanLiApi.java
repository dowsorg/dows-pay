package org.dows.sdk.weixin.open.pldykf;

import org.dows.sdk.weixin.open.pldykf.request.ChaKanJingTaiWangZhanZhuangTaiRequest;
import org.dows.sdk.weixin.open.pldykf.request.HuoQuJingTaiWangZhanWenJianLieBiaoRequest;
import org.dows.sdk.weixin.open.pldykf.request.HuoQuShangChuanJingTaiWangZhanWenJianLianJieRequest;
import org.dows.sdk.weixin.open.pldykf.request.KaiTongJingTaiWangZhanRequest;
import org.dows.sdk.weixin.open.pldykf.response.ChaKanJingTaiWangZhanZhuangTaiResponse;
import org.dows.sdk.weixin.open.pldykf.response.HuoQuJingTaiWangZhanWenJianLieBiaoResponse;
import org.dows.sdk.weixin.open.pldykf.response.HuoQuShangChuanJingTaiWangZhanWenJianLianJieResponse;
import org.dows.sdk.weixin.open.pldykf.response.KaiTongJingTaiWangZhanResponse;

/**
 * 静态网页管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface JingTaiWangYeGuanLiApi {

    /**
     * 查看静态网站状态
     * descr: 通过本接口可以查看静态网站状态，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStore.html
     * api: https://api.weixin.qq.com/componenttcb/describestaticstore?access_token=ACCESS_TOKEN
     *
     * @param chaKanJingTaiWangZhanZhuangTaiRequest
     */
    ChaKanJingTaiWangZhanZhuangTaiResponse chaKanJingTaiWangZhanZhuangTai(ChaKanJingTaiWangZhanZhuangTaiRequest chaKanJingTaiWangZhanZhuangTaiRequest);

    /**
     * 开通静态网站
     * descr: 通过本接口可以开通静态网站，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/createStaticStore.html
     * api: https://api.weixin.qq.com/componenttcb/createstaticstore?access_token=ACCESS_TOKEN
     *
     * @param kaiTongJingTaiWangZhanRequest
     */
    KaiTongJingTaiWangZhanResponse kaiTongJingTaiWangZhan(KaiTongJingTaiWangZhanRequest kaiTongJingTaiWangZhanRequest);

    /**
     * 获取上传静态网站文件链接
     * descr: 通过本接口可以获取上传静态网站文件链接，使用过程中如遇到问题，可在,发帖交流。,请求方法为 PUT url 为返回包的 signed_url 字段 需增加 key 为 x-cos-security-token，value 为返回包的中token字段的Header 请求体为需上传的文件内容
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getUploadStaticStoreFile.html
     * api: https://api.weixin.qq.com/componenttcb/staticuploadfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuShangChuanJingTaiWangZhanWenJianLianJieRequest
     */
    HuoQuShangChuanJingTaiWangZhanWenJianLianJieResponse huoQuShangChuanJingTaiWangZhanWenJianLianJie(HuoQuShangChuanJingTaiWangZhanWenJianLianJieRequest huoQuShangChuanJingTaiWangZhanWenJianLianJieRequest);

    /**
     * 获取静态网站文件列表
     * descr: 通过本接口可以配置获取静态网站文件列表，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStoreFile.html
     * api: https://api.weixin.qq.com/componenttcb/staticfilelist?access_token=ACCESS_TOKEN
     *
     * @param huoQuJingTaiWangZhanWenJianLieBiaoRequest
     */
    HuoQuJingTaiWangZhanWenJianLieBiaoResponse huoQuJingTaiWangZhanWenJianLieBiao(HuoQuJingTaiWangZhanWenJianLieBiaoRequest huoQuJingTaiWangZhanWenJianLieBiaoRequest);
}