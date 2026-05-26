

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
const isNight =
  document.body.classList.contains("night-mode");

const frogColor = isNight
  ? "#8ecfff"
  : "#8df58d";

const flyColor = isNight
  ? "#d6ecff"
  : "#fff6a9";
  function draw() {

    ctx.clearRect(0, 0, 500, 300);
    const isNight =
  document.body.classList.contains("night-mode");

ctx.fillStyle = isNight
  ? "#081a38"
  : "#1d4d34";

ctx.fillRect(0, 0, 500, 300);

    flies.forEach((fly) => {

      ctx.fillStyle = flyColor;

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

    ctx.fillStyle = frogColor;

    ctx.fillRect(frogX, frogY, 20, 20);

    requestAnimationFrame(draw);

  }

  draw();

}
