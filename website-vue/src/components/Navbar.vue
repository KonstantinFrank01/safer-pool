<template>
  <div id="navBarBg">
    <b-navbar toggleable="lg" type="light" variant="disabled">
      <b-navbar-brand id="logoBox">
        <img alt="Vue logo" src="../assets/logo_final.png" />
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#" id="navBarItem">Detection</b-nav-item>
          <b-nav-item href="#" id="navBarItem">Documentation</b-nav-item>
          <b-nav-item href="#" id="navBarItem">About</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "Navbar",
  props: {
    msg: String
  }
};
</script>

<style scoped>
#logoBox img {
  height: 100px;
}

#navBarItem {
  margin-left: 20%;
  font-size: 20px;
}

#navBarBg {
  background-color: lightgray;
}
</style>
