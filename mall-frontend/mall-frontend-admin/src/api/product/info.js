import request from '@/utils/request'


// 新增sku信息
export function addInfo(data) {
  return request({
    url: '/product/spu/info',
    method: 'post',
    data: data
  })
}


// todo
// 查询sku信息列表
export function listInfo(query) {
  return request({
    url: '/product/info/list',
    method: 'get',
    params: query
  })
}

// 查询sku信息详细
export function getInfo(skuId) {
  return request({
    url: '/product/info/' + skuId,
    method: 'get'
  })
}


// 修改sku信息
export function updateInfo(data) {
  return request({
    url: '/product/info',
    method: 'put',
    data: data
  })
}

// 删除sku信息
export function delInfo(skuId) {
  return request({
    url: '/product/info/' + skuId,
    method: 'delete'
  })
}
