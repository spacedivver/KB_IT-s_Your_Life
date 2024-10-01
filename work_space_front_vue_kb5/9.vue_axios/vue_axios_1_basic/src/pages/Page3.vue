<template>
  <div>
    <h2>axios - promise version(todosvc-master 서버 필요!)</h2>
    <div v-html="result"></div>
  </div>
</template>

<script setup>
import axios from 'axios'
import { ref } from 'vue';

const listUrl = "/api/todolist_long/gdhong";
const todoUrlPrefix = "/api/todolist_long/gdhong/";
const result = ref('');

//4건의 목록을 조회한 후 첫번째, 두번째 할일을 순차적으로 조회합니다.
const requestAPI = () => {
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log("# TodoList : ", todoList);
      result.value = '# TodoList : ' + JSON.stringify(todoList)+ '<br><br>';
      return todoList[0].id;
    })
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      result.value += '## 첫번째 Todo : ' + JSON.stringify(response.data) + '<br>';
      console.log("## 첫번째 Todo : ", response.data);
      return todoList[1].id;
    })
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        result.value += '## 두번째 Todo : ' + JSON.stringify(response.data) + '<br>';
        console.log("## 두번째 Todo : ", response.data);
      });
    });
};

requestAPI();
</script>