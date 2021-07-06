(function(e){function t(t){for(var s,r,l=t[0],i=t[1],u=t[2],d=0,p=[];d<l.length;d++)r=l[d],Object.prototype.hasOwnProperty.call(o,r)&&o[r]&&p.push(o[r][0]),o[r]=0;for(s in i)Object.prototype.hasOwnProperty.call(i,s)&&(e[s]=i[s]);c&&c(t);while(p.length)p.shift()();return n.push.apply(n,u||[]),a()}function a(){for(var e,t=0;t<n.length;t++){for(var a=n[t],s=!0,l=1;l<a.length;l++){var i=a[l];0!==o[i]&&(s=!1)}s&&(n.splice(t--,1),e=r(r.s=a[0]))}return e}var s={},o={app:0},n=[];function r(t){if(s[t])return s[t].exports;var a=s[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,r),a.l=!0,a.exports}r.m=e,r.c=s,r.d=function(e,t,a){r.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},r.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.t=function(e,t){if(1&t&&(e=r(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(r.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var s in e)r.d(a,s,function(t){return e[t]}.bind(null,s));return a},r.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return r.d(t,"a",t),t},r.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},r.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],i=l.push.bind(l);l.push=t,l=l.slice();for(var u=0;u<l.length;u++)t(l[u]);var c=i;n.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"034f":function(e,t,a){"use strict";a("85ec")},"03ad":function(e,t,a){"use strict";a("1446")},"0be2":function(e,t,a){"use strict";a.r(t),a.d(t,"postKeyValueRequest",(function(){return u})),a.d(t,"postRequest",(function(){return c})),a.d(t,"putRequest",(function(){return d})),a.d(t,"getRequest",(function(){return p})),a.d(t,"deleteRequest",(function(){return f}));a("0fb7"),a("450d");var s=a("f529"),o=a.n(s),n=(a("5319"),a("ac1f"),a("bc3a")),r=a.n(n),l=a("a18c");r.a.interceptors.response.use((function(e){if(console.log(e),!e.status||200!=e.status||500!=e.data.status)return e.status&&200==e.status&&parseInt(e.data.status)>=5e3&&(o.a.error({message:e.data.msg}),l["default"].replace("/")),e.data.obj;o.a.error({message:e.data.msg})}),(function(e){504==e.response.status||404==e.response.status?o.a.error({message:"服务器被吃了( ╯□╰ )"}):403==e.response.status?o.a.error({message:"权限不足，请联系管理员"}):401==e.response.status?(o.a.error({message:e.response.data.msg?e.response.data.msg:"尚未登录，请登录"}),l["default"].replace("/")):e.response.data.msg?o.a.error({message:e.response.data.msg}):o.a.error({message:"未知错误!"})}));var i="",u=function(e,t){return r()({method:"post",url:"".concat(i).concat(e),data:t,transformRequest:[function(e){var t="";for(var a in e)t+=encodeURIComponent(a)+"="+encodeURIComponent(e[a])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}})},c=function(e,t){return r()({method:"post",url:"".concat(i).concat(e),data:t})},d=function(e,t){return r()({method:"put",url:"".concat(i).concat(e),data:t})},p=function(e,t){return r()({method:"get",url:"".concat(i).concat(e),params:t})},f=function(e,t){return r()({method:"delete",url:"".concat(i).concat(e),params:t})}},"0c31":function(e,t,a){},"0eed":function(e,t,a){"use strict";a("451b")},"12c6":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{attrs:{direction:"vertical"}},[a("el-header",{attrs:{height:""}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"registry-status"},[e._v("地址: "+e._s(e.repository.address))]),a("div",{staticClass:"registry-status"},[e._v("仓库状态: "+e._s(e.repository.health))]),a("div",{staticClass:"registry-status"},[e._v("镜像数量: "+e._s(e.repository.count))]),a("div",{staticClass:"registry-status"},[e._v("磁盘占用: "+e._s(parseFloat(e.repository.diskSize/1024/1024/1024).toFixed(2))+"G")])])],1),a("el-main",{attrs:{height:""}},[a("el-row",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"1000px"},attrs:{data:e.imagePageList,"element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)","max-height":"600px"}},[a("el-table-column",{attrs:{prop:"name",label:"名称",width:"300"}}),a("el-table-column",{attrs:{prop:"version",label:"版本",width:"140"}}),a("el-table-column",{attrs:{prop:"id",label:"镜像ID",width:"100"}}),a("el-table-column",{attrs:{prop:"size",label:"大小",width:"140"}}),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间",width:"140"}}),a("el-table-column",{attrs:{align:"right"},scopedSlots:e._u([{key:"header",fn:function(t){return[a("el-input",{attrs:{size:"mini",placeholder:"输入关键字搜索",maxlength:"30px"},model:{value:e.search,callback:function(t){e.search=t},expression:"search"}},[e._v(e._s(t.$index))])]}},{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1),a("el-row",[a("div",{staticStyle:{float:"left"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,50,100],"page-size":e.currentPageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.imageTotal},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)])],1)],1)},o=[],n=(a("fb6a"),a("841c"),a("ac1f"),a("4de4"),a("caad"),a("2532"),a("b0c0"),a("b680"),a("159b"),{data:function(){return{loading:!1,imageList:[],currentPage:1,currentPageSize:10,search:"",repository:{address:"",health:"",diskSize:10,count:0},image_refresh_timer:null}},computed:{imageTotal:function(){return this.imageFilterList(this.imageList).length},imagePageList:function(){var e=(this.currentPage-1)*this.currentPageSize,t=e+this.currentPageSize,a=this.imageFilterList(this.imageList);return a.slice(e,t)}},mounted:function(){this.loading=!0,this.refreshImages(),null!=this.image_refresh_timer&&(this.image_refresh_timer=setInterval(this.refreshImages,2e3))},destroyed:function(){clearInterval(this.image_refresh_timer)},methods:{handleSizeChange:function(e){this.currentPageSize=parseInt(e)},handleCurrentChange:function(e){this.currentPage=parseInt(e)},handleDelete:function(e,t){console.log(e,t)},imageFilterList:function(e){var t=this;return""!=this.search?e.filter((function(e){return e.name.toLowerCase().includes(t.search.toLowerCase())})):e},repositoryStatus:function(){var e=this;this.getRequest("/repository/info").then((function(t){e.repository.address=t.address,e.repository.health=t.isHealth?"正常":"异常",e.repository.diskSize=t.diskSize,e.repository.count=t.count}))},floatToPrecision:function(e,t){return parseFloat(e).toFixed(t)},getImageList:function(){var e=this;this.getRequest("/repository/images").then((function(t){e.loading=!1,e.imageList=[],t.forEach((function(t){e.imageList.push({id:t.id.substr(0,8),name:t.name,version:t.version,size:e.floatToPrecision(t.size/1024/1024,2)+"M",createTime:t.createTime})}))}))},refreshImages:function(){this.repositoryStatus(),this.getImageList()}}}),r=n,l=(a("03ad"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports},1446:function(e,t,a){},"3dfd":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},o=[],n=(a("034f"),a("2877")),r={},l=Object(n["a"])(r,s,o,!1,null,null,null);t["default"]=l.exports},"3fc7":function(e,t,a){},4360:function(e,t,a){"use strict";a.r(t);var s=a("2b0e"),o=a("2f62");s["default"].use(o["a"]),t["default"]=new o["a"].Store({state:{},mutations:{},actions:{},modules:{}})},"451b":function(e,t,a){},"4bf6":function(e,t,a){},"513c":function(e,t,a){"use strict";a("0c31")},"56d7":function(e,t,a){"use strict";a.r(t);a("0fb7"),a("450d");var s=a("f529"),o=a.n(s),n=(a("46a1"),a("e5f2")),r=a.n(n),l=(a("9e1f"),a("6ed5")),i=a.n(l),u=(a("be4f"),a("896a")),c=a.n(u),d=(a("bc1c"),a("4726")),p=a.n(d),f=(a("f92a"),a("d775")),m=a.n(f),g=(a("279e"),a("7d94")),h=a.n(g),b=(a("fa4c"),a("e360")),v=a.n(b),_=(a("acb6"),a("c673")),y=a.n(_),w=(a("e3ea"),a("7bc3")),x=a.n(w),S=(a("fd71"),a("a447")),k=a.n(S),C=(a("2f02"),a("fe11")),z=a.n(C),P=(a("ed7b"),a("e1a5")),q=a.n(P),$=(a("bdc7"),a("aa2f")),R=a.n($),j=(a("de31"),a("c69e")),T=a.n(j),I=(a("a769"),a("5cc3")),F=a.n(I),L=(a("a673"),a("7b31")),O=a.n(L),E=(a("adec"),a("3d2d")),A=a.n(E),M=(a("6762"),a("dd3d")),N=a.n(M),D=(a("a586"),a("7464")),B=a.n(D),J=(a("28b2"),a("c7ad")),U=a.n(J),G=(a("b0ee"),a("d180")),H=a.n(G),K=(a("a335"),a("c0bb")),V=a.n(K),Q=(a("186a"),a("301f")),W=a.n(Q),X=(a("96dc"),a("9cea")),Y=a.n(X),Z=(a("9c49"),a("6640")),ee=a.n(Z),te=(a("d2ac"),a("95b0")),ae=a.n(te),se=(a("78a7"),a("33ca")),oe=a.n(se),ne=(a("b8e0"),a("a4c4")),re=a.n(ne),le=(a("e2f3"),a("06f9")),ie=a.n(le),ue=(a("f3e4"),a("9dda")),ce=a.n(ue),de=(a("6b30"),a("c284")),pe=a.n(de),fe=(a("f225"),a("89a9")),me=a.n(fe),ge=(a("f4f9"),a("c2cc")),he=a.n(ge),be=(a("7a0f"),a("0f6c")),ve=a.n(be),_e=(a("aaa5"),a("a578")),ye=a.n(_e),we=(a("b5c2"),a("20cf")),xe=a.n(we),Se=(a("915d"),a("e04d")),ke=a.n(Se),Ce=(a("5e32"),a("6721")),ze=a.n(Ce),Pe=(a("cbb5"),a("8bbc")),qe=a.n(Pe),$e=(a("e612"),a("dd87")),Re=a.n($e),je=(a("075a"),a("72aa")),Te=a.n(je),Ie=(a("eca7"),a("3787")),Fe=a.n(Ie),Le=(a("425f"),a("4105")),Oe=a.n(Le),Ee=(a("b84d"),a("c216")),Ae=a.n(Ee),Me=(a("8f24"),a("76b9")),Ne=a.n(Me),De=(a("0c67"),a("299c")),Be=a.n(De),Je=(a("06f1"),a("6ac9")),Ue=a.n(Je),Ge=(a("4ffc"),a("946e")),He=a.n(Ge),Ke=(a("d624"),a("3e9c")),Ve=a.n(Ke),Qe=(a("826b"),a("c263")),We=a.n(Qe),Xe=(a("5466"),a("ecdf")),Ye=a.n(Xe),Ze=(a("38a0"),a("ad41")),et=a.n(Ze),tt=(a("ae26"),a("845f")),at=a.n(tt),st=(a("1951"),a("eedf")),ot=a.n(st),nt=(a("016f"),a("486c")),rt=a.n(nt),lt=(a("6611"),a("e772")),it=a.n(lt),ut=(a("1f1a"),a("4e4b")),ct=a.n(ut),dt=(a("e960"),a("b35b")),pt=a.n(dt),ft=(a("d4df"),a("7fc1")),mt=a.n(ft),gt=(a("c526"),a("1599")),ht=a.n(gt),bt=(a("560b"),a("dcdc")),vt=a.n(bt),_t=(a("3c52"),a("0d7b")),yt=a.n(_t),wt=(a("fe07"),a("6ac5")),xt=a.n(wt),St=(a("b5d8"),a("f494")),kt=a.n(St),Ct=(a("9d4c"),a("e450")),zt=a.n(Ct),Pt=(a("10cb"),a("f3ad")),qt=a.n(Pt),$t=(a("34db"),a("3803")),Rt=a.n($t),jt=(a("8bd8"),a("4cb2")),Tt=a.n(jt),It=(a("ce18"),a("f58e")),Ft=a.n(It),Lt=(a("4ca3"),a("443e")),Ot=a.n(Lt),Et=(a("bd49"),a("18ff")),At=a.n(Et),Mt=(a("960d"),a("defb")),Nt=a.n(Mt),Dt=(a("cb70"),a("b370")),Bt=a.n(Dt),Jt=(a("3db2"),a("58b8")),Ut=a.n(Jt),Gt=(a("a7cc"),a("df33")),Ht=a.n(Gt),Kt=(a("672e"),a("101e")),Vt=a.n(Kt),Qt=(a("e260"),a("e6cf"),a("cca6"),a("a79d"),a("2b0e")),Wt=a("3dfd"),Xt=a("a18c"),Yt=a("4360"),Zt=a("0be2");Qt["default"].use(Vt.a),Qt["default"].use(Ht.a),Qt["default"].use(Ut.a),Qt["default"].use(Bt.a),Qt["default"].use(Nt.a),Qt["default"].use(At.a),Qt["default"].use(Ot.a),Qt["default"].use(Ft.a),Qt["default"].use(Tt.a),Qt["default"].use(Rt.a),Qt["default"].use(qt.a),Qt["default"].use(zt.a),Qt["default"].use(kt.a),Qt["default"].use(xt.a),Qt["default"].use(yt.a),Qt["default"].use(vt.a),Qt["default"].use(ht.a),Qt["default"].use(mt.a),Qt["default"].use(pt.a),Qt["default"].use(ct.a),Qt["default"].use(it.a),Qt["default"].use(rt.a),Qt["default"].use(ot.a),Qt["default"].use(at.a),Qt["default"].use(et.a),Qt["default"].use(Ye.a),Qt["default"].use(We.a),Qt["default"].use(Ve.a),Qt["default"].use(He.a),Qt["default"].use(Ue.a),Qt["default"].use(Be.a),Qt["default"].use(Ne.a),Qt["default"].use(Ae.a),Qt["default"].use(Oe.a),Qt["default"].use(Fe.a),Qt["default"].use(Te.a),Qt["default"].use(Re.a),Qt["default"].use(qe.a),Qt["default"].use(ze.a),Qt["default"].use(ke.a),Qt["default"].use(xe.a),Qt["default"].use(ye.a),Qt["default"].use(ve.a),Qt["default"].use(he.a),Qt["default"].use(me.a),Qt["default"].use(pe.a),Qt["default"].use(ce.a),Qt["default"].use(ie.a),Qt["default"].use(re.a),Qt["default"].use(oe.a),Qt["default"].use(ae.a),Qt["default"].use(ee.a),Qt["default"].use(Y.a),Qt["default"].use(W.a),Qt["default"].use(V.a),Qt["default"].use(H.a),Qt["default"].use(U.a),Qt["default"].use(B.a),Qt["default"].use(N.a),Qt["default"].use(A.a),Qt["default"].use(O.a),Qt["default"].use(F.a),Qt["default"].use(T.a),Qt["default"].use(R.a),Qt["default"].use(q.a),Qt["default"].use(z.a),Qt["default"].use(k.a),Qt["default"].use(x.a),Qt["default"].use(y.a),Qt["default"].use(v.a),Qt["default"].use(h.a),Qt["default"].use(m.a),Qt["default"].use(p.a),Qt["default"].use(c.a.directive),Qt["default"].prototype.$loading=c.a.service,Qt["default"].prototype.$msgbox=i.a,Qt["default"].prototype.$alert=i.a.alert,Qt["default"].prototype.$confirm=i.a.confirm,Qt["default"].prototype.$prompt=i.a.prompt,Qt["default"].prototype.$notify=r.a,Qt["default"].prototype.$message=o.a,Qt["default"].config.productionTip=!1,Qt["default"].prototype.postRequest=Zt["postRequest"],Qt["default"].prototype.postKeyValueRequest=Zt["postKeyValueRequest"],Qt["default"].prototype.putRequest=Zt["putRequest"],Qt["default"].prototype.deleteRequest=Zt["deleteRequest"],Qt["default"].prototype.getRequest=Zt["getRequest"],new Qt["default"]({router:Xt["default"],store:Yt["default"],render:function(e){return e(Wt["default"])}}).$mount("#app")},"5ced":function(e,t,a){},6872:function(e,t,a){e.exports=a.p+"img/docker.b763d38d.jpeg"},"6bd6":function(e,t,a){e.exports=a.p+"img/redis.4e6164bb.jpeg"},"76ed":function(e,t,a){e.exports=a.p+"img/etcd.6b802c62.jpeg"},"79cd":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{attrs:{direction:"vertical"}},[a("el-container",[a("el-main",[a("el-row",[a("el-col",{staticStyle:{height:"100px"},attrs:{span:1}},[a("el-image",{staticStyle:{width:"60px",height:"60px",margin:"auto",padding:"20px 0"},attrs:{src:e.login_url,fit:"fill",lazy:""}})],1),a("el-col",{staticStyle:{height:"100px"},attrs:{span:8}},[a("div",{staticStyle:{margin:"auto",padding:"2px","text-align":"left"}},[a("p",{staticStyle:{"font-size":"20px"}},[e._v("你好 "+e._s(e.user.username))]),a("p",[e._v("上次登录时间:"+e._s(e.user.login_time))])])])],1)],1)],1),a("el-container",{attrs:{direction:"horizontal"}},[a("el-container",[a("el-main",[a("el-card",{staticClass:"card-item",attrs:{shadow:"always"}},[a("el-col",{attrs:{span:12}},[a("div",{staticStyle:{width:"300px",height:"250px"},attrs:{id:"node-status"}})]),a("el-col",{attrs:{span:12}},[a("div",{staticStyle:{width:"300px",height:"250px"},attrs:{id:"pod-status"}})])],1)],1)],1),a("el-container",[a("el-main",[a("el-row",{attrs:{gutter:2}},e._l(e.module_statuses,(function(t){return a("el-col",{key:t.name,attrs:{span:6}},[a("el-card",{staticClass:"module-status card-item",attrs:{shadow:"always"}},[a("div",{staticStyle:{padding:"50px 0"}},[a("el-row",[a("div",{staticStyle:{"font-size":"15px"}},[e._v(e._s(t.name))])]),a("el-row",{staticStyle:{"font-size":"30px"}},[a("span",{staticStyle:{color:"#F56C6C"}},[e._v(e._s(t.exception))]),e._v("/"),a("span",[e._v(e._s(t.total))])]),a("el-row",[a("div",{staticStyle:{color:"#909399"}},[e._v("异常/正常")])])],1)])],1)})),1)],1)],1)],1),a("el-container",[a("el-main",[a("el-row",{staticStyle:{width:"100%"}},[a("el-col",{attrs:{span:24}},[a("el-card",{attrs:{shadow:"always","body-style":{padding:"20px"}}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{float:"left",padding:"9px 0","font-size":"20px"}},[e._v("集群节点")]),a("el-select",{staticStyle:{float:"right",padding:"3px 0"},attrs:{placeholder:"请选择"},model:{value:e.node_order_by,callback:function(t){e.node_order_by=t},expression:"node_order_by"}},e._l(e.order_by_options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.nodes,stripe:""}},[a("el-table-column",{attrs:{label:"节点"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-row",[a("i",{staticClass:"el-icon-s-platform"}),a("span",{staticStyle:{"font-size":"18px"}},[e._v(e._s(t.row.name))])]),a("el-row",[a("span",{staticStyle:{"font-size":"12px"}},[e._v(e._s(t.row.ip))])])]}}])}),a("el-table-column",{attrs:{label:"CPU",width:"200px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-row",[a("el-progress",{attrs:{"text-inside":!0,"stroke-width":12,percentage:t.row.cpu.limitPercentage}})],1),a("el-row",[a("el-progress",{attrs:{status:"success","text-inside":!0,"stroke-width":12,percentage:t.row.cpu.requestPercentage}})],1),a("el-row",[a("div",{staticStyle:{"font-size":"12px"}},[e._v("limit: "+e._s(t.row.cpu.limit)+" request: "+e._s(t.row.cpu.request)+" 总共: "+e._s(t.row.cpu.total))])])]}}])}),a("el-table-column",{attrs:{label:"内存",width:"300px"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-row",[a("el-progress",{attrs:{"text-inside":!0,"stroke-width":12,percentage:t.row.memory.limitPercentage}})],1),a("el-row",[a("el-progress",{attrs:{status:"success","text-inside":!0,"stroke-width":12,percentage:t.row.memory.requestPercentage}})],1),a("el-row",[a("div",{staticStyle:{"font-size":"12px"}},[e._v("limit: "+e._s(t.row.memory.limit)+"Gi,request:"+e._s(t.row.memory.request)+"Gi 总共: "+e._s(t.row.memory.total)+"Gi")])])]}}])}),a("el-table-column",{attrs:{label:"容器组"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-row",[a("div",{staticStyle:{"font-size":"12px"}},[e._v("已启动: "+e._s(t.row.containers.total)+" 异常: "+e._s(t.row.containers.exception))])]),a("el-row",[a("div",{staticStyle:{"font-size":"12px"}},[e._v("限制: "+e._s(t.row.containers.limit))])])]}}])}),a("el-table-column",{attrs:{label:"镜像"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("div",[e._v("数目: "+e._s(t.row.image.total))]),a("div",[e._v("占用磁盘大小: "+e._s(t.row.image.disk)+"Gi")])]}}])}),a("el-table-column",{attrs:{label:"节点状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("div",[e._v(e._s(t.row.node_status))]),a("div",{staticStyle:{"font-size":"12px",color:"#F56C6C"}},[e._v(e._s(t.row.error_msg))])]}}])})],1)],1)],1)],1)],1)],1)],1)},o=[],n=(a("b680"),a("b0c0"),a("313e")),r={data:function(){return{etcd_url:"",redis_url:"",kubernetes_url:"",docker_url:"",login_url:"",node_switch:"",node_order_by:"memory",order_by_options:[{value:"memory",label:"按内存使用率"},{value:"cpu",label:"按CPU使用率"}],node_total:0,node_exception:0,pod_total:0,pod_exception:0,nodes:[],module_statuses:[],status_timer:null,echart_pie_node:null,echart_pie_pod:null,user:{username:"",login_time:""}}},computed:{node_normal:function(){return this.node_total-this.node_exception},pod_normal:function(){return this.pod_total-this.pod_exception}},mounted:function(){console.log("mounted..."),this.clusterStatus(),this.status_timer=setInterval(this.clusterStatus,1e4);var e=JSON.parse(window.sessionStorage.getItem("user"));this.user.username=e.username,this.user.login_time=e.login_time},created:function(){console.log("created...");var e="assets/etcd.jpeg";this.etcd_url=a("a8ec")("./"+e);var t="assets/redis.jpeg";this.redis_url=a("a8ec")("./"+t);var s="assets/docker.jpeg";this.docker_url=a("a8ec")("./"+s);var o="assets/kubernetes.jpeg";this.kubernetes_url=a("a8ec")("./"+o);var n="assets/login.jpeg";this.login_url=a("a8ec")("./"+n)},destroyed:function(){console.log("destroyed..."),null!=this.status_timer&&clearInterval(this.status_timer)},methods:{floatToPrecision:function(e,t){return parseFloat(e).toFixed(t)},parsePercentage:function(e,t){var a=this.floatToPrecision(e/t*100,2);return"0.00"==a?0:parseFloat(a)},parseResourceSize:function(e){return this.floatToPrecision(e/1024/1024/1024,2)},refreshNodeStatus:function(){null==this.echart_pie_node&&(this.echart_pie_node=n["a"](document.getElementById("node-status"))),null==this.echart_pie_pod&&(this.echart_pie_pod=n["a"](document.getElementById("pod-status")));var e={title:{text:"Node节点",left:"center",top:"2%",textStyle:{fontSize:16}},legend:{left:"center",bottom:0,orient:"horizontal"},series:[{name:"Node",type:"pie",radius:["30%","70%"],label:{show:!1},data:[{value:this.node_normal,name:"正常:"+this.node_normal,itemStyle:{color:"#409EFF"}},{value:this.node_exception,name:"异常:"+this.node_exception,itemStyle:{color:"#909399"}}]}]};this.echart_pie_node.setOption(e);var t={title:{text:"Pod实例",left:"center",top:"2%",textStyle:{fontSize:16}},legend:{left:"center",bottom:0,orient:"horizontal"},series:[{name:"Pod",type:"pie",radius:["30%","70%"],label:{show:!1},data:[{value:this.pod_normal,name:"正常:"+this.pod_normal,itemStyle:{color:"#409EFF"}},{value:this.pod_exception,name:"异常:"+this.pod_exception,itemStyle:{color:"#909399"}}]}]};this.echart_pie_pod.setOption(t)},clusterStatus:function(){var e=this;console.log("clusterStatus"),this.getRequest("/cluster/status").then((function(t){if(t){for(var a in e.node_total=t.nodeTotal,e.node_exception=t.nodeException,e.pod_total=t.podTotal,e.pod_exception=t.podException,e.nodes=[],t.nodeStatuses){var s=t.nodeStatuses[a];e.nodes.push({name:s.name,ip:s.ip,image:{total:s.imageTotal,disk:e.parseResourceSize(s.imageDiskTotalByte)},cpu:{total:s.cpuTotal,limit:s.cpuLimit,limitPercentage:e.parsePercentage(s.cpuLimit,s.cpuTotal),request:s.cpuRequest,requestPercentage:e.parsePercentage(s.cpuRequest,s.cpuTotal)},memory:{total:e.parseResourceSize(s.memoryTotal),limit:e.parseResourceSize(s.memoryLimit),limitPercentage:e.parsePercentage(s.memoryLimit,s.memoryTotal),request:e.parseResourceSize(s.memoryRequest),requestPercentage:e.parsePercentage(s.memoryRequest,s.memoryTotal)},containers:{limit:s.containerLimit,total:s.containerTotal,exception:s.containerException},node_status:s.isHealth?"正常":"异常",error_msg:s.errMsg})}for(var o in e.module_statuses=[],t.moduleStatuses){var n=t.moduleStatuses[o];e.module_statuses.push({name:o,total:n.total,exception:n.exception})}e.refreshNodeStatus()}}))}}},l=r,i=(a("513c"),a("2877")),u=Object(i["a"])(l,s,o,!1,null,null,null);t["default"]=u.exports},"85ec":function(e,t,a){},"91e0":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{attrs:{direction:"vertical"}},[a("el-main",{attrs:{height:""}},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"100px","label-position":"left"}},[a("el-collapse",[a("el-collapse-item",{attrs:{title:"基本信息",name:"1"}},[a("el-form-item",{staticClass:"input-item",attrs:{label:"应用名称"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{staticClass:"input-item",attrs:{label:"描述"}},[a("el-input",{attrs:{type:"textarea",rows:3},model:{value:e.form.description,callback:function(t){e.$set(e.form,"description",t)},expression:"form.description"}})],1)],1),a("el-collapse-item",{attrs:{title:"镜像",name:"2"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"镜像"}},[a("el-select",{staticClass:"form-select",attrs:{placeholder:"请选择镜像"},model:{value:e.form.image,callback:function(t){e.$set(e.form,"image",t)},expression:"form.image"}},[a("el-option",{attrs:{label:"busybox:latest",value:"busybox:latest"}}),a("el-option",{attrs:{label:"nginx:v1",value:"nginx:v1"}})],1)],1)],1),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"镜像拉取策略"}},[a("el-select",{staticClass:"form-select",attrs:{placeholder:"请选择拉取策略"},model:{value:e.form.pullPolicy,callback:function(t){e.$set(e.form,"pullPolicy",t)},expression:"form.pullPolicy"}},[a("el-option",{attrs:{label:"从不拉取",value:"Never"}}),a("el-option",{attrs:{label:"本地不存在才拉取",value:"IfNotPresent"}}),a("el-option",{attrs:{label:"每次都拉取",value:"Always"}})],1)],1)],1)],1),a("el-row",[a("el-form-item",{staticClass:"input-item",attrs:{label:"启动命令"}},[a("el-input",{attrs:{type:"textarea",rows:3},model:{value:e.form.command,callback:function(t){e.$set(e.form,"command",t)},expression:"form.command"}})],1)],1)],1),a("el-collapse-item",{attrs:{title:"部署",name:"3"}},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"模式"}},[a("el-select",{staticClass:"form-select",attrs:{placeholder:"请选择"},model:{value:e.form.deployMode,callback:function(t){e.$set(e.form,"deployMode",t)},expression:"form.deployMode"}},[a("el-option",{attrs:{label:"Pod",value:"Pod"}}),a("el-option",{attrs:{label:"DeamonSet",value:"DeamonSet"}}),a("el-option",{attrs:{label:"Deployment",value:"Deployment"}}),a("el-option",{attrs:{label:"Job",value:"Job"}})],1)],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"目标实例数"}},[a("el-input-number",{staticClass:"form-num",attrs:{min:1},model:{value:e.form.target,callback:function(t){e.$set(e.form,"target",t)},expression:"form.target"}})],1)],1)],1)],1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("保存")]),a("el-button",{on:{click:e.onCancel}},[e._v("取消")])],1)],1)],1)],1)},o=[],n=(a("b0c0"),a("a4d3"),a("e01a"),a("d3b7"),a("5319"),a("ac1f"),{data:function(){return{form:{name:"",description:"",image:"",pullPolicy:"",command:"",deployMode:"",target:0}}},props:["appId"],mounted:function(){if(null!=this.appId){var e=this;this.getRequest("/application/"+this.appId).then((function(t){e.form.id=t.id,e.form.name=t.name,e.form.description=t.description,e.form.image=t.image,e.form.pullPolicy=t.pullPolicy,e.form.command=t.command,e.form.deployMode=t.deployMode,e.form.target=t.target}))}},methods:{onSubmit:function(){var e=this;this.$confirm("是否保存应用?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.postRequest("/application",e.form),e.$message({type:"success",message:"创建成功!"})})).catch((function(){e.$message({type:"info",message:"已取消"})})).finally((function(){e.$router.replace("/viewApps")}))},onCancel:function(){var e=this;this.$confirm("是否取消?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"info"}).finally((function(){e.$router.replace("/viewApps")}))}}}),r=n,l=(a("0eed"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports},"9be8":function(e,t,a){"use strict";a("3fc7")},a18c:function(e,t,a){"use strict";a.r(t);var s=a("2b0e"),o=a("8c4f"),n=a("bb51"),r=a("12c6"),l=a("a55b"),i=a("e082"),u=a("79cd"),c=a("eba4"),d=a("91e0");s["default"].use(o["a"]);var p=[{path:"/",name:"Login",component:l["default"],hidden:!0},{path:"/home",name:"Home",component:n["default"],hidden:!0,children:[{path:"/viewRegistry",name:"Registry",component:r["default"]},{path:"/viewApps",name:"Apps",component:i["default"]},{path:"/viewAppsCreate",name:"AppsCreate",component:d["default"],props:function(e){return{appId:e.query.appId}}},{path:"/viewMetrics",name:"Metrics",component:u["default"]},{path:"/viewSysconfig",name:"Sysconfig",component:c["default"]}]},{path:"*",redirect:"/home"}],f=new o["a"]({mode:"hash",routes:p});t["default"]=f},a55b:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"loginForm",staticClass:"loginContainer",attrs:{rules:e.rules,model:e.loginForm,"element-loading-text":"正在登录...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)","label-width":"100px"}},[a("h3",{staticClass:"loginTitle"},[e._v("系统登录")]),a("el-form-item",{attrs:{label:"用户名",prop:"username"}},[a("el-input",{attrs:{size:"normal",type:"text","auto-complete":"off",placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),a("el-form-item",{attrs:{label:"密码",prop:"password"}},[a("el-input",{attrs:{size:"normal",type:"password",autocomplete:"off",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),a("el-button",{staticStyle:{width:"100%"},attrs:{size:"normal",type:"primary"},on:{click:e.onSubmit}},[e._v("登录")])],1)],1)},o=[],n=(a("5319"),a("ac1f"),{data:function(){return{loading:!1,loginForm:{username:"",password:""},rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{onSubmit:function(){var e=this;this.$refs.loginForm.validate((function(t){if(!t)return!1;var a=e;a.loading=!0,e.postRequest("/doLogin",e.loginForm).then((function(t){console.log(t),a.loading=!1;var s=t;s["login_time"]=new Date,window.sessionStorage.setItem("user",JSON.stringify(s));var o=e.$route.query.redirect;a.$router.replace("/"==o||void 0==o?"/home":o)})).catch((function(e){a.$message.error(e.response.msg)}))}))}}}),r=n,l=(a("d6db"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports},a8ec:function(e,t,a){var s={"./App":"3dfd","./App.vue":"3dfd","./assets/docker.jpeg":"6872","./assets/etcd.jpeg":"76ed","./assets/kubernetes.jpeg":"cdfa","./assets/login.jpeg":"b046","./assets/logo.png":"cf05","./assets/redis.jpeg":"6bd6","./main":"56d7","./main.js":"56d7","./router":"a18c","./router/":"a18c","./router/index":"a18c","./router/index.js":"a18c","./store":"4360","./store/":"4360","./store/index":"4360","./store/index.js":"4360","./utils/apis":"0be2","./utils/apis.js":"0be2","./views/AppCreate":"91e0","./views/AppCreate.vue":"91e0","./views/Apps":"e082","./views/Apps.vue":"e082","./views/Home":"bb51","./views/Home.vue":"bb51","./views/Login":"a55b","./views/Login.vue":"a55b","./views/Metrics":"79cd","./views/Metrics.vue":"79cd","./views/Registry":"12c6","./views/Registry.vue":"12c6","./views/Sysconfig":"eba4","./views/Sysconfig.vue":"eba4"};function o(e){var t=n(e);return a(t)}function n(e){if(!a.o(s,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return s[e]}o.keys=function(){return Object.keys(s)},o.resolve=n,e.exports=o,o.id="a8ec"},b046:function(e,t,a){e.exports=a.p+"img/login.e26bcc95.jpeg"},bb51:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticStyle:{height:"500px"}},[a("el-header",{staticClass:"home-header"},[a("span",{staticStyle:{color:"aliceblue","font-size":"25px",position:"absolute",left:"20px",top:"20px"}},[e._v("微平台")]),a("el-dropdown",{staticStyle:{position:"absolute",right:"40px",top:"30px"},on:{command:e.handleCommand}},[a("span",{staticClass:"el-dropdown-link"},[e._v(" "+e._s(e.current_user)),a("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"logout"}},[e._v("注销登录")]),a("el-dropdown-item",{attrs:{command:"modify"}},[e._v("修改密码")])],1)],1)],1),a("el-container",[a("el-aside",{staticStyle:{width:"8%"}},[a("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{collapse:e.isCollapse,"default-active":e.openMenu,router:""}},[a("el-menu-item",{key:"1",staticClass:"menu-item",attrs:{index:"/viewMetrics"}},[a("i",{staticClass:"el-icon-data-analysis"}),a("span",{attrs:{slot:"title"},slot:"title"},[e._v("工作台")])]),a("el-menu-item",{key:"2",staticClass:"menu-item",attrs:{index:"/viewApps"}},[a("i",{staticClass:"el-icon-menu"}),a("span",{attrs:{slot:"title"},slot:"title"},[e._v("应用管理")])]),a("el-menu-item",{key:"3",staticClass:"menu-item",attrs:{index:"/viewRegistry"}},[a("i",{staticClass:"el-icon-box"}),a("span",{attrs:{slot:"title"},slot:"title"},[e._v("仓库镜像")])]),a("el-menu-item",{key:"4",staticClass:"menu-item",attrs:{index:"/viewSysconfig"}},[a("i",{staticClass:"el-icon-setting"}),a("span",{attrs:{slot:"title"},slot:"title"},[e._v("系统配置")])])],1)],1),a("el-main",[a("router-view")],1)],1)],1)},o=[],n=(a("5319"),a("ac1f"),{data:function(){return{isCollapse:!1,openMenu:"/viewRegistry"}},computed:{current_user:function(){var e=JSON.parse(window.sessionStorage.getItem("user"));return e.username}},methods:{handleCommand:function(e){console.log(e),"logout"===e&&(this.getRequest("/logout"),window.sessionStorage.removeItem("user"),this.$router.replace("/"))}}}),r=n,l=(a("cccb"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports},c924:function(e,t,a){"use strict";a("4bf6")},cccb:function(e,t,a){"use strict";a("5ced")},cdfa:function(e,t,a){e.exports=a.p+"img/kubernetes.cf70d27c.jpeg"},cf05:function(e,t,a){e.exports=a.p+"img/logo.2483c8d2.png"},d6db:function(e,t,a){"use strict";a("e67a")},e082:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{attrs:{direction:"vertical"}},[a("el-header",{attrs:{height:""}},[a("el-row",[a("el-button",{staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:e.createApp}},[e._v("创建")])],1)],1),a("el-container",{attrs:{direction:"horizontal"}},[a("el-main",{attrs:{height:""}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.applicationList}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{type:"expand"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-form",{staticClass:"demo-table-expand",attrs:{"label-position":"left",inline:""}},[a("el-form-item",{attrs:{label:"id"}},[a("span",[e._v(e._s(t.row.id))])]),a("el-form-item",{attrs:{label:"名称"}},[a("span",[e._v(e._s(t.row.name))])]),a("el-form-item",{attrs:{label:"镜像"}},[a("span",[e._v(e._s(t.row.image))])]),a("el-form-item",{attrs:{label:"启动命令"}},[a("span",[e._v(e._s(t.row.cmd))])]),a("el-form-item",{attrs:{label:"目标实例数"}},[a("span",[e._v(e._s(t.row.target))])]),a("el-form-item",{attrs:{label:"实际实例数"}},[a("span",[e._v(e._s(t.row.ready))])]),a("el-form-item",{attrs:{label:"已更新实例数"}},[a("span",[e._v(e._s(t.row.update))])]),a("el-form-item",{attrs:{label:"可用实例数"}},[a("span",[e._v(e._s(t.row.available))])]),a("el-form-item",{attrs:{label:"创建时间"}},[a("span",[e._v(e._s(t.row.create_time))])])],1)]}}])}),a("el-table-column",{attrs:{label:"名称",prop:"name",width:"140px"}}),a("el-table-column",{attrs:{label:"镜像",prop:"image",width:"140px"}}),a("el-table-column",{attrs:{label:"目标实例数",prop:"target",width:"100px"}}),a("el-table-column",{attrs:{label:"实际实例数",prop:"ready",width:"100px"}}),a("el-table-column",{attrs:{label:"已更新实例数",prop:"update",width:"140px"}}),a("el-table-column",{attrs:{label:"可用实例数",prop:"available",width:"100px"}}),a("el-table-column",{attrs:{label:"创建时间",prop:"create_time"}}),a("el-table-column",{attrs:{align:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.row)}}},[e._v("Edit")]),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("Delete")])]}}])},[a("template",{slot:"header"},[a("el-input",{attrs:{size:"mini",placeholder:"输入关键字搜索"},model:{value:e.search,callback:function(t){e.search=t},expression:"search"}})],1)],2)],1)],1)],1)],1)},o=[],n=(a("159b"),a("b0c0"),{data:function(){return{applications:{},applicationList:[],search:"",refresh_app_timer:null}},mounted:function(){console.log("Apps mounted"),this.listApp(),this.refresh_app_timer=setInterval(this.listApp,5e3)},destroyed:function(){clearInterval(this.refresh_app_timer)},methods:{handleEdit:function(e){this.$router.push("/viewAppsCreate?appId="+e.id)},handleDelete:function(e){this.deleteRequest("/application?appId="+e.id),this.listApp()},createApp:function(){this.$router.push("/viewAppsCreate")},listApp:function(){this.applications={},this.applicationList=[];var e=this;this.getRequest("/application").then((function(t){t.forEach((function(t){var a={id:t.id,name:t.name,command:t.command,image:t.image,target:t.target,pullPolicy:"",ready:0,available:0,update:0,create_time:t.createTime};e.applications[t.id]=a,e.applicationList.push(a)}))}))}}}),r=n,l=(a("9be8"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports},e67a:function(e,t,a){},eba4:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-collapse",{attrs:{accordion:""},on:{change:e.handleChange},model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{key:"1",attrs:{title:"镜像仓库",name:"1"}},[a("el-form",{ref:"form",staticClass:"config-form",attrs:{model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"地址"}},[a("el-input",{model:{value:e.form.url,callback:function(t){e.$set(e.form,"url",t)},expression:"form.url"}})],1),a("el-form-item",{staticStyle:{left:"50px"}},[a("el-button",{attrs:{type:"primary"},on:{click:e.onEdit}},[e._v("编辑")]),a("el-button",{on:{click:e.onSubmit}},[e._v("保存")])],1)],1)],1),a("el-collapse-item",{key:"2",attrs:{title:"K8S",name:"2"}},[a("el-form",{ref:"form",staticClass:"config-form",attrs:{model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"kubeconfig"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.kubeconfig,callback:function(t){e.$set(e.form,"kubeconfig",t)},expression:"form.kubeconfig"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.onEdit}},[e._v("编辑")]),a("el-button",{on:{click:e.onSubmit}},[e._v("保存")])],1)],1)],1)],1)},o=[],n={data:function(){return{disable:!0,activeNames:[],form:{name:"test",url:"",kubeconfig:""}}},methods:{handleChange:function(e){console.log(e)},onSubmit:function(){console.log("submit!"),this.disable=!0},onEdit:function(){this.disable=!1}}},r=n,l=(a("c924"),a("2877")),i=Object(l["a"])(r,s,o,!1,null,null,null);t["default"]=i.exports}});
//# sourceMappingURL=app.b552095f.js.map