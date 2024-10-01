export const dropdownAndDropupCode = `<script setup>
import { ref } from "vue";
//Vue Material Kit 2 Pro components
import MaterialButton from "@/components/MaterialButton.vue";

let showDropdown = ref(false);
let showDropup = ref(false);
</script>
<template>
  <div class="container p-5 m-3 bg-gray-100">
    <div class="row">
      <div class="row">
        <div
          class="col-lg-4 ms-lg-auto col-md-6 col-sm-3 d-flex justify-content-center"
        >
          <div class="dropdown">
            <MaterialButton
              variant="gradient"
              color="success"
              class="dropdown-toggle"
              :class="{ show: showDropdown }"
              @focusout="showDropdown = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdown"
              @click="showDropdown = !showDropdown"
            >
              Dropdown button
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdown }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Action</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Another action</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Something else here</a
                >
              </li>
            </ul>
          </div>
        </div>
        <div
          class="col-lg-4 me-lg-auto col-md-6 col-sm-3 d-flex justify-content-center"
        >
          <div class="btn-group dropup mt-7">
            <MaterialButton
              variant="gradient"
              color="success"
              class="dropdown-toggle"
              :class="{ show: showDropup }"
              data-bs-toggle="dropdown"
              :area-expanded="showDropup"
              @focusout="showDropup = false"
              @click="showDropup = !showDropup">
              Dropup
            </MaterialButton>
            <ul
              class="dropdown-menu px-2 py-3" :class="{ show: showDropup }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Action</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Another action</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >Something else here</a
                >
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
`;

export const selectPickerCode = `<!-- eslint-disable no-unused-vars -->
<script setup>
import { onMounted } from "vue";

// choices js
import Choices from "choices.js";

// hook
onMounted(() => {
  if (document.getElementById("choice-button")) {
    var element = document.getElementById("choice-button");
    const example = new Choices(element, {
      searchEnabled: false,
      allowHTML: true,
    });
  }
});
</script>
<template>
  <div class="container p-5">
    <div class="row">
      <div class="col-3 mx-auto">
        <select
          class="form-control"
          name="choice-button"
          id="choice-button"
          placeholder="Language"
        >
          <option value="Choice 1" selected>Brazil</option>
          <option value="Choice 2">Bucharest</option>
          <option value="Choice 3">London</option>
          <option value="Choice 4">Washington</option>
        </select>
      </div>
    </div>
  </div>
</template>
`;
