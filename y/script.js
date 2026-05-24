
const frog = document.getElementById("frog");

const frogText =
  document.getElementById("frogText");

const frogMessages = [

  "la pluie est jolie ce soir.",

  "hydrate-toi s'il te plaît.",

  "tu codes encore à minuit ?",

  "les forêts cachent des secrets.",

  "ce site devient dangereux.",

  "tu devrais probablement dormir.",

  "les étoiles te regardent.",

  "le thé refroidit encore.",

  "les grenouilles soutiennent ton blogue.",

  "la nostalgie internet est éternelle.",

  "↑ ↑ ↓ ↓ ... les grenouilles murmurent quelque chose.",

    "← → ← → ... étrange.",

    "les anciens visiteurs connaissaient un code.",

    "b... a... ?",

    "le bassin répond aux séquences.",

    "essaie les flèches. toutes.",

    "certains secrets nécessitent dix touches.",

    "la forêt aime les tricheurs.",

    "tu es plus proche du secret que tu le crois.",

    "le protocole konami existe encore.",
  

];

frog.addEventListener("click", () => {

  const randomMessage =

    frogMessages[
      Math.floor(
        Math.random() * frogMessages.length
      )
    ];

  frogText.innerText = randomMessage;

});


const nightButton =
  document.getElementById("nightToggle");

nightButton.addEventListener("click", () => {

  document.body.classList.toggle("night-mode");

});

function toggleSound(soundId) {

  const sound =
    document.getElementById(soundId);

  if (sound.paused) {

    sound.play();

  } else {

    sound.pause();

  }

}

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

const konamiCode = [
  "ArrowUp",
  "ArrowUp",
  "ArrowDown",
  "ArrowDown",
  "ArrowLeft",
  "ArrowRight",
  "ArrowLeft",
  "ArrowRight",
  "b",
  "a"
];

let konamiIndex = 0;

document.addEventListener("keydown", (e) => {

  if (e.key === konamiCode[konamiIndex]) {

    konamiIndex++;

    if (konamiIndex === konamiCode.length) {

      showKonamiPopup();
      function showKonamiPopup() {

  const popup = document.createElement("div");

  popup.className = "konami-popup";

  popup.innerHTML = `

    <div class="popup-header">
      système_forestier.exe
    </div>

    <div class="popup-content">

      <p>
        ⚠ anomalie détectée ⚠
      </p>

      <p>
        le bassin des grenouilles s'éveille...
      </p>

      <button id="popupContinue">
        continuer
      </button>

    </div>

  `;

  document.body.appendChild(popup);

  document
    .getElementById("popupContinue")
    .addEventListener("click", () => {

      popup.remove();

      activateSecretGame();

    });

}

      konamiIndex = 0;
    }

  } else {

    konamiIndex = 0;

  }

});

function activateSecretGame() {

  const gameWindow = document.createElement("div");

  gameWindow.className = "secret-window";

  gameWindow.innerHTML = `
    <div class="window-header">
      grenouille.exe
    </div>

    <div class="window-content">
      <canvas id="frogGame" width="500" height="300"></canvas>

      <button id="closeGame">
        fermer
      </button>
    </div>
  `;

  document.body.appendChild(gameWindow);

  document
    .getElementById("closeGame")
    .addEventListener("click", () => {

      gameWindow.remove();

    });

  startFrogGame();

}
function startFrogGame() {

  const canvas =
    document.getElementById("frogGame");

  const ctx = canvas.getContext("2d");

  let frogX = 220;
  let frogY = 220;

  const flies = [];

  for (let i = 0; i < 6; i++) {

    flies.push({

      x: Math.random() * 460,
      y: Math.random() * 260

    });

  }

  document.addEventListener("keydown", moveFrog);

  function moveFrog(e) {

    if (e.key === "ArrowLeft")
      frogX -= 12;

    if (e.key === "ArrowRight")
      frogX += 12;

    if (e.key === "ArrowUp")
      frogY -= 12;

    if (e.key === "ArrowDown")
      frogY += 12;

  }

  function draw() {

    ctx.clearRect(0, 0, 500, 300);

    flies.forEach((fly) => {

      ctx.fillStyle = "#fff6a9";

      ctx.beginPath();

      ctx.arc(fly.x, fly.y, 4, 0, Math.PI * 2);

      ctx.fill();

      if (

        Math.abs(frogX - fly.x) < 18 &&
        Math.abs(frogY - fly.y) < 18

      ) {

        fly.x = Math.random() * 460;
        fly.y = Math.random() * 260;

      }

    });

    ctx.fillStyle = "#8df58d";

    ctx.fillRect(frogX, frogY, 20, 20);

    requestAnimationFrame(draw);

  }

  draw();

}