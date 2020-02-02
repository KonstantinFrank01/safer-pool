<template>
  <footer class="page-footer font-large special-color-dark pt-4">
    <div class="container">
      <ul class="list-unstyled text-center">
        <li class="list-inline-item">
          <a class="btn-flaoting mx-1" href="mailto:office@htl-leonding.ac.at">
            <Email></Email>
          </a>
        </li>
        <li class="list-inline-item">
          <a
            class="btn-flaoting mx-1"
            href="https://www.facebook.com/htlleonding/"
          >
            <Facebook></Facebook>
          </a>
        </li>
        <!--<li class="list-inline-item">
          <a
            class="btn-flaoting mx-1"
            href="https://www.youtube.com/channel/UC5zrWVUTmjnWqdl-2Dt0DVg"
          >
          </a>
        </li>

        <li class="list-inline-item">
          <a
            class="btn-flaoting mx-1"
            href="https://www.instagram.com/htlleonding/"
          >
            <Twitter></Twitter>
          </a>
        </li>-->
      </ul>
    </div>
    <div class="footer-copyright text-center py-3">
      2019 HTL Leonding:
      <a href="http://www.htl-leonding.at/index.php?id=1561">htl-leonding.at</a>
    </div>
  </footer>
</template>

<script>
export default {
  name: "Footer",
  components: {
    Facebook,
    Email
  }
};

import { Facebook } from "vue-socialmedia-share";
import { Email } from "vue-socialmedia-share";
//import { Twitter } from "vue-socialmedia-share";
</script>
<style>
.footer-copyright {
  margin-left: 3%;
  margin-top: -3%;
  float: left;
}

.container {
  margin-top: 15%;
}
</style>
