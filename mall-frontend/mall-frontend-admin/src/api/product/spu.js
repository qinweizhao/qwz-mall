import request from '@/utils/request'

// 查询spu信息列表
export function pageInfo(query) {
  return request({
    url: '/product/spu/info/page',
    method: 'get',
    params: query
  })
}

// 查询spu信息详细
export function getInfo(spuId) {
  return request({
    url: '/product/spu/info/' + spuId,
    method: 'get'
  })
}

// 新增spu信息
export function addInfo(data) {
  return request({
    url: '/product/spu/info',
    method: 'post',
    data: data
  })
}

// 修改spu信息
export function updateInfo(data) {
  return request({
    url: '/product/spu/info',
    method: 'put',
    data: data
  })
}

// 删除spu信息
export function delInfo(spuId) {
  return request({
    url: '/product/spu/info/' + spuId,
    method: 'delete'
  })
}
