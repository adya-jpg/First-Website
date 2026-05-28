
let effectMode =
  localStorage.getItem("effectMode")
  || "off";

const toggleButton =
  document.getElementById("toggleTrail");

const trailSymbols =
  ["✦", "⋆", "☾", "❀"];

document.addEventListener("mousemove", (e) => {

  mouseX = e.clientX;
  mouseY = e.clientY;

  // ✨ SPARKLE TRAIL MODE
  if (effectMode === "trail") {

    const sparkle =
      document.createElement("div");

    sparkle.className =
      "cursor-trail";

    sparkle.innerText =
      trailSymbols[
        Math.floor(
          Math.random() *
          trailSymbols.length
        )
      ];

    sparkle.style.left =
      e.pageX + "px";

    sparkle.style.top =
      e.pageY + "px";

    document.body.appendChild(sparkle);

    setTimeout(() => {

      sparkle.remove();

    }, 900);

  }

  // ✨ FIREFLY MODE
  if (effectMode === "fireflies") {

    mouseMoving = true;

    clearTimeout(idleTimer);

    idleTimer = setTimeout(() => {

      mouseMoving = false;

      perchFireflies();

    }, 2500);

  }

});

updateEffectButton();
toggleButton.addEventListener("click", () => {

  if (effectMode === "off") {

    effectMode = "trail";

  } else if (
    effectMode === "trail"
  ) {

    effectMode = "fireflies";

  } else {

    effectMode = "off";

  }

  localStorage.setItem(
    "effectMode",
    effectMode
  );

  updateEffectButton();

});

function updateEffectButton() {


  if (effectMode === "off") {

    toggleButton.textContent =
      "mode : aucun";

  } else if (
    effectMode === "trail"
  ) {

    toggleButton.textContent =
      "mode : étoiles";

  } else {

    toggleButton.textContent =
      "mode : lucioles";

  }

}






function createLeaf() {

  const leaf = document.createElement("div");

  leaf.classList.add("leaf");

const symbols = document.body.classList.contains("night-mode")
  ? ["✦", "⋆", "☾"]
  : ["🍃", "❀", "𓇬"];

leaf.innerHTML =
  symbols[
    Math.floor(Math.random() * symbols.length)
  ];

  leaf.style.left =
    Math.random() * window.innerWidth + "px";

  leaf.style.animationDuration =
    (6 + Math.random() * 6) + "s";

  leaf.style.opacity =
    0.3 + Math.random() * 0.5;

  leaf.style.fontSize =
    (14 + Math.random() * 18) + "px";

  document.body.appendChild(leaf);

  setTimeout(() => {
    leaf.remove();
  }, 12000);

}

setInterval(createLeaf, 900);

const fireflies = [];

const perchTargets =
  document.querySelectorAll(
    "button, a, h1, h2, img, .mini-box, .retro-box"
  );

let mouseX = window.innerWidth / 2;
let mouseY = window.innerHeight / 2;

let mouseMoving = false;
let idleTimer;

for (let i = 0; i < 5; i++) {

  const firefly =
    document.createElement("div");

  firefly.className =
    "firefly-cursor";

  document.body.appendChild(firefly);

  fireflies.push({

    el: firefly,

    x: mouseX,
    y: mouseY,

    targetX: mouseX,
    targetY: mouseY,

    offsetX:
      Math.random() * 60 - 30,

    offsetY:
      Math.random() * 60 - 30,

    perched: false

  });

}

function perchFireflies() {

  fireflies.forEach((firefly) => {

    // pick RANDOM target
    const randomTarget =

      perchTargets[
        Math.floor(
          Math.random() * perchTargets.length
        )
      ];

    const rect =
      randomTarget.getBoundingClientRect();

    // random spot INSIDE target
    firefly.targetX =

      rect.left +
      Math.random() * rect.width;

    firefly.targetY =

      rect.top +
      Math.random() * rect.height;

    firefly.perched = true;

  });

}
function animateFireflies() {

  fireflies.forEach((firefly) => {

    // 🌟 TRAIL MODE
    if (effectMode !== "fireflies") {

      firefly.el.style.display = "none";

    } else {

      // 🌿 SHOW FIREFLIES
      firefly.el.style.display = "block";

      // 🌿 FOLLOW CURSOR
      if (mouseMoving) {

        firefly.targetX =
          mouseX + firefly.offsetX;

        firefly.targetY =
          mouseY + firefly.offsetY;

        firefly.perched = false;

      }

      // 🌿 SPEED
      const speed = mouseMoving
        ? 0.02
        : 0.003;

      firefly.x +=
        (firefly.targetX - firefly.x)
        * speed;

      firefly.y +=
        (firefly.targetY - firefly.y)
        * speed;

      // 🌿 MOVE
      firefly.el.style.left =
        `${firefly.x}px`;

      firefly.el.style.top =
        `${firefly.y}px`;

    }

  });

  requestAnimationFrame(
    animateFireflies
  );

}

animateFireflies();