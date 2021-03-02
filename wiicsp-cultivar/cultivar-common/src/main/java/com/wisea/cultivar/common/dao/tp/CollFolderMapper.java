package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CollFolder;
import com.wisea.cultivar.common.po.tp.CollFolderListPo;
import com.wisea.cultivar.common.po.tp.CollFolderPagePo;
import com.wisea.cultivar.common.vo.tp.CollFolderListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * coll_folder 表DAO
 * 收藏夹
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface CollFolderMapper extends CrudDao<CollFolder> {
    List<CollFolderListVo> findPage(CollFolderPagePo collFolderPagePo);

    List<CollFolderListVo> findList(CollFolderListPo collFolderListPo);

    /*
     * 收藏爱茶
     * */
    Integer collectTea(List<CollFolder> po);

    /*
    * 查询已经存在于收藏夹中的茶
    * */
    CollFolder selectTeasIsCollFolder(CollFolder coll);

    /*
     * 根据商品的名称和编号进行查询
     * */
    List<CollFolderListVo> selectCollComm(CollFolderPagePo po);
}
