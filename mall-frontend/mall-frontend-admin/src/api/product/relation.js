import request from '@/utils/request'

// 查询属性&属性分组关联列表
export function listRelation(query) {
  return request({
    url: '/product/relation/list',
    method: 'get',
    params: query
  })
}

// 查询属性&属性分组关联详细
export function getRelation(id) {
  return request({
    url: '/product/relation/' + id,
    method: 'get'
  })
}

// 新增属性&属性分组关联
export function addRelation(data) {
  return request({
    url: '/product/relation',
    method: 'post',
    data: data
  })
}

// 修改属性&属性分组关联
export function updateRelation(data) {
  return request({
    url: '/product/relation',
    method: 'put',
    data: data
  })
}

// 删除属性&属性分组关联
export function delRelation(id) {
  return request({
    url: '/product/relation/' + id,
    method: 'delete'
  })
}
