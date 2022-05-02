package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.product.entity.*;
import com.qinweizhao.product.entity.vo.PmsSpuSaveVO;
import com.qinweizhao.product.mapper.PmsSpuInfoMapper;
import com.qinweizhao.product.service.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSpuInfoServiceImpl implements IPmsSpuInfoService {

    @Resource
    private PmsSpuInfoMapper pmsSpuInfoMapper;

    @Resource
    private IPmsSpuInfoDetailService pmsSpuInfoDetailService;

    @Resource
    private IPmsSpuImageService pmsSpuImageService;

    @Resource
    private IPmsAttrService pmsAttrService;

    @Resource
    private IPmsSpuAttrValueService pmsSpuAttrValueService;

    @Resource
    private IPmsSkuAttrValueService pmsSkuAttrValueService;

    @Resource
    private IPmsSkuInfoService pmsSkuInfoService;

    @Resource
    private IPmsSkuImageService pmsSkuImageService;

    /**
     * 查询spu信息
     *
     * @param spuId spu信息主键
     * @return spu信息
     */
    @Override
    public PmsSpuInfo selectPmsSpuInfoBySpuId(Long spuId) {
        return pmsSpuInfoMapper.selectPmsSpuInfoBySpuId(spuId);
    }

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息
     */
    @Override
    public List<PmsSpuInfo> selectPmsSpuInfoList(PmsSpuInfo pmsSpuInfo) {
        return pmsSpuInfoMapper.selectPmsSpuInfoList(pmsSpuInfo);
    }

    /**
     * 新增spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    @Override
    public int insertPmsSpuInfo(PmsSpuInfo pmsSpuInfo) {
        pmsSpuInfo.setCreateTime(DateUtils.getNowDate());
        return pmsSpuInfoMapper.insertPmsSpuInfo(pmsSpuInfo);
    }

    /**
     * 修改spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    @Override
    public int updatePmsSpuInfo(PmsSpuInfo pmsSpuInfo) {
        pmsSpuInfo.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuInfoMapper.updatePmsSpuInfo(pmsSpuInfo);
    }

    /**
     * 批量删除spu信息
     *
     * @param spuIds 需要删除的spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoBySpuIds(Long[] spuIds) {
        return pmsSpuInfoMapper.deletePmsSpuInfoBySpuIds(spuIds);
    }

    /**
     * 删除spu信息信息
     *
     * @param spuId spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoBySpuId(Long spuId) {
        return pmsSpuInfoMapper.deletePmsSpuInfoBySpuId(spuId);
    }


    /**
     * todo
     * 3、5 、6.2批量保存
     * 发布商品
     *
     * @param pmsSpuSaveVO pmsSpuSaveVO
     * @return boolean
     */
    @Override
    public boolean insertSpu(PmsSpuSaveVO pmsSpuSaveVO) {
        // 1、保存spu基本信息 pms_spu_info
        PmsSpuInfo pmsSpuInfo = new PmsSpuInfo();
        BeanUtils.copyProperties(pmsSpuSaveVO, pmsSpuInfo);
        pmsSpuInfoMapper.insertPmsSpuInfo(pmsSpuInfo);


        Long spuId = pmsSpuInfo.getSpuId();
        Long brandId = pmsSpuInfo.getBrandId();
        Long categoryId = pmsSpuInfo.getCategoryId();


        // 2、保存spu的描述图片 pms_spu_info_detail
        String details = pmsSpuSaveVO.getDetails();
        PmsSpuInfoDetail pmsSpuInfoDetail = new PmsSpuInfoDetail();
        pmsSpuInfoDetail.setDetail(details);
        pmsSpuInfoDetail.setSpuId(pmsSpuInfo.getSpuId());
        pmsSpuInfoDetailService.insertPmsSpuInfoDetail(pmsSpuInfoDetail);

        // 3、保存spu的图片集 pms_spu_image
        List<String> spuImages = pmsSpuSaveVO.getImages();

        spuImages.forEach(item -> {
            PmsSpuImage pmsSpuImage = new PmsSpuImage();
            pmsSpuImage.setSpuId(spuId);
            pmsSpuImage.setUrl(item);
            pmsSpuImage.setName(StringUtils.getFilename(item));

            pmsSpuImageService.insertPmsSpuImage(pmsSpuImage);
        });


        // 4、保存spu的积分信息；mall_ams->ams_spu_bounds
        // 暂时先搁置

        // 5、保存spu的规格参数;pms_spu_attr_value
        List<PmsSpuSaveVO.BaseAttr> baseAttrs = pmsSpuSaveVO.getBaseAttrs();
        baseAttrs.forEach(baseAttr -> {
            PmsSpuAttrValue pmsSpuAttrValue = new PmsSpuAttrValue();

            Long attrId = baseAttr.getAttrId();
            PmsAttr pmsAttr = pmsAttrService.selectPmsAttrByAttrId(attrId);
            pmsSpuAttrValue.setAttrId(attrId);
            pmsSpuAttrValue.setName(pmsAttr.getName());
            pmsSpuAttrValue.setValue(baseAttr.getAttrValues());
            pmsSpuAttrValue.setQuickShow(baseAttr.getQuickShow());
            pmsSpuAttrValue.setSpuId(spuId);

            pmsSpuAttrValueService.insertPmsSpuAttrValue(pmsSpuAttrValue);
        });

        // 6、保存当前spu对应的所有sku信息
        List<PmsSpuSaveVO.Skus> skus = pmsSpuSaveVO.getSkus();
        if (!skus.isEmpty()) {
            skus.forEach(skuItem -> {

                // 6.1）、sku的基本信息；pms_sku_info
                PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
                BeanUtils.copyProperties(skuItem, pmsSkuInfo);
                pmsSkuInfo.setBrandId(brandId);
                pmsSkuInfo.setCategoryId(categoryId);
                pmsSkuInfo.setSaleCount(0L);
                String defaultImg = "";
                for (PmsSpuSaveVO.Skus.Images image : skuItem.getImages()) {
                    if (image.getDefaultImg() == 1) {
                        defaultImg = image.getImgUrl();
                    }
                }
                pmsSkuInfo.setDefaultImg(defaultImg);
                pmsSkuInfoService.insertPmsSkuInfo(pmsSkuInfo);


                Long skuId = pmsSkuInfo.getSkuId();
                // 6.2）、sku的图片信息；pms_sku_image
                List<PmsSpuSaveVO.Skus.Images> skuImages = skuItem.getImages();
                skuImages.forEach(imageItem -> {
                    String imgUrl = imageItem.getImgUrl();
                    // 没有图片无需保存
                    if (ObjectUtils.isEmpty(imgUrl)) {
                        PmsSkuImage pmsSkuImage = new PmsSkuImage();
                        pmsSkuImage.setSkuId(skuId);
                        pmsSkuImage.setUrl(imgUrl);
                        pmsSkuImage.setDefaultImage(imageItem.getDefaultImg());
                        pmsSkuImageService.insertPmsSkuImage(pmsSkuImage);
                    }
                });

                // 6.3）、sku的销售属性信息：pms_sku_attr_value
                List<PmsSpuSaveVO.Skus.SaleAttr> saleAttrs = skuItem.getSaleAttrs();
                saleAttrs.forEach(saleAttrItem -> {
                    PmsSkuAttrValue pmsSkuAttrValue = new PmsSkuAttrValue();
                    BeanUtils.copyProperties(saleAttrItem, pmsSkuAttrValue);
                    pmsSkuAttrValue.setSkuId(skuId);
                    pmsSkuAttrValueService.insertPmsSkuAttrValue(pmsSkuAttrValue);
                });

                // 6.4）、sku的优惠、满减等信息；mall_ams->ams_sku_ladder\ams_sku_full_reduction\ams_member_price

                // 待完善

            });
        }


        return false;
    }
}
