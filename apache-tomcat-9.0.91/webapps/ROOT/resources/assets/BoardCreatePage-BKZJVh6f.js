import{b as g,a as w,u as x,c as d,r as k,d as T,j as V,o as n,e as i,f as e,w as r,v as u,q,F as f,p as S,h as c,k as B,l as C,x as M,i as N,t as U}from"./index-BunKZIph.js";import{b as p}from"./boardApi-BvWyza9N.js";import"./index-D4xXOV2W.js";const A=e("h1",null,[e("i",{class:"fa-regular fa-pen-to-square"}),c(" 글 작성")],-1),D={class:"mb-3 mt-3 row"},F={class:"col-8"},R=e("label",{for:"title",class:"form-label"}," 제목 ",-1),j={class:"col-4"},E=e("label",{for:"title",class:"form-label"}," Type ",-1),L=["value"],P={class:"mb-3 mt-3"},z=e("label",{for:"files",class:"form-label"}," 첨부파일 ",-1),G={class:"mb-3 mt-3"},H=e("label",{for:"content",class:"form-label"}," 내용 ",-1),I={class:"my-5 text-center"},J=["disabled"],K=e("i",{class:"fa-solid fa-check"},null,-1),O=e("i",{class:"fa-solid fa-list"},null,-1),ee={__name:"BoardCreatePage",setup(Q){const m=g(),_=w(),b=x(),o=d(null),a=d([]),t=k({writer:m.id,title:"",type:"plain",content:"",files:null}),h=T(()=>!t.title),y=async()=>{confirm("등록할까요?")&&(o.value.files.length>0&&(t.files=o.value.files),await p.create(t),_.push({name:"/board/list"}))};return(async()=>{try{a.value=await p.getTypes(),console.log(a.value)}catch{}})(),(X,l)=>{const v=V("router-link");return n(),i(f,null,[A,e("form",{onSubmit:N(y,["prevent"])},[e("div",D,[e("div",F,[R,r(e("input",{type:"text",class:"form-control",placeholder:"제목",id:"title","onUpdate:modelValue":l[0]||(l[0]=s=>t.title=s)},null,512),[[u,t.title]])]),e("div",j,[E,r(e("select",{"onUpdate:modelValue":l[1]||(l[1]=s=>t.type=s),class:"form-select",required:""},[(n(!0),i(f,null,S(a.value,s=>(n(),i("option",{key:s,value:s.type},U(s.name),9,L))),128))],512),[[q,t.type]])])]),e("div",P,[z,e("input",{type:"file",class:"form-control",placeholder:"첨부파일",id:"files",ref_key:"files",ref:o,multiple:""},null,512)]),e("div",G,[H,r(e("textarea",{class:"form-control",placeholder:"내용",id:"content","onUpdate:modelValue":l[2]||(l[2]=s=>t.content=s),rows:"10"},null,512),[[u,t.content]])]),e("div",I,[e("button",{type:"submit",class:"btn btn-primary me-3",disabled:h.value},[K,c(" 확인 ")],8,J),B(v,{class:"btn btn-primary",to:{name:"board/list",query:M(b).query}},{default:C(()=>[O,c(" 목록 ")]),_:1},8,["to"])])],32)],64)}}};export{ee as default};
