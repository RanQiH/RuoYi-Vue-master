import request from '@/utils/request'

// 查询agreement列表
export function listAgreement(query) {
  return request({
    url: '/connection/agreement/list',
    method: 'get',
    params: query
  })
}

// 查询agreement详细
export function getAgreement(id) {
  return request({
    url: '/connection/agreement/' + id,
    method: 'get'
  })
}

// 新增agreement
export function addAgreement(data) {
  return request({
    url: '/connection/agreement',
    method: 'post',
    data: data
  })
}

// 修改agreement
export function updateAgreement(data) {
  return request({
    url: '/connection/agreement',
    method: 'put',
    data: data
  })
}

// 删除agreement
export function delAgreement(id) {
  return request({
    url: '/connection/agreement/' + id,
    method: 'delete'
  })
}
