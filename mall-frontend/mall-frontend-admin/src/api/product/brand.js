import request from '@/utils/request'

// 分页
export function pageBrand(query) {
  return request({
    url: '/product/brand/page',
    method: 'get',
    params: query
  })
}

// 详细
export function getBrand(brandId) {
  return request({
    url: '/product/brand/' + brandId,
    method: 'get'
  })
}

// 新增
export function addBrand(data) {
  return request({
    url: '/product/brand',
    method: 'post',
    data: data
  })
}

// 修改
export function updateBrand(data) {
  return request({
    url: '/product/brand',
    method: 'put',
    data: data
  })
}

// 删除
export function delBrand(brandId) {
  return request({
    url: '/product/brand/' + brandId,
    method: 'delete'
  })
}
