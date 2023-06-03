package org.dows.sdk.weixin.open.pldykf;

import org.dows.sdk.weixin.open.pldykf.request.*;
import org.dows.sdk.weixin.open.pldykf.response.*;

/**
 * 数据库管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface ShuJuKuGuanLiApi {

    /**
     * 数据库导入
     * descr: 通过本接口可以数据库导入，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbImport.html
     * api: https://api.weixin.qq.com/componenttcb/dbimport?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuDaoRuRequest
     */
    ShuJuKuDaoRuResponse shuJuKuDaoRu(ShuJuKuDaoRuRequest shuJuKuDaoRuRequest);

    /**
     * 数据库导出
     * descr: 通过本接口可以数据库导出，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbExport.html
     * api: https://api.weixin.qq.com/componenttcb/dbexport?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuDaoChuRequest
     */
    ShuJuKuDaoChuResponse shuJuKuDaoChu(ShuJuKuDaoChuRequest shuJuKuDaoChuRequest);

    /**
     * 数据库状态查询
     * descr: 通过本接口可以数据库导入/导出状态查询，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getMigrationState.html
     * api: https://api.weixin.qq.com/componenttcb/dbmigrationstate?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuZhuangTaiChaXunRequest
     */
    ShuJuKuZhuangTaiChaXunResponse shuJuKuZhuangTaiChaXun(ShuJuKuZhuangTaiChaXunRequest shuJuKuZhuangTaiChaXunRequest);

    /**
     * 数据库聚合
     * descr: 通过本接口可以数据库聚合，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbAggregate.html
     * api: https://api.weixin.qq.com/componenttcb/dbaggregate?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuJuHeRequest
     */
    ShuJuKuJuHeResponse shuJuKuJuHe(ShuJuKuJuHeRequest shuJuKuJuHeRequest);

    /**
     * 获取数据库操作权限
     * descr: 通过本接口可以获取数据库操作权限，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getPermission.html
     * api: https://api.weixin.qq.com/componenttcb/dbgetacl?access_token=ACCESS_TOKEN
     *
     * @param huoQuShuJuKuCaoZuoQuanXianRequest
     */
    HuoQuShuJuKuCaoZuoQuanXianResponse huoQuShuJuKuCaoZuoQuanXian(HuoQuShuJuKuCaoZuoQuanXianRequest huoQuShuJuKuCaoZuoQuanXianRequest);

    /**
     * 修改数据库操作权限
     * descr: 通过本接口可以修改数据库操作权限，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/setPermission.html
     * api: https://api.weixin.qq.com/componenttcb/dbmodifyacl?access_token=ACCESS_TOKEN
     *
     * @param xiuGaiShuJuKuCaoZuoQuanXianRequest
     */
    XiuGaiShuJuKuCaoZuoQuanXianResponse xiuGaiShuJuKuCaoZuoQuanXian(XiuGaiShuJuKuCaoZuoQuanXianRequest xiuGaiShuJuKuCaoZuoQuanXianRequest);

    /**
     * 数据库记录管理
     * descr: 该接口可用于对数据库记录进行管理，包含插入记录、删除记录、更新记录、查询记录等功能。,返回的 JSON 数据包,返回的 JSON 数据包,返回的 JSON 数据包,返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbrecordManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbrecord?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuJiLuGuanLiRequest
     */
    ShuJuKuJiLuGuanLiResponse shuJuKuJiLuGuanLi(ShuJuKuJiLuGuanLiRequest shuJuKuJiLuGuanLiRequest);

    /**
     * 数据库索引管理
     * descr: 该接口用于创建索引和删除索引,返回的 JSON 数据包,返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbindexManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbindex?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuSuoYinGuanLiRequest
     */
    ShuJuKuSuoYinGuanLiResponse shuJuKuSuoYinGuanLi(ShuJuKuSuoYinGuanLiRequest shuJuKuSuoYinGuanLiRequest);
}