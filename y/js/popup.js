

const popupMessages = [

  "🌧 il pleut dehors.",

  "☕ ton thé refroidit.",

  "⚠ niveau de fantaisie critique.",

  "🐸 la grenouille te surveille.",

  "✨ présence féerique détectée.",

  "💿 vieille nostalgie internet chargée.",

  "🌙 mode nuit recommandé.",

  "📁 souvenir étrange récupéré.",

  "🦋 les forêts respirent encore."

];

function createPopup() {

  const popup =
    document.createElement("div");

  popup.className = "fake-popup";

  popup.innerHTML = `

    <div class="popup-header">

      message.exe

      <span class="popup-close">
        ×
      </span>

    </div>

    <div class="popup-content">

      ${
        popupMessages[
          Math.floor(
            Math.random() * popupMessages.length
          )
        ]
      }

    </div>

  `;

  document
    .getElementById("popup-container")
    .appendChild(popup);

  popup
    .querySelector(".popup-close")
    .addEventListener("click", () => {

      popup.remove();

    });

  setTimeout(() => {

    popup.remove();

  }, 9000);

}

setInterval(createPopup, 25000);

const pond =
  document.querySelector(".pond-area");

pond.addEventListener("mousemove", (e) => {

  const ripple =
    document.createElement("div");

  ripple.classList.add("ripple");

  const rect =
    pond.getBoundingClientRect();

  ripple.style.left =
    (e.clientX - rect.left) + "px";

  ripple.style.top =
    (e.clientY - rect.top) + "px";

  pond.appendChild(ripple);

  setTimeout(() => {

    ripple.remove();

  }, 1200);

});
