import request from '@/utils/request'

// 查询spu信息介绍列表
export function listDesc(query) {
  return request({
    url: '/product/desc/list',
    method: 'get',
    params: query
  })
}

// 查询spu信息介绍详细
export function getDesc(spuId) {
  return request({
    url: '/product/desc/' + spuId,
    method: 'get'
  })
}

// 新增spu信息介绍
export function addDesc(data) {
  return request({
    url: '/product/desc',
    method: 'post',
    data: data
  })
}

// 修改spu信息介绍
export function updateDesc(data) {
  return request({
    url: '/product/desc',
    method: 'put',
    data: data
  })
}

// 删除spu信息介绍
export function delDesc(spuId) {
  return request({
    url: '/product/desc/' + spuId,
    method: 'delete'
  })
}
