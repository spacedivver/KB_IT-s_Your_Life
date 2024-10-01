<template>
    <div>
        <h2>News API + page 예제</h2>
        page : <input type="text" v-model="page">
        <button @click="getNews">요청</button><br><br>
        <div v-if="newsList == null || newsList.length == 0">
            리스트가 없습니다.
        </div>
        <div v-else>
            <div v-for="item in newsList" :key="item.url">
                title : <b>{{item.title}}</b><br>
                description : {{item.description}}<br>
                url : <a :href="item.url">{{item.url}}</a><br>
                urlToImage<br>
                <img :src="item.urlToImage" width="500" ><br>
                publishedAt : {{ Date(item.publishedAt) }}<br>
                <hr><br>
            </div>
        </div>
    </div>
</template>

<script setup>
import axios from 'axios'
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router'

// 뉴스 api : https://newsapi.org/docs/endpoints/top-headlines
const newsURL = 'https://newsapi.org/v2/top-headlines?country=kr&pageSize=10&apiKey=0a8c4202385d4ec1bb93b7e277b3c51f';

// http://localhost:5173/Page2?page=2
// 페이징 전처리 코드
const route = useRoute();
const router = useRouter();
console.log(route.query); // page=2

// url query로 부터 page 정보를 초기화 하는 방법
const page = ref(route.query.page ? Number(route.query.page) : 1);
const newsList = ref([]);

const getNews = async (e) => {
    try {
        // page update 코드
        // url query 업데이트하는 코드
        router.replace({path:route.path, query:{page:page.value}});

        const requestURL = newsURL + '&page=' + page.value;
        const response = await axios.get(requestURL);
        console.log('response');
        console.log(response);
        console.log('response.data');
        console.log(response.data);

        if(response.status != 200 
            || !response.data.articles || response.data.articles.length == 0 ){
            alert('잘못된 요청입니다.');
            newsList.value = [];
            return;
        }
        newsList.value = response.data.articles;
    } catch (error) {
        alert('에러 발생!');
        console.error(error);
    }
}
getNews();

</script>