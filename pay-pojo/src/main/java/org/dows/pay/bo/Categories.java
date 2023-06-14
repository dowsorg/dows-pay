package org.dows.pay.bo;

import lombok.Data;
import me.chanjar.weixin.open.bean.ma.WxFastMaCategory;

import java.util.List;


/**
 * @Author longhui.shi
 * @Date 2023/6/14 10:43
 * @PackageName:org.dows.pay.bo
 * @ClassName: categories
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class Categories {

    private List<WxFastMaCategory> categories;
}
