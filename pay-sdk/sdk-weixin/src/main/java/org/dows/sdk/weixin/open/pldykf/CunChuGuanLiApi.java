package org.dows.sdk.weixin.open.pldykf;

import org.dows.sdk.weixin.open.pldykf.request.HuoQuShangChuanWenJianLianJieRequest;
import org.dows.sdk.weixin.open.pldykf.request.HuoQuWenJianLieBiaoRequest;
import org.dows.sdk.weixin.open.pldykf.request.HuoQuXiaZaiWenJianLianJieRequest;
import org.dows.sdk.weixin.open.pldykf.request.ShanChuWenJianRequest;
import org.dows.sdk.weixin.open.pldykf.response.HuoQuShangChuanWenJianLianJieResponse;
import org.dows.sdk.weixin.open.pldykf.response.HuoQuWenJianLieBiaoResponse;
import org.dows.sdk.weixin.open.pldykf.response.HuoQuXiaZaiWenJianLianJieResponse;
import org.dows.sdk.weixin.open.pldykf.response.ShanChuWenJianResponse;

/**
 * 存储管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface CunChuGuanLiApi {

    /**
     * 获取上传文件链接
     * descr: 通过本接口可以获取上传文件链接，使用过程中如遇到问题，可在,发帖交流。,用户获取到返回数据后，需拼装一个 HTTP POST 请求，其中 url 为返回包的 url 字段，Body 部分格式为 multipart/form-data，具体内容如下：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/getUploadFileLink.html
     * api: https://api.weixin.qq.com/componenttcb/uploadfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuShangChuanWenJianLianJieRequest
     */
    HuoQuShangChuanWenJianLianJieResponse huoQuShangChuanWenJianLianJie(HuoQuShangChuanWenJianLianJieRequest huoQuShangChuanWenJianLianJieRequest);

    /**
     * 删除文件
     * descr: 通过本接口可以删除文件，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/deleteTcbFile.html
     * api: https://api.weixin.qq.com/componenttcb/batchdeletefile?access_token=ACCESS_TOKEN
     *
     * @param shanChuWenJianRequest
     */
    ShanChuWenJianResponse shanChuWenJian(ShanChuWenJianRequest shanChuWenJianRequest);

    /**
     * 获取文件列表
     * descr: 通过本接口可以查看文件列表，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/getTcbFile.html
     * api: https://api.weixin.qq.com/componenttcb/getbucket?access_token=ACCESS_TOKEN
     *
     * @param huoQuWenJianLieBiaoRequest
     */
    HuoQuWenJianLieBiaoResponse huoQuWenJianLieBiao(HuoQuWenJianLieBiaoRequest huoQuWenJianLieBiaoRequest);

    /**
     * 获取下载文件链接
     * descr: 通过本接口可以获取下载文件链接，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/getDownloadFileLink.html
     * api: https://api.weixin.qq.com/componenttcb/batchdownloadfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaZaiWenJianLianJieRequest
     */
    HuoQuXiaZaiWenJianLianJieResponse huoQuXiaZaiWenJianLianJie(HuoQuXiaZaiWenJianLianJieRequest huoQuXiaZaiWenJianLianJieRequest);
}