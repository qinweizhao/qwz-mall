import request from '@/utils/request'

// 品牌和分类
// 查询与分类的关联信息
export function getRelation(param) {
  return request({
    url: '/product/brand/category/list',
    method: 'get',
    params: param
  })
}
