import request from '@/utils/request'

// 查询属性分组列表
export function listAttrGroup(query) {
  return request({
    url: '/product/attr-group/page',
    method: 'get',
    params: query
  })
}

// 查询属性分组详细
export function getGroup(attrGroupId) {
  return request({
    url: '/product/attr-group/' + attrGroupId,
    method: 'get'
  })
}

// 新增属性分组
export function addGroup(data) {
  return request({
    url: '/product/attr-group',
    method: 'post',
    data: data
  })
}

// 修改属性分组
export function updateGroup(data) {
  return request({
    url: '/product/attr-group',
    method: 'put',
    data: data
  })
}

// 删除属性分组
export function delGroup(attrGroupId) {
  return request({
    url: '/product/attr-group/' + attrGroupId,
    method: 'delete'
  })
}

// 通过分类 id 获取分属性组和组中属性
export function getAttrGroupWithAttrs(categoryId) {
  return request({
    url: `/product/attr-group/${categoryId}/attr`,
    method: 'get',
  })
}
