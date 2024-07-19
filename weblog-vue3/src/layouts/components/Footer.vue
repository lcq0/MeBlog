<template>
    <footer
        class="mt-60px bottom-0 left-0 z-20 w-full p-2 bg-white border-t border-b border-gray-200 dark:bg-gray-800 dark:border-gray-600">
        <div class="max-w-screen-xl mx-auto md:flex md:items-center md:justify-between p-4">
            <span class="text-sm text-gray-500 sm:text-center dark:text-gray-400">Copyright © 2022 - {{ year }} <a
                    href="https://github.com/lcq0/MeBlog" target="_blank" class="hover:underline">Weblog™</a>. All
                Rights Reserved.
                <a class="quanxiaoha" href="https://beian.miit.gov.cn/" target="_blank">&nbsp;桂ICP备2024035335号</a>
            </span>
            <ul class="flex flex-wrap items-center mt-3 text-sm font-medium text-gray-500 dark:text-gray-400 sm:mt-0">
                Provided by&nbsp;
                <li>
                    <a href="https://github.com/lcq0/MeBlog" target="_blank" class="mr-4 hover:underline md:mr-6">
                        leone</a>
                </li>
            </ul>
        </div>

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