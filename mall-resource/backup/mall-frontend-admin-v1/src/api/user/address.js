import request from '@/utils/request'

// 查询会员收货地址列表
export function listAddress(query) {
  return request({
    url: '/product/address/list',
    method: 'get',
    params: query
  })
}

// 查询会员收货地址详细
export function getAddress(id) {
  return request({
    url: '/product/address/' + id,
    method: 'get'
  })
}

// 新增会员收货地址
export function addAddress(data) {
  return request({
    url: '/product/address',
    method: 'post',
    data: data
  })
}

// 修改会员收货地址
export function updateAddress(data) {
  return request({
    url: '/product/address',
    method: 'put',
    data: data
  })
}

// 删除会员收货地址
export function delAddress(id) {
  return request({
    url: '/product/address/' + id,
    method: 'delete'
  })
}
