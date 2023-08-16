import { createRouter, createWebHistory } from 'vue-router'
import IndexView from "@/views/IndexView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: IndexView
    },
    {
      path: '/posts',
      name: 'blog',
      component: () => import('../views/BlogView.vue')
    },
    {
      path: '/posts/:id',
      name: 'show-post',
      component: () => import('../views/ShowPostView.vue')
    },
  ]
})

export default router
