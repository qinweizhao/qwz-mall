package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsSpuAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * spu属性值Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSpuAttrValueMapper {
    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    PmsSpuAttrValue selectPmsSpuAttrValueById(Long id);

    /**
     * 查询spu属性值列表
     *
     * @param pmsSpuAttrValue spu属性值
     * @return spu属性值集合
     */
    List<PmsSpuAttrValue> selectPmsSpuAttrValueList(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 新增spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    int insertPmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 修改spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    int updatePmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 删除spu属性值
     *
     * @param id spu属性值主键
     * @return 结果
     */
    int deletePmsSpuAttrValueById(Long id);

    /**
     * 批量删除spu属性值
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsSpuAttrValueByIds(Long[] ids);

    /**
     * 查询需要检索的属性
     * @param spuId spuId
     * @param searchType searchType
     * @return List
     */
    List<PmsSpuAttrValue> selectSearchAttrValueListBySpuId(@Param("spuId") Long spuId,@Param("searchType") Long searchType);

    /**
     * 查询属性值
     * @param spuId spuId
     * @param attrId attrId
     * @return PmsSpuAttrValue
     */
    PmsSpuAttrValue selectBySpuIdAndAttrId(@Param("spuId")Long spuId,@Param("attrId") Long attrId);
}
