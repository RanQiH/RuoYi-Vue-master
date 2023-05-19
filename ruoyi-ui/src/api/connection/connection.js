import request from '@/utils/request'

// 查询connection列表
export function listConnection(query) {
  return request({
    url: '/connection/connection/list',
    method: 'get',
    params: query
  })
}

export function listSalemans() {
  return request({
    url: '/connection/connection/findSalemans',
    method: 'get',
  })
}
// 查询connection详细
export function getConnection(id) {
  return request({
    url: '/connection/connection/' + id,
    method: 'get'
  })
}

// 新增connection
export function addConnection(data) {
  return request({
    url: '/connection/connection',
    method: 'post',
    data: data
  })
}

// 修改connection
export function updateConnection(data) {
  return request({
    url: '/connection/connection',
    method: 'put',
    data: data
  })
}

// 删除connection
export function delConnection(id) {
  return request({
    url: '/connection/connection/' + id,
    method: 'delete'
  })
}
