package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.*;
import org.dows.sdk.weixin.open.ptdykf.response.*;

/**
 * 数据库管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface PtdykfShuJuKuGuanLiApi {

    /**
     * 数据库集合管理
     * descr: 数据库集合管理,返回的 JSON 数据包,返回的 JSON 数据包,返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/dbcollectionManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbcollection?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuJiHeGuanLiRequest
     */
    ShuJuKuJiHeGuanLiResponse shuJuKuJiHeGuanLi(ShuJuKuJiHeGuanLiRequest shuJuKuJiHeGuanLiRequest);

    /**
     * 数据库插入记录
     * descr: 通过本接口可以数据库插入记录。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databaseadd?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuChaRuJiLuRequest
     */
    ShuJuKuChaRuJiLuResponse shuJuKuChaRuJiLu(ShuJuKuChaRuJiLuRequest shuJuKuChaRuJiLuRequest);

    /**
     * 新增集合
     * descr: 通过本接口可以新增集合.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectionadd?access_token=ACCESS_TOKEN
     *
     * @param xinZengJiHeRequest
     */
    XinZengJiHeResponse xinZengJiHe(XinZengJiHeRequest xinZengJiHeRequest);

    /**
     * 删除集合
     * descr: 通过本接口可以删除集合.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/deleteDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectiondelete?access_token=ACCESS_TOKEN
     *
     * @param shanChuJiHeRequest
     */
    ShanChuJiHeResponse shanChuJiHe(ShanChuJiHeRequest shanChuJiHeRequest);

    /**
     * 获取集合信息
     * descr: 通过本接口可以获取特定云环境下集合信息。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectionget?access_token=ACCESS_TOKEN
     *
     * @param huoQuJiHeXinXiRequest
     */
    HuoQuJiHeXinXiResponse huoQuJiHeXinXi(HuoQuJiHeXinXiRequest huoQuJiHeXinXiRequest);

    /**
     * 统计集合记录数
     * descr: 通过本接口可以统计集合记录数或统计查询语句对应的结果记录数。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseCount.html
     * api: https://api.weixin.qq.com/tcb/databasecount?access_token=ACCESS_TOKEN
     *
     * @param tongJiJiHeJiLuShuRequest
     */
    TongJiJiHeJiLuShuResponse tongJiJiHeJiLuShu(TongJiJiHeJiLuShuRequest tongJiJiHeJiLuShuRequest);

    /**
     * 数据库删除记录
     * descr: 通过本接口可以数据库删除记录.使用过程中如遇到问题，可在,发帖交流。,数据库操作语句说明 数据库操作语句语法与数据库 API相同
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/deleteDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasedelete?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuShanChuJiLuRequest
     */
    ShuJuKuShanChuJiLuResponse shuJuKuShanChuJiLu(ShuJuKuShanChuJiLuRequest shuJuKuShanChuJiLuRequest);

    /**
     * 数据库导出
     * descr: 通过本接口可以进行数据库导出.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/exportDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasemigrateexport?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuDaoChuRequest
     */
    ShuJuKuDaoChuResponse shuJuKuDaoChu(ShuJuKuDaoChuRequest shuJuKuDaoChuRequest);

    /**
     * 数据库导入
     * descr: 通过本接口可以进行数据库导入.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/importDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasemigrateimport?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuDaoRuRequest
     */
    ShuJuKuDaoRuResponse shuJuKuDaoRu(ShuJuKuDaoRuRequest shuJuKuDaoRuRequest);

    /**
     * 数据库查询记录
     * descr: 通过本接口可以数据库查询记录.使用过程中如遇到问题，可在,发帖交流。,Tips query中应使用limit()限制单次拉取的数量，默认10条。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseRecord.html
     * api: https://api.weixin.qq.com/tcb/databasequery?access_token=ACCESS_TOKEN
     *
     * @param shuJuKuChaXunJiLuRequest
     */
    ShuJuKuChaXunJiLuResponse shuJuKuChaXunJiLu(ShuJuKuChaXunJiLuRequest shuJuKuChaXunJiLuRequest);

    /**
     * 更新数据库索引
     * descr: 通过本接口可以变更数据库索引.使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/updateDatabaseIndex.html
     * api: https://api.weixin.qq.com/tcb/updateindex?access_token=ACCESS_TOKEN
     *
     * @param gengXinShuJuKuSuoYinRequest
     */
    GengXinShuJuKuSuoYinResponse gengXinShuJuKuSuoYin(GengXinShuJuKuSuoYinRequest gengXinShuJuKuSuoYinRequest);
}