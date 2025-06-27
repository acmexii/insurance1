<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '클레임접수' }" />
        <VerticalNavLink
            :item="{
                title: '클레임관리',
                to: '/claims',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '심사' }" />
        <VerticalNavLink
            :item="{
                title: '심사관리',
                to: '/reviews',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '고객센터' }" />
        <VerticalNavLink
            :item="{
                title: '모니터링',
                to: '/dashboards',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '블랙유저' }" />
        <VerticalNavLink
            :item="{
                title: '블랙컨슈머',
                to: '/블랙컨슈머',
            }"
        />
    </ul>
</template>
