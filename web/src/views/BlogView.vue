<script setup>

import {ref, watchEffect} from "vue";
import axios from "axios";

const posts = ref([]);

watchEffect( async () => {
  const res = await axios.get("http://localhost:8080/api/posts");
  posts.value = res.data;
});
console.log(posts)
</script>

<template>
  <main class="py-5">
    <section id="blog" class="blog-mf sect-pt4 route">
    <div class="container">
      <div class="row">

        <div class="col-md-4 py-3" v-for="post in posts" :key="post.id">

          <div class="card card-blog">
            <div class="card-body">
              <h3 class="card-title">
                <a href="/posts/{{post.id.get()}}">
                  {{ post.title }}
                </a>
              </h3>
            </div>
            <div class="card-footer">
              <div class="post-author">
                <a href="#">
                  <span class="author">Saydum Khalibekov</span>
                </a>
              </div>
              <div class="post-date">
                <span class="bi bi-clock"></span> 20.02.12
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  </main>
</template>