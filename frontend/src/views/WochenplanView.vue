<script setup lang="ts">
import {ref} from "vue";

const props = defineProps(["benutzer"]);
const wochenplaene = ref()
const selectWochenplan = ref("")

const name = ref()
getWochenplaene()

async function getWochenplaene() {
  wochenplaene.value = await (await fetch(`/api/wochenplaene/${props.benutzer.id}`)).json();
}

</script>

<template>
  <div v-if="benutzer">
    <div>
      <h2>{{ benutzer.name }}'s Wochenpläne</h2>
    </div>
    <div class="d-flex justify-content-center">
      <div v-if="wochenplaene != ''">
        <select class="form-select" v-model="selectWochenplan">
          <option value="" selected disabled>Wochenplan auswählen</option>
          <option v-for="option in wochenplaene" :value="option.name">
            {{ option.name }}
          </option>
        </select>
      </div>
      <div v-if="wochenplaene != ''" class="d-flex align-items-center">
        <p>oder</p>
      </div>
      <!--    <form @submit.prevent="addWochenplan">-->
      <!--      <div class="input-group">-->
      <!--        <input type="text" v-model="name" class="form-control"-->
      <!--               placeholder="Neuen Wochenplan erstellen">-->
      <!--        <button class="btn btn-outline-secondary" type="submit">Los</button>-->
      <!--      </div>-->
      <!--    </form>-->
    </div>
  </div>
</template>

<style scoped>
p {
  margin: 0;
  padding: 0;
}

div {
  margin: 1rem;
}
</style>