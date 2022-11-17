import request from '@/utils/request'

// 查询商品属性列表
export function pageAttr(query) {
  return request({
    url: '/product/attr/page',
    method: 'get',
    params: query
  })
}

// 查询商品属性详细
export function getAttr(attrId) {
  return request({
    url: '/product/attr/' + attrId,
    method: 'get'
  })
}

// 新增商品属性
export function addAttr(data) {
  return request({
    url: '/product/attr',
    method: 'post',
    data: data
  })
}

// 修改商品属性
export function updateAttr(data) {
  return request({
    url: '/product/attr',
    method: 'put',
    data: data
  })
}

// 删除商品属性
export function delAttr(attrId) {
  return request({
    url: '/product/attr/' + attrId,
    method: 'delete'
  })
}
