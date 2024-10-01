<template>
    <div>
        <h2>axios - async-await 버전2</h2>
        <div v-html="result"></div>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from 'vue';
const result = ref('');

const requestAPI = async () => {
  const url = "/api/todolist/gdhong";
  const response = await axios.get(url);
  result.value = "# 응답객체 : " + JSON.stringify(response); 
  console.log("# 응답객체 : ", response);
};

requestAPI();
</script>