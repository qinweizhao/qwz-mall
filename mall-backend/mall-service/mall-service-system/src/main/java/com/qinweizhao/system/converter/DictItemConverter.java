package com.qinweizhao.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.pojo.entity.SysDictItem;
import com.qinweizhao.system.pojo.form.DictItemForm;
import com.qinweizhao.system.pojo.vo.dict.DictItemPageVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * 字典数据项对象转换器
 *
 * @author haoxr
 * @date 2022/6/8
 */
@Mapper(componentModel = "spring")
public interface DictItemConverter {

    Page<DictItemPageVO> entity2Page(Page<SysDictItem> page);

    DictItemForm entity2Form(SysDictItem entity);

    @InheritInverseConfiguration(name = "entity2Form")
    SysDictItem form2Entity(DictItemForm entity);
}
