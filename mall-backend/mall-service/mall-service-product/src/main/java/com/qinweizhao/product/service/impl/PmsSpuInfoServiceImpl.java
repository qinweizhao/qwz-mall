package com.qinweizhao.product.service.impl;


import com.qinweizhao.api.search.dto.EsSkuSaveDTO;
import com.qinweizhao.api.search.feign.ElasticSaveFeignService;
import com.qinweizhao.api.ware.dto.SkuHasStockDTO;
import com.qinweizhao.api.ware.feign.WareSkuFeignService;
import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.core.response.SystemResultCodeEnum;
import com.qinweizhao.product.mapper.PmsSpuInfoMapper;
import com.qinweizhao.product.constant.ProductConstant;
import com.qinweizhao.product.model.entity.*;
import com.qinweizhao.product.model.param.SpuSaveParam;
import com.qinweizhao.product.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Resource
    private IPmsBrandService pmsBrandService;

    @Resource
    private IPmsCategoryService pmsCategoryService;

    @Resource
    private WareSkuFeignService wareSkuFeignService;

    @Resource
    private ElasticSaveFeignService elasticSaveFeignService;

    /**
     * 查询spu信息
     *
     * @param spuId spu信息主键
     * @return spu信息
     */
    @Override
    public PmsSpuInfo getById(Long spuId) {
        return pmsSpuInfoMapper.selectPmsSpuInfoBySpuId(spuId);
    }

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息
     */
    @Override
    public List<PmsSpuInfo> list(PmsSpuInfo pmsSpuInfo) {
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
    public int updateById(PmsSpuInfo pmsSpuInfo) {
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
    public int removeByIds(Long[] spuIds) {
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
     * @param spuSaveParam pmsSpuSaveVO
     * @return boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveSpu(SpuSaveParam spuSaveParam) {

        String username = SecurityUtils.getUsername();


        // 1、保存spu基本信息 pms_spu_info
        PmsSpuInfo pmsSpuInfo = new PmsSpuInfo();
        BeanUtils.copyProperties(spuSaveParam, pmsSpuInfo);
        pmsSpuInfo.setCreateBy(username);
        pmsSpuInfo.setUpdateBy(username);
        pmsSpuInfoMapper.insertPmsSpuInfo(pmsSpuInfo);


        Long spuId = pmsSpuInfo.getSpuId();
        Long brandId = pmsSpuInfo.getBrandId();
        Long categoryId = pmsSpuInfo.getCategoryId();


        // 2、保存spu的描述图片 pms_spu_info_detail
        String details = spuSaveParam.getDetails();
        PmsSpuInfoDetail pmsSpuInfoDetail = new PmsSpuInfoDetail();
        pmsSpuInfoDetail.setDetail(details);
        pmsSpuInfoDetail.setCreateBy(username);
        pmsSpuInfoDetail.setUpdateBy(username);
        pmsSpuInfoDetail.setSpuId(pmsSpuInfo.getSpuId());
        pmsSpuInfoDetailService.save(pmsSpuInfoDetail);

        // 3、保存spu的图片集 pms_spu_image
        List<String> spuImages = spuSaveParam.getImages();

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
        List<SpuSaveParam.BaseAttr> baseAttrs = spuSaveParam.getBaseAttrs();
        baseAttrs.forEach(baseAttr -> {
            PmsSpuAttrValue pmsSpuAttrValue = new PmsSpuAttrValue();

            Long attrId = baseAttr.getAttrId();
            PmsAttr pmsAttr = pmsAttrService.getById(attrId);
            pmsSpuAttrValue.setAttrId(attrId);
            pmsSpuAttrValue.setName(pmsAttr.getName());
            pmsSpuAttrValue.setValue(baseAttr.getAttrValues());
            pmsSpuAttrValue.setQuickShow(baseAttr.getQuickShow());
            pmsSpuAttrValue.setSpuId(spuId);

            pmsSpuAttrValueService.save(pmsSpuAttrValue);
        });

        // 6、保存当前spu对应的所有sku信息
        List<SpuSaveParam.Skus> skus = spuSaveParam.getSkus();
        if (!skus.isEmpty()) {
            skus.forEach(skuItem -> {

                // 6.1）、sku的基本信息；pms_sku_info
                PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
                BeanUtils.copyProperties(skuItem, pmsSkuInfo);
                pmsSkuInfo.setPrice(skuItem.getPrice());
                pmsSkuInfo.setSpuId(spuId);
                pmsSkuInfo.setBrandId(brandId);
                pmsSkuInfo.setCategoryId(categoryId);
                pmsSkuInfo.setSaleCount(0L);
                String defaultImg = "";
                for (SpuSaveParam.Skus.Images image : skuItem.getImages()) {
                    if (image.getDefaultImg() == 1) {
                        defaultImg = image.getImgUrl();
                    }
                }
                pmsSkuInfo.setDefaultImg(defaultImg);
                pmsSkuInfoService.save(pmsSkuInfo);


                Long skuId = pmsSkuInfo.getSkuId();
                // 6.2）、sku的图片信息；pms_sku_image
                List<SpuSaveParam.Skus.Images> skuImages = skuItem.getImages();
                skuImages.forEach(imageItem -> {
                    String imgUrl = imageItem.getImgUrl();
                    // 没有图片无需保存
                    if (!ObjectUtils.isEmpty(imgUrl)) {
                        PmsSkuImage pmsSkuImage = new PmsSkuImage();
                        pmsSkuImage.setSkuId(skuId);
                        pmsSkuImage.setUrl(imgUrl);
                        pmsSkuImage.setDefaultImage(imageItem.getDefaultImg());
                        pmsSkuImageService.save(pmsSkuImage);
                    }
                });

                // 6.3）、sku的销售属性信息：pms_sku_attr_value
                List<SpuSaveParam.Skus.SaleAttr> saleAttrs = skuItem.getSaleAttrs();
                saleAttrs.forEach(saleAttrItem -> {
                    PmsSkuAttrValue pmsSkuAttrValue = new PmsSkuAttrValue();
                    BeanUtils.copyProperties(saleAttrItem, pmsSkuAttrValue);
                    pmsSkuAttrValue.setSkuId(skuId);
                    pmsSkuAttrValue.setAttrId(saleAttrItem.getAttrId());
                    pmsSkuAttrValueService.save(pmsSkuAttrValue);
                });

                // 6.4）、sku的优惠、满减等信息；mall_ams->ams_sku_ladder\ams_sku_full_reduction\ams_member_price

                // 待完善

            });
        }


        return true;
    }

    @Override
    public int updateSpuStatus(Long spuId) {
        PmsSpuInfo pmsSpuInfo = pmsSpuInfoMapper.selectPmsSpuInfoBySpuId(spuId);
        Long status = pmsSpuInfo.getStatus();

        PmsSpuInfo spuInfo = new PmsSpuInfo();

        if (ProductConstant.StatusEnum.SPU_UP.getCode().equals(status)) {
            // 下架
            this.productDown(spuId);
            spuInfo.setStatus(ProductConstant.StatusEnum.SPU_DOWN.getCode());
        } else {
            // 上架
            this.productUp(spuId);
            spuInfo.setStatus(ProductConstant.StatusEnum.SPU_UP.getCode());
        }
        pmsSpuInfo.setSpuId(spuId);
        return pmsSpuInfoMapper.updatePmsSpuInfo(pmsSpuInfo);
    }


    /**
     * 上架
     *
     * @param spuId spuId
     */
    private void productUp(Long spuId) {
        // 1、查出当前spu对应的所有sku信息，品牌的名字
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoService.listBySpuId(spuId);


        // 2.封装每个sku信息

        // 封装可检索属性
        List<PmsSpuAttrValue> pmsSpuAttrValues = pmsSpuAttrValueService.listSearchAttrValueBySpuId(spuId, ProductConstant.SearchEnum.Yes.getCode());
        List<EsSkuSaveDTO.Attr> esAttrs = pmsSpuAttrValues.stream()
                .map(item -> {
                    EsSkuSaveDTO.Attr esAttr = new EsSkuSaveDTO.Attr();
                    esAttr.setAttrId(item.getAttrId());
                    esAttr.setAttrName(item.getName());
                    esAttr.setAttrValue(item.getValue());
                    return esAttr;
                }).collect(Collectors.toList());

        // 查询是否有库存
        List<Long> skuIds = pmsSkuInfos.stream().map(PmsSkuInfo::getSkuId).collect(Collectors.toList());

        // TODO 调用失败？
        R<List<SkuHasStockDTO>> listR = wareSkuFeignService.listHasStockBySkuIds(skuIds,SecurityConstants.INNER);
        List<SkuHasStockDTO> data = listR.getData();
        Map<Long, Boolean> hasStockMap = data.stream().collect(Collectors.toMap(SkuHasStockDTO::getSkuId, SkuHasStockDTO::getHasStock));


        List<EsSkuSaveDTO> esSkuSaveDTOList = pmsSkuInfos.stream().map(sku -> {
            EsSkuSaveDTO esSkuSaveDTO = new EsSkuSaveDTO();
            esSkuSaveDTO.setSkuId(sku.getSkuId());
            esSkuSaveDTO.setSpuId(sku.getSpuId());
            esSkuSaveDTO.setSkuTitle(sku.getTitle());
            // todo
            esSkuSaveDTO.setSkuPrice(sku.getPrice().longValue());
            esSkuSaveDTO.setSkuImg(sku.getDefaultImg());
            esSkuSaveDTO.setSaleCount(sku.getSaleCount());
            // 是否有库存

            esSkuSaveDTO.setHasStock(hasStockMap.get(sku.getSkuId()));

            // 热度评分
            esSkuSaveDTO.setHotScore(0L);

            // 查询品牌信息
            PmsBrand pmsBrand = pmsBrandService.getById(sku.getBrandId());

            esSkuSaveDTO.setBrandId(sku.getBrandId());
            esSkuSaveDTO.setBrandName(pmsBrand.getName());
            esSkuSaveDTO.setBrandImg(pmsBrand.getLogo());

            // 查询分类信息
            PmsCategory pmsCategory = pmsCategoryService.getById(sku.getCategoryId());
            esSkuSaveDTO.setCategoryId(sku.getCategoryId());
            esSkuSaveDTO.setCategoryName(pmsCategory.getName());

            // 设置属性信息
            esSkuSaveDTO.setAttrs(esAttrs);
            return esSkuSaveDTO;
        }).collect(Collectors.toList());


        R<?> result = elasticSaveFeignService.saveEsSkuList(esSkuSaveDTOList);
        if (!result.getCode().equals(SystemResultCodeEnum.SUCCESS.getCode())) {
            System.out.println("远程调用失败");
            //TODO 7、重复调用？接口幂等性；重试机制？
        }

    }

    /**]
     * 下架
     *
     * @param spuId spuId
     */
    private void productDown(Long spuId) {

    }

}
