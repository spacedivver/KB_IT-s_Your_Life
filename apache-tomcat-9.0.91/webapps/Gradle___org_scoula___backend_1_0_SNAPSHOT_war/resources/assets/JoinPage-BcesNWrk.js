import{a as _,c as d,r as h,o as w,e as y,f as s,h as t,n as g,t as k,w as n,v as i,i as x}from"./index-LlOPXo_Y.js";import{a as m}from"./authApi-COc5JUlv.js";import"./index-BR7kDNON.js";const D={class:"mt-5 mx-auto",style:{width:"500px"}},I=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-user-plus"}),t(" 회원 가입 ")],-1),U={class:"mb-3 mt-3"},V={for:"username",class:"form-label"},B=s("i",{class:"fa-solid fa-user"},null,-1),E=s("label",{for:"avatar",class:"form-label"},[s("i",{class:"fa-solid fa-user-astronaut"}),t(" 아바타 이미지: ")],-1),S={class:"mb-3 mt-3"},j=s("label",{for:"email",class:"form-label"},[s("i",{class:"fa-solid fa-envelope"}),t(" email ")],-1),C={class:"mb-3"},M=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호: ")],-1),N={class:"mb-3"},T=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호 확인: ")],-1),z=["disabled"],A=s("i",{class:"fa-solid fa-user-plus"},null,-1),F={__name:"JoinPage",setup(J){const p=_(),c=d(null),r=d(""),a=h({username:"hong",email:"hong@gmail.com",password:"12",password2:"12",avatar:null}),l=d(!0),f=async()=>{if(!a.username)return alert("사용자 ID를 입력하세요.");l.value=await m.checkUsername(a.username),console.log(l.value,typeof l.value),r.value=l.value?"이미 사용중인 ID입니다.":"사용가능한 ID입니다."},v=()=>{l.value=!0,a.username?r.value="ID 중복 체크를 하셔야 합니다.":r.value=""},b=async()=>{if(a.password!=a.password2)return alert("비밀번호가 일치하지 않습니다.");c.value.files.length>0&&(a.avatar=c.value.files[0]);try{await m.create(a),p.push({name:"home"})}catch(u){console.error(u)}};return(u,e)=>(w(),y("div",D,[I,s("form",{onSubmit:x(b,["prevent"])},[s("div",U,[s("label",V,[B,t(" 사용자 ID : "),s("button",{type:"button",class:"btn btn-success btn-sm py-0 me-2",onClick:f},"ID 중복 확인"),s("span",{class:g(l.value.value?"text-primary":"text-danger")},k(r.value),3)]),n(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID",id:"username",onInput:v,"onUpdate:modelValue":e[0]||(e[0]=o=>a.username=o)},null,544),[[i,a.username]])]),s("div",null,[E,s("input",{type:"file",class:"form-control",ref_key:"avatar",ref:c,id:"avatar",accept:"image/png, image/jpeg"},null,512)]),s("div",S,[j,n(s("input",{type:"email",class:"form-control",placeholder:"Email",id:"email","onUpdate:modelValue":e[1]||(e[1]=o=>a.email=o)},null,512),[[i,a.email]])]),s("div",C,[M,n(s("input",{type:"password",class:"form-control",placeholder:"비밀번호",id:"password","onUpdate:modelValue":e[2]||(e[2]=o=>a.password=o)},null,512),[[i,a.password]])]),s("div",N,[T,n(s("input",{type:"password",class:"form-control",placeholder:"비밀번호 확인",id:"password2","onUpdate:modelValue":e[3]||(e[3]=o=>a.password2=o)},null,512),[[i,a.password2]])]),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:l.value},[A,t(" 확인 ")],8,z)],32)]))}};export{F as default};