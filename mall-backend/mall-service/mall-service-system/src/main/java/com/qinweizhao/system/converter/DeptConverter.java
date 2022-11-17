package com.qinweizhao.system.converter;

import com.qinweizhao.system.pojo.entity.SysDept;
import com.qinweizhao.system.pojo.form.DeptForm;
import com.qinweizhao.system.pojo.vo.dept.DeptDetailVO;
import com.qinweizhao.system.pojo.vo.dept.DeptVO;
import org.mapstruct.Mapper;

/**
 * 部门对象转换器
 *
 * @author haoxr
 * @date 2022/7/29
 */
@Mapper(componentModel = "spring")
public interface DeptConverter {

    DeptVO entity2Vo(SysDept entity);

    DeptDetailVO entity2DetailVO(SysDept entity);

    SysDept form2Entity(DeptForm deptForm);

}