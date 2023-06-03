package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电子发票
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface DianZiFaPiaoApi {

    /**
     * 检查子商户开票功能状态
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-merchant/check-merchant-status.html
     * api:
     *
     * @param jianChaZiShangHuKaiPiaoGongNengZhuangTaiRequest
     */
    JianChaZiShangHuKaiPiaoGongNengZhuangTaiResponse jianChaZiShangHuKaiPiaoGongNengZhuangTai(JianChaZiShangHuKaiPiaoGongNengZhuangTaiRequest jianChaZiShangHuKaiPiaoGongNengZhuangTaiRequest);

    /**
     * 创建电子发票卡券模板
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-card-template/create-fapiao-card-template.html
     * api:
     *
     * @param chuangJianDianZiFaPiaoKaQuanMoBanRequest
     */
    ChuangJianDianZiFaPiaoKaQuanMoBanResponse chuangJianDianZiFaPiaoKaQuanMoBan(ChuangJianDianZiFaPiaoKaQuanMoBanRequest chuangJianDianZiFaPiaoKaQuanMoBanRequest);

    /**
     * 配置开发选项
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-merchant/update-development-config.html
     * api:
     *
     * @param peiZhiKaiFaXuanXiangRequest
     */
    PeiZhiKaiFaXuanXiangResponse peiZhiKaiFaXuanXiang(PeiZhiKaiFaXuanXiangRequest peiZhiKaiFaXuanXiangRequest);

    /**
     * 查询商户配置的开发选项
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-merchant/query-development-config.html
     * api:
     *
     * @param chaXunShangHuPeiZhiDeKaiFaXuanXiangRequest
     */
    ChaXunShangHuPeiZhiDeKaiFaXuanXiangResponse chaXunShangHuPeiZhiDeKaiFaXuanXiang(ChaXunShangHuPeiZhiDeKaiFaXuanXiangRequest chaXunShangHuPeiZhiDeKaiFaXuanXiangRequest);

    /**
     * 获取抬头填写链接
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/user-title/acquire-fapiao-title-url.html
     * api:
     *
     * @param huoQuTaiTouTianXieLianJieRequest
     */
    HuoQuTaiTouTianXieLianJieResponse huoQuTaiTouTianXieLianJie(HuoQuTaiTouTianXieLianJieRequest huoQuTaiTouTianXieLianJieRequest);

    /**
     * 用户发票抬头填写完成通知
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-card-template/user-invoice-rise-write-notice.html
     * api: ，必须为HTTPS协议。如果链接无法访问，商户将无法接收到微信通知。 通知URL必须为直接可访问的URL，不能携带参数。示例:"http://pay.weixin.qq.com/wxpay/pay.action"
     *
     * @param yongHuFaPiaoTaiTouTianXieWanChengTongZhiRequest
     */
    YongHuFaPiaoTaiTouTianXieWanChengTongZhiResponse yongHuFaPiaoTaiTouTianXieWanChengTongZhi(YongHuFaPiaoTaiTouTianXieWanChengTongZhiRequest yongHuFaPiaoTaiTouTianXieWanChengTongZhiRequest);

    /**
     * 获取用户填写的抬头
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/user-title/get-user-title.html
     * api:
     *
     * @param huoQuYongHuTianXieDeTaiTouRequest
     */
    HuoQuYongHuTianXieDeTaiTouResponse huoQuYongHuTianXieDeTaiTou(HuoQuYongHuTianXieDeTaiTouRequest huoQuYongHuTianXieDeTaiTouRequest);

    /**
     * 发票卡券作废通知
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-card-template/invoice-card-cancel-notice.html
     * api: ，必须为HTTPS协议。如果链接无法访问，商户将无法接收到微信通知。 通知URL必须为直接可访问的URL，不能携带参数。示例:"http://pay.weixin.qq.com/wxpay/pay.action"
     *
     * @param faPiaoKaQuanZuoFeiTongZhiRequest
     */
    FaPiaoKaQuanZuoFeiTongZhiResponse faPiaoKaQuanZuoFeiTongZhi(FaPiaoKaQuanZuoFeiTongZhiRequest faPiaoKaQuanZuoFeiTongZhiRequest);

    /**
     * 获取商户开票基础信息
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-merchant/get-merchant-info.html
     * api:
     *
     * @param huoQuShangHuKaiPiaoJiChuXinXiRequest
     */
    HuoQuShangHuKaiPiaoJiChuXinXiResponse huoQuShangHuKaiPiaoJiChuXinXi(HuoQuShangHuKaiPiaoJiChuXinXiRequest huoQuShangHuKaiPiaoJiChuXinXiRequest);

    /**
     * 获取商品和服务税收分类对照表
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-merchant/list-merchant-tax-codes.html
     * api:
     *
     * @param huoQuShangPinHeFuWuShuiShouFenLeiDuiZhaoBiaoRequest
     */
    HuoQuShangPinHeFuWuShuiShouFenLeiDuiZhaoBiaoResponse huoQuShangPinHeFuWuShuiShouFenLeiDuiZhaoBiao(HuoQuShangPinHeFuWuShuiShouFenLeiDuiZhaoBiaoRequest huoQuShangPinHeFuWuShuiShouFenLeiDuiZhaoBiaoRequest);

    /**
     * 开具电子发票
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/issue-fapiao-applications.html
     * api:
     *
     * @param kaiJuDianZiFaPiaoRequest
     */
    KaiJuDianZiFaPiaoResponse kaiJuDianZiFaPiao(KaiJuDianZiFaPiaoRequest kaiJuDianZiFaPiaoRequest);

    /**
     * 冲红电子发票
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/reverse-fapiao-applications.html
     * api:
     *
     * @param chongHongDianZiFaPiaoRequest
     */
    ChongHongDianZiFaPiaoResponse chongHongDianZiFaPiao(ChongHongDianZiFaPiaoRequest chongHongDianZiFaPiaoRequest);

    /**
     * 查询电子发票
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/get-fapiao-applications.html
     * api:
     *
     * @param chaXunDianZiFaPiaoRequest
     */
    ChaXunDianZiFaPiaoResponse chaXunDianZiFaPiao(ChaXunDianZiFaPiaoRequest chaXunDianZiFaPiaoRequest);

    /**
     * 获取发票下载信息
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/get-fapiao-file-download-info.html
     * api:
     *
     * @param huoQuFaPiaoXiaZaiXinXiRequest
     */
    HuoQuFaPiaoXiaZaiXinXiResponse huoQuFaPiaoXiaZaiXinXi(HuoQuFaPiaoXiaZaiXinXiRequest huoQuFaPiaoXiaZaiXinXiRequest);

    /**
     * 下载发票文件
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/download-invoice-file.html
     * api: 通过,口获取到“download_url”，URL有效期为30s，仅能下载ISSUED状态的发票。
     *
     * @param xiaZaiFaPiaoWenJianRequest
     */
    XiaZaiFaPiaoWenJianResponse xiaZaiFaPiaoWenJian(XiaZaiFaPiaoWenJianRequest xiaZaiFaPiaoWenJianRequest);

    /**
     * 发票开具成功通知
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/invoice-flush-success-notice.html
     * api: ，必须为HTTPS协议。如果链接无法访问，商户将无法接收到微信通知。 通知URL必须为直接可访问的URL，不能携带参数。示例:"http://pay.weixin.qq.com/wxpay/pay.action"
     *
     * @param faPiaoKaiJuChengGongTongZhiRequest
     */
    FaPiaoKaiJuChengGongTongZhiResponse faPiaoKaiJuChengGongTongZhi(FaPiaoKaiJuChengGongTongZhiRequest faPiaoKaiJuChengGongTongZhiRequest);

    /**
     * 发票冲红成功通知
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/invoice-flush-success-notice.html
     * api: ，必须为HTTPS协议。如果链接无法访问，商户将无法接收到微信通知。 通知URL必须为直接可访问的URL，不能携带参数。示例:"http://pay.weixin.qq.com/wxpay/pay.action"
     *
     * @param faPiaoChongHongChengGongTongZhiRequest
     */
    FaPiaoChongHongChengGongTongZhiResponse faPiaoChongHongChengGongTongZhi(FaPiaoChongHongChengGongTongZhiRequest faPiaoChongHongChengGongTongZhiRequest);

    /**
     * 上传电子发票文件
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/upload-fapiao-file.html
     * api:
     *
     * @param shangChuanDianZiFaPiaoWenJianRequest
     */
    ShangChuanDianZiFaPiaoWenJianResponse shangChuanDianZiFaPiaoWenJian(ShangChuanDianZiFaPiaoWenJianRequest shangChuanDianZiFaPiaoWenJianRequest);

    /**
     * 将电子发票插入微信用户卡包
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/insert-cards.html
     * api:
     *
     * @param jiangDianZiFaPiaoChaRuWeiXinYongHuKaBaoRequest
     */
    JiangDianZiFaPiaoChaRuWeiXinYongHuKaBaoResponse jiangDianZiFaPiaoChaRuWeiXinYongHuKaBao(JiangDianZiFaPiaoChaRuWeiXinYongHuKaBaoRequest jiangDianZiFaPiaoChaRuWeiXinYongHuKaBaoRequest);

    /**
     * 发票插入用户卡包成功通知
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/fapiao/fapiao-applications/invoice-insert-bag-success-notice.html
     * api: ，必须为HTTPS协议。如果链接无法访问，商户将无法接收到微信通知。 通知URL必须为直接可访问的URL，不能携带参数。示例:"http://pay.weixin.qq.com/wxpay/pay.action"
     *
     * @param faPiaoChaRuYongHuKaBaoChengGongTongZhiRequest
     */
    FaPiaoChaRuYongHuKaBaoChengGongTongZhiResponse faPiaoChaRuYongHuKaBaoChengGongTongZhi(FaPiaoChaRuYongHuKaBaoChengGongTongZhiRequest faPiaoChaRuYongHuKaBaoChengGongTongZhiRequest);
}