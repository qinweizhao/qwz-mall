package com.qinweizhao.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.pojo.entity.SysDept;
import com.qinweizhao.system.pojo.form.DeptForm;
import com.qinweizhao.system.pojo.query.DeptQuery;
import com.qinweizhao.system.pojo.vo.dept.DeptDetailVO;
import com.qinweizhao.system.pojo.vo.dept.DeptVO;
import com.qinweizhao.system.pojo.Option;

import java.util.List;

/**
 * 部门业务接口
 *
 * @author haoxr
 * @date 2021/8/22
 */
public interface SysDeptService extends IService<SysDept> {
    /**
     * 部门列表
     *
     * @return
     */
    List<DeptVO> listDepts(DeptQuery queryParams);

    /**
     * 部门树形下拉选项
     *
     * @return
     */
    List<Option> listDeptOptions();

    /**
     * 新增部门
     *
     * @param formData
     * @return
     */
    Long saveDept(DeptForm formData);

    /**
     * 修改部门
     *
     * @param deptId
     * @param formData
     * @return
     */
    Long updateDept(Long deptId, DeptForm formData);

    /**
     * 删除部门
     *
     * @param ids 部门ID，多个以英文逗号,拼接字符串
     * @return
     */
    boolean deleteByIds(String ids);

    /**
     * 获取部门详情
     *
     * @param deptId
     * @return
     */
    DeptDetailVO getDeptDetail(Long deptId);
}
