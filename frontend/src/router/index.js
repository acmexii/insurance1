import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/claims',
      component: () => import('../components/ui/ClaimGrid.vue'),
    },
    {
      path: '/reviews',
      component: () => import('../components/ui/ReviewGrid.vue'),
    },
    {
      path: '/dashboards',
      component: () => import('../components/DashboardView.vue'),
    },
    {
      path: '/블랙컨슈머',
      component: () => import('../components/ui/블랙컨슈머Grid.vue'),
    },
  ],
})

export default router;
