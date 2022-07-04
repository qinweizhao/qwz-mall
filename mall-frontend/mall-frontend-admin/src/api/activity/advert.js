import request from '@/utils/request'

// 查询首页轮播广告列表
export function listAdvert(query) {
  return request({
    url: '/activity/home/advert/list',
    method: 'get',
    params: query
  })
}

// 查询首页轮播广告详细
export function getAdvert(id) {
  return request({
    url: '/activity/home/advert/' + id,
    method: 'get'
  })
}

// 新增首页轮播广告
export function addAdvert(data) {
  return request({
    url: '/activity/home/advert',
    method: 'post',
    data: data
  })
}

// 修改首页轮播广告
export function updateAdvert(data) {
  return request({
    url: '/activity/home/advert',
    method: 'put',
    data: data
  })
}

// 删除首页轮播广告
export function delAdvert(id) {
  return request({
    url: '/activity/home/advert/' + id,
    method: 'delete'
  })
}
