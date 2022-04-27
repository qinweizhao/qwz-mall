import request from '@/utils/request'

// 查询属性分组列表
export function listGroup(query) {
  return request({
    url: '/product/attr-group/list',
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

// 属性和属性分组
// 查询与分类的关联信息
export function getRelation(query) {
  return request({
    url: '/product/attr/attr-group/list',
    method: 'get',
    params: query
  })
}

// 查询角色未授权用户列表
export function unRelation(query) {
  return request({
    url: '/product/attr/attr-group/un-relation',
    method: 'get',
    params: query
  })
}

// 新增品牌
export function addRelation(data) {
  return request({
    url: '/product/brand/category',
    method: 'post',
    data: data
  })
}

// 删除关联
export function delRelation(brandId) {
  return request({
    url: '/product/brand/category/' + brandId,
    method: 'delete'
  })
}
