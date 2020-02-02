import Vue from "vue";
import App from "./App.vue";
import VueRouter from "vue-router";
import { BootstrapVue } from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

import DataInTable from "./components/DataInTable.vue";
import Test from "./components/Test.vue";

var SocialSharing = require("vue-social-sharing");

Vue.use(SocialSharing);

// Install BootstrapVue
Vue.use(BootstrapVue);

Vue.config.productionTip = false;

Vue.use(VueRouter);

const routes = [
  { path: "/", component: DataInTable },
  { path: "/test", component: Test }
];

const router = new VueRouter({
  routes
});

new Vue({
  render: h => h(App),
  router
}).$mount("#app");
