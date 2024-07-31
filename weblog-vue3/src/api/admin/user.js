import axios from "@/axios"

export function login(username, password) {
    return axios.post("/admin/login", {username, password})
}

export function getAdminInfo() {
    return axios.post("/admin/detail")
}

export function updateAdminPassword(data) {
    return axios.post("/admin/password/update", data)
}

export function logout() {
    return axios.post("/admin/logout")
}