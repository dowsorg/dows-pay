package org.dows.pay.bo;

import lombok.Data;

/**
 * @Author longhui.shi
 * @Date 2023/6/14 16:48
 * @PackageName:org.dows.pay.bo
 * @ClassName: uploadBo
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class UploadBo {
    //    {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
    private String type;
    private String media_id;
    private String created_at;
}
