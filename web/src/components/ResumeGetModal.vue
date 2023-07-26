<script setup>

</script>

<template>
  <div class="modal fade" id="resumeGetModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content text-center">
        <div class="modal-header">
          <h3 class="modal-title" id="exampleModalLabel">Download resume</h3>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <!--@TODO(Нужно добавить ссылки на резюме)-->
          <div class="post-date">
            <a href="">
              <span class="bi bi-filetype-java"></span> Java developer
            </a>
          </div>

          <div class="post-date">
            <a href="">
              <span class="bi bi-filetype-php"></span> Php developer

            </a>
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.post-date {
  font-size: 21px;
}
.post-date span {
  font-size: 32px;
}
</style>