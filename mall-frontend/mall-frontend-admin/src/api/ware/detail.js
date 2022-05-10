import request from '@/utils/request'

// 查询采购单详情列表
export function listDetail(query) {
  return request({
    url: '/product/detail/list',
    method: 'get',
    params: query
  })
}

// 查询采购单详情详细
export function getDetail(id) {
  return request({
    url: '/product/detail/' + id,
    method: 'get'
  })
}

// 新增采购单详情
export function addDetail(data) {
  return request({
    url: '/product/detail',
    method: 'post',
    data: data
  })
}

// 修改采购单详情
export function updateDetail(data) {
  return request({
    url: '/product/detail',
    method: 'put',
    data: data
  })
}

// 删除采购单详情
export function delDetail(id) {
  return request({
    url: '/product/detail/' + id,
    method: 'delete'
  })
}
