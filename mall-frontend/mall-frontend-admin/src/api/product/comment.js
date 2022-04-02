import request from '@/utils/request'

// 查询商品评价列表
export function listComment(query) {
  return request({
    url: '/product/comment/list',
    method: 'get',
    params: query
  })
}

// 查询商品评价详细
export function getComment(id) {
  return request({
    url: '/product/comment/' + id,
    method: 'get'
  })
}

// 新增商品评价
export function addComment(data) {
  return request({
    url: '/product/comment',
    method: 'post',
    data: data
  })
}

// 修改商品评价
export function updateComment(data) {
  return request({
    url: '/product/comment',
    method: 'put',
    data: data
  })
}

// 删除商品评价
export function delComment(id) {
  return request({
    url: '/product/comment/' + id,
    method: 'delete'
  })
}
