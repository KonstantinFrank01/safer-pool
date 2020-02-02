<template>
  <div id="app">
    <Navbar />
    <router-view></router-view>
    <Footer />
  </div>
</template>

<script>
//import HelloWorld from "./components/HelloWorld.vue";
import Navbar from "./components/Navbar.vue";
import Footer from "./components/Footer.vue";

export default {
  name: "app",
  components: {
    Navbar,
    Footer
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
img {
  height: 200px;
}
</style>
