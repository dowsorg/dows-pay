package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.*;
import org.dows.sdk.weixin.open.ptdykf.response.*;

/**
 * 文件管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WenJianGuanLiApi {

    /**
     * 获取文件上传链接
     * descr: 通过本接口可以获取文件上传链接。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getUploadTcbFileLink.html
     * api: https://api.weixin.qq.com/tcb/uploadfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuWenJianShangChuanLianJieRequest
     */
    HuoQuWenJianShangChuanLianJieResponse huoQuWenJianShangChuanLianJie(HuoQuWenJianShangChuanLianJieRequest huoQuWenJianShangChuanLianJieRequest);

    /**
     * 删除文件
     * descr: 通过本接口可以删除文件.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/deleteTcbCloudFile.html
     * api: https://api.weixin.qq.com/tcb/batchdeletefile?access_token=ACCESS_TOKEN
     *
     * @param shanChuWenJianRequest
     */
    ShanChuWenJianResponse shanChuWenJian(ShanChuWenJianRequest shanChuWenJianRequest);

    /**
     * 获取文件下载链接
     * descr: 通过本接口可以获取文件下载链接.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getDownloadTcbFileLink.html
     * api: https://api.weixin.qq.com/tcb/batchdownloadfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuWenJianXiaZaiLianJieRequest
     */
    HuoQuWenJianXiaZaiLianJieResponse huoQuWenJianXiaZaiLianJie(HuoQuWenJianXiaZaiLianJieRequest huoQuWenJianXiaZaiLianJieRequest);

    /**
     * 数据库聚合
     * descr: 通过本接口可以数据库聚合。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/aggregateDatabase.html
     * api: https://api.weixin.qq.com/tcb/databaseaggregate?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuJuHeRequest
     */
    ShuJuKuJuHeResponse shuJuKuJuHe(ShuJuKuJuHeRequest shuJuKuJuHeRequest);

    /**
     * 数据库迁移状态查询
     * descr: 通过本接口可以数据库迁移状态查询.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getDatabaseMigrateStatus.html
     * api: https://api.weixin.qq.com/tcb/databasemigratequeryinfo?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuQianYiZhuangTaiChaXunRequest
     */
    ShuJuKuQianYiZhuangTaiChaXunResponse shuJuKuQianYiZhuangTaiChaXun(ShuJuKuQianYiZhuangTaiChaXunRequest shuJuKuQianYiZhuangTaiChaXunRequest);

    /**
     * 数据库更新记录
     * descr: 通过本接口可以数据库更新记录.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/updateDatabaseRecord.html
     * api: https://api.weixin.qq.com/tcb/databaseupdate?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuGengXinJiLuRequest
     */
    ShuJuKuGengXinJiLuResponse shuJuKuGengXinJiLu(ShuJuKuGengXinJiLuRequest shuJuKuGengXinJiLuRequest);
}