const openBooksBtn =
  document.getElementById("openBooks");

openBooksBtn.addEventListener("click", () => {

  if (
    document.querySelector(".books-window")
  ) return;

  const windowEl =
    document.createElement("div");

  windowEl.className =
    "books-window";

  windowEl.innerHTML = `

    <div class="books-header">

      bibliothèque.exe

      <span id="closeBooks">
        ✕
      </span>

    </div>

    <div class="books-content">

      <h3>✦ recommandations ✦</h3>

      <p>
        <strong>Le Petit Prince</strong><br>
        étoiles et solitude.
      </p>

      <p>
        <strong>Coraline</strong><br>
        étrange et magique.
      </p>

      <p>
        <strong>Narnia</strong><br>
        forêts et aventure.
      </p>

      <p>
        <strong>Hamlet</strong><br>
        mélancolie nocturne.
      </p>

    </div>

  `;

  document.body.appendChild(windowEl);

  document
    .getElementById("closeBooks")
    .addEventListener("click", () => {

      windowEl.remove();

    });

  dragWindow(windowEl);

});

function dragWindow(windowEl) {

  const header =
    windowEl.querySelector(".books-header");

  let offsetX = 0;
  let offsetY = 0;

  let dragging = false;

  header.addEventListener("mousedown", (e) => {

    dragging = true;

    offsetX =
      e.clientX - windowEl.offsetLeft;

    offsetY =
      e.clientY - windowEl.offsetTop;

  });

  document.addEventListener("mousemove", (e) => {

    if (!dragging) return;

    windowEl.style.left =
      `${e.clientX - offsetX}px`;

    windowEl.style.top =
      `${e.clientY - offsetY}px`;

  });

  document.addEventListener("mouseup", () => {

    dragging = false;

  });

}