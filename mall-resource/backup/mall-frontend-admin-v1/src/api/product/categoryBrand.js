import request from '@/utils/request'

// 品牌和分类
// 查询
export function getRelation(param) {
  return request({
    url: '/product/category/brand/list',
    method: 'get',
    params: param
  })
}

// 新增
export function addRelation(data) {
  return request({
    url: '/product/category/brand',
    method: 'post',
    data: data
  })
}

// 删除
export function delRelation(brandId) {
  return request({
    url: '/product/category/brand/' + brandId,
    method: 'delete'
  })
}
