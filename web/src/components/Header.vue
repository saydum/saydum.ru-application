<script setup>
import {RouterLink, useRoute} from "vue-router";
import {computed} from "vue";

const route = useRoute();
const path = computed(() => route.path);

</script>

<template>
  <header id="header" class="fixed-top" v-bind:style="path === '/' ? '' : 'background-color: #2b3035'">

    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo">
        <RouterLink to="/">
          saydum.ru
        </RouterLink>
      </h1>

      <nav id="navbar" class="navbar">
        <ul class="text-end">
          <li>
            <RouterLink class="nav-link scrollto"
               to="/">
              Home
            </RouterLink>
          </li>

          <li>
            <RouterLink class="nav-link scrollto "
               to="/posts">
              Blog
            </RouterLink>
          </li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav>
    </div>
  </header>
</template>
