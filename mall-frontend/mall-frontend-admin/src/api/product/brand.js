import request from '@/utils/request'

// 查询品牌列表
export function listBrand(query) {
  return request({
    url: '/product/brand/list',
    method: 'get',
    params: query
  })
}

// 查询品牌详细
export function getBrand(brandId) {
  return request({
    url: '/product/brand/' + brandId,
    method: 'get'
  })
}

// 新增品牌
export function addBrand(data) {
  return request({
    url: '/product/brand',
    method: 'post',
    data: data
  })
}

// 修改品牌
export function updateBrand(data) {
  return request({
    url: '/product/brand',
    method: 'put',
    data: data
  })
}

// 删除品牌
export function delBrand(brandId) {
  return request({
    url: '/product/brand/' + brandId,
    method: 'delete'
  })
}

// 品牌和分类
// 查询与分类的关联信息
export function getRelation(brandId) {
  return request({
    url: '/product/brand/category/' + brandId,
    method: 'get'
  })
}

// 新增品牌
export function addRelation(data) {
  return request({
    url: '/product/brand/category',
    method: 'post',
    data: data
  })
}

// 删除关联
export function delRelation(brandId) {
  return request({
    url: '/product/brand/category/' + brandId,
    method: 'delete'
  })
}
