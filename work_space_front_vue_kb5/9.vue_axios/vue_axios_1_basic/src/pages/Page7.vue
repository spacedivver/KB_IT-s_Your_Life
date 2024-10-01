<template>
    <div>
        <h2>axios - async-await time out 예제</h2>
        <div v-html="result"></div>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from 'vue';
const result = ref('');

const requestAPI = async () => {
  const url = "/api/todolist_long/gdhong";
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log("# 응답객체 : ", response);
    result.value = '# 응답객체' + JSON.stringify(response);
  } catch (e) {
    console.log("## 다음 오류가 발생했습니다.");
    alert('오류 발생!');
    result.value = '에러!!' + JSON.stringify(e);
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

requestAPI();
</script>