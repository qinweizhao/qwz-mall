package com.qinweizhao.product.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.product.mapper.PmsAttrMapper;
import com.qinweizhao.product.model.dto.SkuDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.service.PmsSkuService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * sku信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSkuServiceImpl extends QwzServiceImpl<PmsAttrMapper, PmsAttr> implements PmsSkuService {

//
//    @Resource
//    private PmsSkuMapper pmsSkuMapper;
//
//    @Resource
//    private IPmsAttrGroupService pmsAttrGroupService;
//
//    @Resource
//    private PmsSpuInfoDetailMapper pmsSpuInfoDetailMapper;
//
//    @Resource
//    private PmsSkuAttrValueService pmsSkuAttrValueService;
//
//    @Resource
//    private PmsSkuImageMapper pmsSkuImageMapper;
//
//    @Resource
//    private ThreadPoolExecutor executor;
//
//    /**
//     * 查询sku信息
//     *
//     * @param skuId sku信息主键
//     * @return sku信息
//     */
//    @Override
//    public PmsSku getById(Long skuId) {
//        return pmsSkuMapper.selectById(skuId);
//    }
//
//    /**
//     * 查询sku信息列表
//     *
//     * @param PmsSku sku信息
//     * @return sku信息
//     */
//    @Override
//    public List<PmsSku> list(PmsSku PmsSku) {
//        return pmsSkuMapper.selectPmsSkuList(PmsSku);
//    }
//
//    /**
//     * 新增sku信息
//     *
//     * @param PmsSku sku信息
//     * @return 结果
//     */
//    @Override
//    public int save(PmsSku PmsSku) {
//        PmsSku.setCreateTime(LocalDateTime.now());
//        return pmsSkuMapper.insertPmsSku(PmsSku);
//    }
//
//    /**
//     * 修改sku信息
//     *
//     * @param PmsSku sku信息
//     * @return 结果
//     */
//    @Override
//    public int updateById(PmsSku PmsSku) {
//        PmsSku.setUpdateTime(LocalDateTime.now());
//        return pmsSkuMapper.updatePmsSku(PmsSku);
//    }
//
//    /**
//     * 批量删除sku信息
//     *
//     * @param skuIds 需要删除的sku信息主键
//     * @return 结果
//     */
//    @Override
//    public int removeByIds(Long[] skuIds) {
//        return pmsSkuMapper.deletePmsSkuBySkuIds(skuIds);
//    }
//
//    /**
//     * 删除sku信息信息
//     *
//     * @param skuId sku信息主键
//     * @return 结果
//     */
//    @Override
//    public int removeById(Long skuId) {
//        return pmsSkuMapper.deletePmsSkuBySkuId(skuId);
//    }
//
//    @Override
//    public List<PmsSku> listBySpuId(Long spuId) {
//        return pmsSkuMapper.selectListBySpuId(spuId);
//    }

//    @Override
    public SkuDTO getItemById(Long skuId) throws ExecutionException, InterruptedException {
//        SkuItemVO skuItem = new SkuItemVO();
//
//
//        CompletableFuture<PmsSku> infoFuture = CompletableFuture.supplyAsync(() -> {
//            // 1.sku 基本信息获取
//            PmsSku PmsSku = pmsSkuMapper.selectById(skuId);
//            SkuInfoDTO infoDTO = SkuConvert.INSTANCE.convert(PmsSku);
//            infoDTO.setStock(1000L);
//            skuItem.setSkuInfo(infoDTO);
//            return PmsSku;
//        }, executor);
//
//
//        CompletableFuture<Void> imageFuture = CompletableFuture.runAsync(() -> {
//                    // 2.sku 图片信息
//                    PmsSkuImage pmsSkuImage = new PmsSkuImage();
//                    pmsSkuImage.setSkuId(skuId);
//                    List<PmsSkuImage> imageList = pmsSkuImageMapper.selectPmsSkuImageList(pmsSkuImage);
//                    skuItem.setSkuImages(SkuImageConvert.INSTANCE.convertToDTO(imageList));
//                }
//                , executor);
//
//        CompletableFuture<Void> saleAttrFuture = infoFuture.thenAcceptAsync(response -> {
//            Long spuId = response.getSpuId();
//            // 3.获取spu的销售组合
//            List<SkuItemAttrDTO> saleAttrList = pmsSkuAttrValueService.listSkuItemAttrBySpuId(spuId);
//            skuItem.setSaleAttr(saleAttrList);
//        }, executor);
//
//        CompletableFuture<Void> descFuture =  infoFuture.thenAcceptAsync(response -> {
//            // 4.获取 spu 详情（介绍）
//            Long spuId = response.getSpuId();
//            PmsSpuInfoDetail pmsSpuInfoDetail = pmsSpuInfoDetailMapper.selectPmsSpuInfoDetailBySpuId(spuId);
//            skuItem.setSpuInfoDetail(SpuConvert.INSTANCE.convert(pmsSpuInfoDetail));
//        }, executor);
//
//        CompletableFuture<Void> baseAttrFuture = infoFuture.thenAcceptAsync(response -> {
//            // 5.获取spu的规格参数信息
//            Long spuId = response.getSpuId();
//            Long categoryId = response.getCategoryId();
//            List<AttrGroupWithAttrsDTO> spuItemAttrGroupDTOList = pmsAttrGroupService.listAttrGroupWithAttrsByCategoryId(categoryId, spuId);
//            skuItem.setGroupAttrs(spuItemAttrGroupDTOList);
//
//        }, executor);
//
//        CompletableFuture.allOf(saleAttrFuture,descFuture,baseAttrFuture,imageFuture).get();

        return null;
    }
}
