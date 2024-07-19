<template>
    <footer class="footer">
        Copyright © 2022 - {{ year }} All rights reserved. Provided by&nbsp;<a class="quanxiaoha" href="https://www.lingcq.online" target="_blank">leone</a>
        <a class="quanxiaoha" href="https://beian.miit.gov.cn/" target="_blank">&nbsp;粤ICP备19038581号</a>
    </footer>
</template>

<script>
export default {
  data() {
    return {
      year: new Date().getFullYear().toString()
    };
  },
  mounted() {
    console.log('year:', this.year);
  }
};
</script>

<style scoped>
.footer {
    @apply text-gray-500 text-sm justify-center flex;
    padding-top: 1.5rem;
    padding-bottom: 1.5rem;
    background-color: #fff;
    margin-top: 5rem;
}

.quanxiaoha {
    text-decoration: underline;
    color: rgb(52, 152, 219);
}
</style>