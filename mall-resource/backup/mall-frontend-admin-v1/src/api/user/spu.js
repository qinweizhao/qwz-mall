import request from '@/utils/request'

// 查询会员收藏的商品列表
export function listSpu(query) {
  return request({
    url: '/product/spu/list',
    method: 'get',
    params: query
  })
}

// 查询会员收藏的商品详细
export function getSpu(id) {
  return request({
    url: '/product/spu/' + id,
    method: 'get'
  })
}

// 新增会员收藏的商品
export function addSpu(data) {
  return request({
    url: '/product/spu',
    method: 'post',
    data: data
  })
}

// 修改会员收藏的商品
export function updateSpu(data) {
  return request({
    url: '/product/spu',
    method: 'put',
    data: data
  })
}

// 删除会员收藏的商品
export function delSpu(id) {
  return request({
    url: '/product/spu/' + id,
    method: 'delete'
  })
}
