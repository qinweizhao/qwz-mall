package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.convert.SkuImageConvert;
import com.qinweizhao.product.convert.SkuInfoConvert;
import com.qinweizhao.product.convert.SpuInfoDetailConvert;
import com.qinweizhao.product.mapper.PmsSkuImageMapper;
import com.qinweizhao.product.mapper.PmsSkuInfoMapper;
import com.qinweizhao.product.mapper.PmsSpuInfoDetailMapper;
import com.qinweizhao.product.model.dto.AttrGroupWithAttrsDTO;
import com.qinweizhao.product.model.dto.SkuItemAttrDTO;
import com.qinweizhao.product.model.entity.PmsSkuImage;
import com.qinweizhao.product.model.entity.PmsSkuInfo;
import com.qinweizhao.product.model.entity.PmsSpuInfoDetail;
import com.qinweizhao.product.model.vo.SkuItemVo;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSkuInfoServiceImpl implements IPmsSkuInfoService {


    @Resource
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Resource
    private IPmsAttrGroupService pmsAttrGroupService;

    @Resource
    private PmsSpuInfoDetailMapper pmsSpuInfoDetailMapper;

    @Resource
    private IPmsSkuAttrValueService pmsSkuAttrValueService;

    @Resource
    private PmsSkuImageMapper pmsSkuImageMapper;

    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    @Override
    public PmsSkuInfo getById(Long skuId) {
        return pmsSkuInfoMapper.selectById(skuId);
    }

    /**
     * 查询sku信息列表
     *
     * @param pmsSkuInfo sku信息
     * @return sku信息
     */
    @Override
    public List<PmsSkuInfo> list(PmsSkuInfo pmsSkuInfo) {
        return pmsSkuInfoMapper.selectPmsSkuInfoList(pmsSkuInfo);
    }

    /**
     * 新增sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    @Override
    public int save(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setCreateTime(DateUtils.getNowDate());
        return pmsSkuInfoMapper.insertPmsSkuInfo(pmsSkuInfo);
    }

    /**
     * 修改sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    @Override
    public int updateById(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setUpdateTime(DateUtils.getNowDate());
        return pmsSkuInfoMapper.updatePmsSkuInfo(pmsSkuInfo);
    }

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的sku信息主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] skuIds) {
        return pmsSkuInfoMapper.deletePmsSkuInfoBySkuIds(skuIds);
    }

    /**
     * 删除sku信息信息
     *
     * @param skuId sku信息主键
     * @return 结果
     */
    @Override
    public int removeById(Long skuId) {
        return pmsSkuInfoMapper.deletePmsSkuInfoBySkuId(skuId);
    }

    @Override
    public List<PmsSkuInfo> listBySpuId(Long spuId) {
        return pmsSkuInfoMapper.selectListBySpuId(spuId);
    }

    @Override
    public SkuItemVo getItemById(Long skuId) {
        SkuItemVo skuItem = new SkuItemVo();

        // 1.sku 基本信息获取
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectById(skuId);
        skuItem.setSkuInfo(SkuInfoConvert.INSTANCE.convert(pmsSkuInfo));

        // 2.sku 图片信息
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> imageList = pmsSkuImageMapper.selectPmsSkuImageList(pmsSkuImage);
        skuItem.setSkuImages(SkuImageConvert.INSTANCE.convertToDTO(imageList));


        Long spuId = pmsSkuInfo.getSpuId();

        // 3.获取spu的销售组合
        List<SkuItemAttrDTO> saleAttrList = pmsSkuAttrValueService.listSkuItemAttrBySpuId(spuId);
        skuItem.setSaleAttr(saleAttrList);


        // 4.获取 spu 详情（介绍）
        PmsSpuInfoDetail pmsSpuInfoDetail = pmsSpuInfoDetailMapper.selectPmsSpuInfoDetailBySpuId(spuId);
        skuItem.setSpuInfoDetail(SpuInfoDetailConvert.INSTANCE.convert(pmsSpuInfoDetail));

        // 5.获取spu的规格参数信息
        Long categoryId = pmsSkuInfo.getCategoryId();
        List<AttrGroupWithAttrsDTO> spuItemAttrGroupDTOList = pmsAttrGroupService.listAttrGroupWithAttrsByCategoryId(categoryId, spuId);
        skuItem.setGroupAttrs(spuItemAttrGroupDTOList);


        return skuItem;
    }
}
