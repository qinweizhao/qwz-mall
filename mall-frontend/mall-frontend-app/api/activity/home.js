
import request from '@/utils/request'

export function getAdvertList() {
  return request({
    url: '/activity/app/adverts',
    method: 'get'
  })
}
