<script setup lang="ts">
import { Typed } from "@duskmoon/vue3-typed-js";
import type { TypedOptions } from "@duskmoon/vue3-typed-js";
import ResumeGetModal from "../components/ResumeGetModal.vue";

const options: TypedOptions = {
  strings: ["Привет!", "Меня зовут Сайдум.", "Я Backend разработчик."],
  loop: true,
  typeSpeed: 120,
};
</script>

<template>
    <div id="hero" class="hero route bg-image">
      <div class="overlay-itro"></div>
      <div class="hero-content display-table">
        <div class="table-cell">
          <div class="container">
            <p class="hero-subtitle">
              <Typed :options="options">
                <span class="typing">
                </span>
              </Typed>
              <span id="element"></span>
            </p>
            <div class="mb-4">

              <ul class="nav justify-content-center">

                <li class="nav-item">
                  <a href="https://github.com/saydum/" class="nav-link" target="_blank">
                    <i class="bi bi-github"></i>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="https://t.me/saydum47" class="nav-link" target="_blank">
                    <i class="bi bi-telegram"></i>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="https://www.youtube.com/channel/UCGgou2mPkfTyv9SULB2nckg" class="nav-link" target="_blank">
                    <i class="bi bi-youtube"></i>
                  </a>
                </li>

                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="bi bi-instagram"></i>
                  </a>
                </li>

              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  <ResumeGetModal />
</template>

<style scoped>
  i {
    font-size: 38px;
    color: white;
  }
  i:hover {
    color: #198754;
  }
  #hero {
    background: url('../assets/img/bg.jpg') no-repeat center;
  }
</style>
