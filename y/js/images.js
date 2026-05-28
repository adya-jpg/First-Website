function openMemoryImage(imageSrc, title) {

  const windowBox =
    document.createElement("div");

  windowBox.className =
    "memory-window";

  windowBox.style.left =
    (120 + Math.random() * 200)
    + "px";

  windowBox.style.top =
    (100 + Math.random() * 120)
    + "px";

  windowBox.innerHTML = `

    <div class="memory-header">

      <span>${title}</span>

      <button class="memory-close">
        ×
      </button>

    </div>

    <div class="memory-content">

      <img
        src="${imageSrc}"
        class="memory-image"
      >

    </div>

  `;

  document.body.appendChild(windowBox);

  makeWindowDraggable(windowBox);

  windowBox
    .querySelector(".memory-close")
    .addEventListener("click", () => {

      windowBox.remove();

    });

}

function makeWindowDraggable(windowEl) {

  const header =
    windowEl.querySelector(
      ".memory-header"
    );

  let offsetX = 0;
  let offsetY = 0;

  let dragging = false;

  header.addEventListener(
    "mousedown",
    (e) => {

      dragging = true;

      offsetX =
        e.clientX -
        windowEl.offsetLeft;

      offsetY =
        e.clientY -
        windowEl.offsetTop;

    }
  );

  document.addEventListener(
    "mousemove",
    (e) => {

      if (!dragging) return;

      windowEl.style.left =
        (e.clientX - offsetX)
        + "px";

      windowEl.style.top =
        (e.clientY - offsetY)
        + "px";

    }
  );

  document.addEventListener(
    "mouseup",
    () => {

      dragging = false;

    }
  );

}