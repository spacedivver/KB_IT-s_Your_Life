<template>
    <div>
        <h2>axios - promise-then time-out 예제</h2>
        <div v-html="result"></div>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from 'vue';
const result = ref('');

const requestAPI = async () => {
  const url = "/api/todolist_long/gdhong";
  axios
    .get(url, { timeout: 900 })
    .then((response) => {
      result.value = '# 응답객체' + JSON.stringify(response);
      console.log("# 응답객체 : ", response);
    })
    .catch((e) => {
      alert('오류 발생!');
      result.value = '# 에러!!' + JSON.stringify(e);
      if (e instanceof Error) console.log(e.message);
      else console.log(e);
    });
};

requestAPI();
</script>