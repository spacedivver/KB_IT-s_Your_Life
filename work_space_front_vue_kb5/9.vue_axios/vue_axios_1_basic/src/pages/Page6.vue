<template>
    <div>
        <h2>axios - async-await post 예제</h2>
        <button @click="requestAPI">요청</button><br>
        <div> 응답 : <span v-html="result"></span></div>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from 'vue';
const result = ref('');

const requestAPI = async () => {
  const url = "/api/todolist_long/gdhong";
  let data = { todo: "윗몸일으키기 3세트", desc: "너무 빠르지 않게..." };
  const resp1 = await axios.post(url, data);
  console.log(resp1.data);
  result.value = JSON.stringify(resp1.data);
};
</script>