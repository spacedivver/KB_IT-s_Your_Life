import{a as _,c,r as h,o as w,e as y,f as s,h as t,n as g,t as I,w as r,v as n,i as k}from"./index-BBZxee2U.js";import{a as p}from"./authApi-DzoaphQ1.js";import"./index-BL4nKI-C.js";const x={class:"mt-5 mx-auto",style:{width:"500px"}},D=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-user-plus"}),t(" 회원 가입 ")],-1),V={class:"mb-3 mt-3"},U={for:"id",class:"form-label"},B=s("i",{class:"fa-solid fa-user"},null,-1),E=s("label",{for:"avatar",class:"form-label"},[s("i",{class:"fa-solid fa-user-astronaut"}),t(" 아바타 이미지: ")],-1),S={class:"mb-3 mt-3"},j=s("label",{for:"email",class:"form-label"},[s("i",{class:"fa-solid fa-envelope"}),t(" email ")],-1),C={class:"mb-3"},M=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호: ")],-1),N={class:"mb-3"},T=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호 확인: ")],-1),z=["disabled"],A=s("i",{class:"fa-solid fa-user-plus"},null,-1),F={__name:"JoinPage",setup(J){const m=_(),d=c(null),i=c(""),a=h({id:"test",name:"홍길동",email:"hong@gmail.com",password:"1212",password2:"1212",avatar:null}),l=c(!0),f=async()=>{if(!a.id)return alert("사용자 ID를 입력하세요.");l.value=await p.checkId(a.id),console.log(l.value,typeof l.value),i.value=l.value?"이미 사용중인 ID입니다.":"사용가능한 ID입니다."},v=()=>{l.value=!0,a.id?i.value="ID 중복 체크를 하셔야 합니다.":i.value=""},b=async()=>{if(a.password!=a.password2)return alert("비밀번호가 일치하지 않습니다.");d.value.files.length>0&&(a.avatar=d.value.files[0]);try{await p.create(a),m.push({name:"home"})}catch(u){console.error(u)}};return(u,e)=>(w(),y("div",x,[D,s("form",{onSubmit:k(b,["prevent"])},[s("div",V,[s("label",U,[B,t(" 사용자 ID : "),s("button",{type:"button",class:"btn btn-success btn-sm py-0 me-2",onClick:f},"ID 중복 확인"),s("span",{class:g(l.value.value?"text-primary":"text-danger")},I(i.value),3)]),r(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID",id:"id",onInput:v,"onUpdate:modelValue":e[0]||(e[0]=o=>a.id=o)},null,544),[[n,a.id]])]),s("div",null,[E,s("input",{type:"file",class:"form-control",ref_key:"avatar",ref:d,id:"avatar",accept:"image/png, image/jpeg"},null,512)]),s("div",S,[j,r(s("input",{type:"email",class:"form-control",placeholder:"Email",id:"email","onUpdate:modelValue":e[1]||(e[1]=o=>a.email=o)},null,512),[[n,a.email]])]),s("div",C,[M,r(s("input",{type:"password",class:"form-control",placeholder:"비밀번호",id:"password","onUpdate:modelValue":e[2]||(e[2]=o=>a.password=o)},null,512),[[n,a.password]])]),s("div",N,[T,r(s("input",{type:"password",class:"form-control",placeholder:"비밀번호 확인",id:"password2","onUpdate:modelValue":e[3]||(e[3]=o=>a.password2=o)},null,512),[[n,a.password2]])]),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:l.value},[A,t(" 확인 ")],8,z)],32)]))}};export{F as default};
