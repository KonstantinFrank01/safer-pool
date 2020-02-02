<template>
  <div id="tableData">
    <div id="message">
      <h1>Message Placeholder</h1>
    </div>
    <div id="table">
      <b-table striped hover :items="items"></b-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "DataInTable",
  props: {
    msg: String
  },
  data() {
    return {
      items: [
        { x: "1", y: "1", z: "1", Time: "", Place: "Pool1" },
        { x: "2", y: "2", z: "2", Time: "", Place: "Pool2" },
        { x: "3", y: "3", z: "3", Time: "", Place: "Pool3" }
      ]
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#message {
  margin-top: 5%;
  margin-bottom: 5%;
}
</style>
