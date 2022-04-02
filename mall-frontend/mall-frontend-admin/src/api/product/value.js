import request from '@/utils/request'

// 查询spu属性值列表
export function listValue(query) {
  return request({
    url: '/product/value/list',
    method: 'get',
    params: query
  })
}

// 查询spu属性值详细
export function getValue(id) {
  return request({
    url: '/product/value/' + id,
    method: 'get'
  })
}

// 新增spu属性值
export function addValue(data) {
  return request({
    url: '/product/value',
    method: 'post',
    data: data
  })
}

// 修改spu属性值
export function updateValue(data) {
  return request({
    url: '/product/value',
    method: 'put',
    data: data
  })
}

// 删除spu属性值
export function delValue(id) {
  return request({
    url: '/product/value/' + id,
    method: 'delete'
  })
}
