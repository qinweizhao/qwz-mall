import request from '@/utils/request'

export function page(pageParam) {
  return request({
    url: '/mall_order/m/order/refund/page',
    method: 'get',
    params: pageParam
  })
}
