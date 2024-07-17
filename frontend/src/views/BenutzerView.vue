<script setup lang="ts">
import {ref} from "vue";

const benutzer = ref()
const wochenplaene = ref()
const selectBenutzer = ref<any>("")
const selectWochenplan = ref<any>("")
const selectAktivitaet = ref<any>()
const benutzerName = ref()
const wochenplanName = ref()
const aktivitaetName = ref<any>([])
const aktivitaetWochentag = ref<any>()
const aktivitaeten = ref()
const wochentage = ref(["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"])
const successBenutzer = ref<any>(false)
const successWochenplan = ref<any>(false)

getBenutzer()

async function print() {
  window.print();
}

async function getAktivitaeten() {
  aktivitaeten.value = await (await fetch(`/api/aktivitaeten/wochenplan/${selectWochenplan.value.id}`)).json();
}

async function getWochenplaene() {
  selectWochenplan.value = "";
  wochenplaene.value = await (await fetch(`/api/wochenplaene/${selectBenutzer.value.id}`)).json();
}

async function getBenutzer() {
  benutzer.value = await (await fetch("/api/benutzer")).json();
}

async function addBenutzer() {
  await fetch("/api/benutzer", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      name: benutzerName.value
    })
  }).then((response) => {
    if (response.ok) {
      successBenutzer.value = true;
      setTimeout(() => successBenutzer.value = false, 3000);
    }
  });
  await getBenutzer();
  selectBenutzer.value = benutzer.value[benutzer.value.length - 1];
  await getWochenplaene();
  benutzerName.value = "";
}

async function addWochenplan() {
  await fetch("/api/wochenplaene", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      benutzerId: selectBenutzer.value.id,
      name: wochenplanName.value
    })
  }).then((response) => {
    if (response.ok) {
      successWochenplan.value = true;
      setTimeout(() => successWochenplan.value = false, 3000);
    }
  });
  await getWochenplaene();
  selectWochenplan.value = wochenplaene.value[wochenplaene.value.length - 1];
  await getAktivitaeten();
  wochenplanName.value = "";
}

async function addAktivitaet() {
  await fetch("/api/aktivitaeten", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      wochenplanId: selectWochenplan.value.id,
      name: aktivitaetName.value[aktivitaetWochentag.value],
      wochentag: wochentage.value[aktivitaetWochentag.value]
    })
  });
  aktivitaetName.value = [];
  await getAktivitaeten();
}

async function deleteAktivitaet() {
  await fetch(`/api/aktivitaeten/${selectAktivitaet.value}`, {
    method: "DELETE",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
  });
  await getAktivitaeten();
}

</script>

<template>
  <div class="d-flex-column container">
    <div class="d-flex justify-content-start align-items-center">
      <i class="fa fa-user icn-space"></i>
      <div>
        <select class="form-select" v-model="selectBenutzer" v-on:change="getWochenplaene()">
          <option value="" selected disabled>Benutzer auswählen</option>
          <option v-for="option in benutzer" :value="option">
            {{ option.name }}
          </option>
        </select>
      </div>
      <form @submit.prevent="addBenutzer">
        <div class="d-flex align-items-center input-group">
          <p>oder: </p>
          <input type="text" v-model="benutzerName" class="form-control"
                 placeholder="Benutzer erstellen" required>
          <button class="btn btn-outline-secondary btn-light btn-bold" type="submit">+</button>
        </div>
      </form>
      <div v-if="successBenutzer"><p><i class="fa fa-check icn-success"></i></p></div>
    </div>

    <div style="height: 1rem;"></div>
    <div v-if="selectBenutzer">
      <div class="d-flex justify-content-start align-items-center">
        <i class="fa fa-calendar icn-space"></i>
        <div v-if="wochenplaene != ''" class="d-flex align-items-center">
          <select class="form-select" v-model="selectWochenplan" v-on:change="getAktivitaeten()">
            <option value="" selected disabled>Wochenplan auswählen</option>
            <option v-for="option in wochenplaene" :value="option">
              {{ option.name }}
            </option>
          </select>
          <p>oder: </p>
        </div>
        <form @submit.prevent="addWochenplan">
          <div class="d-flex align-items-center input-group">
            <input type="text" v-model="wochenplanName" class="form-control"
                   placeholder="Wochenplan erstellen" required>
            <button class="btn btn-outline-secondary btn-light btn-bold" type="submit">+</button>
          </div>
        </form>
        <div v-if="successWochenplan"><p><i class="fa fa-check icn-success"></i></p></div>
      </div>
    </div>

    <div style="height: 3rem;"></div>
    <div v-if="selectWochenplan">
      <h4>/ {{ selectBenutzer.name }} / {{ selectWochenplan.name }}
        <i v-on:click="print()" class="fa fa-print icn-space"></i></h4>
      <table style="width: 100%; border-style: hidden;">
        <tr>
          <td v-for="(wochentag, index) in wochentage"
              style="width: 20%; padding: 0.5rem; background-color: aliceblue; border: solid 0.5rem white; vertical-align: top;">
            <h6>{{ wochentag }}</h6>
            <table style="margin-bottom: 1rem;">
              <tr v-for="aktivitaet in aktivitaeten">
                <td v-if="aktivitaet.wochentag == wochentag">
                  <form @submit.prevent="deleteAktivitaet()">
                    {{ aktivitaet.name }}
                    <button type="submit" style="border: 0; background-color: transparent;"
                            v-on:click="selectAktivitaet=aktivitaet.id"><i class="fa fa-trash"></i>
                    </button>
                  </form>
                </td>
              </tr>
            </table>
            <form @submit.prevent="addAktivitaet">
              <div class="d-flex align-items-center input-group">
                <input type="text" v-model="aktivitaetName[index]"
                       class="form-control form-control-sm"
                       placeholder="Neue Aktivität" v-on:input="aktivitaetWochentag=index" required>
                <button class="btn btn-outline-secondary btn-sm btn-light btn-bold" type="submit">
                  +
                </button>
              </div>
            </form>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<style scoped>
.btn-bold {
  font-weight: normal;
}

.icn-success {
  color: lightseagreen;
}

.icn-space {
  margin: 0 1rem;
  width: 1rem;
  text-align: center;
}

p {
  margin: 0 1rem;
  padding: 0;
}

h4 {
  margin-bottom: 1rem;
}
</style>